package m2hackathon.sender;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;

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
        Charset charset =  Charset.defaultCharset();
        byte[] bytes = sendMsg.getBytes(charset);
        DatagramPacket sendPacket = null;
        sendPacket = new DatagramPacket(bytes, bytes.length, multicastAddress, multicastPort);

        return sendPacket;
    }
}

