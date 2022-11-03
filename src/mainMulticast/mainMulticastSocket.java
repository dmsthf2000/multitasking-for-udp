package mainMulticast;

import m2hackathon.accessMulticast.SetMultiSocket;

import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class mainMulticastSocket
{
    public void init(String team)
    {
        MulticastSocket teamSocket = null;

        //멀티캐스트 팀소켓 생성
        SetMultiSocket sm = new SetMultiSocket();
        teamSocket = sm.getMulticastSocket(team);

        //임의의 멀티캐스트 ip 지정
        try {
            InetAddress address = InetAddress.getByName("224.128.1.5");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
