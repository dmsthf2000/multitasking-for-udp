package m2hackathon.sender;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class ReceiverList
{
    private InetAddress getMultiCastAddress(String address)
    {
        InetAddress multicastAddress = null;
        try
        {
            multicastAddress = InetAddress.getByName(address);
        }
        catch (UnknownHostException e)
        {
            throw new RuntimeException(e);
        }

        return multicastAddress;
    }

    private void getMulticastSocket(int multicastPort)
    {
        //멀티캐스트 리스트 가져와서 ip와 port 출력
        try {
            MulticastSocket mulSocket = new MulticastSocket(multicastPort);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
