package m2hackathon.mainMulticast;

import m2hackathon.accessMulticast.SetMultiSocket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MainMulticastSocket
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
            teamSocket.joinGroup(address);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(ArrayList<String> sendList, String msg)
    {
        System.out.println("sendList : " + sendList.toString());
        System.out.println("msg : " + msg);

    }
}
