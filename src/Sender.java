import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class Sender {

    private String host;
    private int port;

    public Sender(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private void sendMessage(String mes) {
        try {
            byte[] data = mes.getBytes();
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket pack =
                    new DatagramPacket(data, data.length, address, port);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pack);
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        Sender send = new Sender("localhost", 2390);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String message = reader.readLine();

        while (!message.equals("exit")) {
            send.sendMessage(message);
            message = reader.readLine();
        }
        send.sendMessage("exit");
        reader.close();
        System.out.println("Connect is close. By.");
    }
}