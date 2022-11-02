package m2hackathon.sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SendData
{
    private static void sendDataToRecevier(MulticastSocket mulSocket, String data, InetAddress multicastAddress, int multicastPort)
    {
        DatagramPacket sendPacket = new DatagramPacket(data.getBytes(), data.length(), multicastAddress, multicastPort);

        try
        {
            mulSocket.send(sendPacket);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
