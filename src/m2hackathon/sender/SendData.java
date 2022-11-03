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
        }
        catch (UnknownHostException e) {throw new RuntimeException(e);}

        //startMsg
        String startMsg = "start / " + localAddress;
        DatagramPacket startPacket = makePacket(startMsg, multicastAddress, multicastPort);

        System.out.println("dataMsg : " + dataMsg);
        //dataMsg
        DatagramPacket dataPacket = makePacket(dataMsg, multicastAddress, multicastPort);

        //endMsg
        String endMsg = "end / " + localAddress;
        DatagramPacket endPacket = makePacket(endMsg, multicastAddress, multicastPort);

        try
        {
//            mulSocket.send(startPacket);
            mulSocket.send(dataPacket);
//            mulSocket.send(endPacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private DatagramPacket makePacket(String sendMsg, InetAddress multicastAddress, int multicastPort)
    {
        DatagramPacket sendPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.length(), multicastAddress, multicastPort);
        return sendPacket;
    }
}