package m2hackathon.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.SocketAddress;

public class ReceiveData
{
    DatagramPacket receivedPacket;

    public void receiveDataToSender(MulticastSocket mulSocket)
    {
        byte[] receivedData = new byte[65508];
        receivedPacket = new DatagramPacket(receivedData, receivedData.length);
        System.out.println("received Data : " + new String(receivedPacket.getData()).trim());
        try {
            mulSocket.receive(receivedPacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SocketAddress getSender()
    {
        if(receivedPacket == null)
            return null;

        return receivedPacket.getSocketAddress();
    }

    public String getData()
    {

        System.out.println("received Data getData(): " + new String(receivedPacket.getData()).trim());
        if(receivedPacket == null || receivedPacket.getData().length < 1)
            return null;

        return new String(receivedPacket.getData()).trim();
    }
}
