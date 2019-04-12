package testapp;

import peer.RMIStub;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestApp {

    public static void main(String args[]) throws RemoteException, NotBoundException {

        String peerId = args[0];
        String protocol = args[1];

        String operand1 = null, operand2;

        Registry registry = LocateRegistry.getRegistry("localhost");
        RMIStub stub = (RMIStub) registry.lookup(peerId);

        System.out.println("Initiation Peer : " + peerId + "\n" + "Protocol : " + protocol);

        switch (protocol){
            case "BACKUP":
                operand1 = args[2];
                operand2 = args[3];
                stub.backupProtocol(operand1, Integer.parseInt(operand2));
                break;
            case "RESTORE":
                operand1 = args[2];
                stub.restoreProtocol(operand1);
                break;
            case "DELETE":
                stub.deleteProtocol(operand1);
                break;

        }
    }
}