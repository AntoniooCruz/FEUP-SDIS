import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Peer {

    private static int serverId;
    private static String peerId;
    private static String peerAcessPoint;
    private static String protocolVersion;
    private static  MultiCast MC;
    private static  MultiCast MDB;
    private static  MultiCast MDR;
    private static Storage storage;

    public static void main(String args[]) throws IOException {


        initAtributes(args);

        createDir();

        //    while(true) {
                byte[] duriola = { (byte)0xe0, 0x4f };
            	Message teste = new Message("1.0", Integer.parseInt(peerId), 4, 6, 6, duriola );
            	teste.createPutChunk();
          //  }


    }

    private static void initAtributes(String[] args) throws IOException {
        protocolVersion = args[0];
        serverId = Integer.parseInt(args[1]);
        peerId = args[2];
        MC = new MultiCast(args[3],args[4]);
        MDB = new MultiCast(args[5],args[6]);
        MDR = new MultiCast(args[7],args[8]);

        new Thread(MC).start();
        new Thread(MDB).start();
        new Thread(MDR).start();
    }

    private static void createDir(){

        String backupDirName = "peerDisk/peer" + peerId + "/backup";
        String restoreDirNam = "peerDisk/peer" + peerId + "/restored";
        new File("./" + backupDirName).mkdirs();
        new File("./" + restoreDirNam).mkdirs();

    }

    private static void initPeer(String args[]){

    }

    public static MultiCast getMC() { return MC;}

	public static String getPeerId() {
		return peerId;
	}


    public static MultiCast getMDR() {
        return MDR;
    }

    public static MultiCast getMDB() {
        return MDB;
    }
}