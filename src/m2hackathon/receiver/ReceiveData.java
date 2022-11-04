package m2hackathon.receiver;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.nio.charset.Charset;

public class ReceiveData
{
    DatagramPacket receivedPacket;

    public void receiveDataToSender(MulticastSocket mulSocket)
    {
        byte[] receivedData = new byte[65508];
        receivedPacket = new DatagramPacket(receivedData, receivedData.length);
        try
        {
            mulSocket.receive(receivedPacket);
        }
        catch (IOException e)
        {
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
        if(receivedPacket == null || receivedPacket.getData().length < 1)
            return null;

        Charset charset = Charset.defaultCharset();
        return new String(receivedPacket.getData(), charset).trim();
    }
}
