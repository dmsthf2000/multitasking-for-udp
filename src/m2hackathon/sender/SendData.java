package m2hackathon.sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class SendData
{
    public void sendDataToRecevier(MulticastSocket mulSocket, InetAddress multicastAddress, int multicastPort, String dataMsg)
    {
        String localAddress = "";
        try
        {
            localAddress = InetAddress.getLocalHost().getHostAddress();

            //dataMsg
            DatagramPacket dataPacket = makePacket(dataMsg, multicastAddress, multicastPort);

            mulSocket.send(dataPacket);
        }
        catch (UnknownHostException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    private DatagramPacket makePacket(String sendMsg, InetAddress multicastAddress, int multicastPort)
    {
        DatagramPacket sendPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.length(), multicastAddress, multicastPort);
        return sendPacket;
    }
}