import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


class Recipient{
    public static void main(String[] args) throws IOException {
        boolean exit = false;
        DatagramSocket ds = new DatagramSocket(2390);
                while (!exit) {
                    DatagramPacket pack = new DatagramPacket(new byte[16], 16);
                    ds.receive(pack);
                    String message = new String(pack.getData());
                    if (message.startsWith("exit")) {
                        exit = true;
                        System.out.println("Connect is close.");
                        ds.close();
                    } else {
                        System.out.println(message);
                    }
                }
    }
}

