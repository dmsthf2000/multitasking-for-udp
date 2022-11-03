package m2hackathon.accessMulticast;

import java.io.IOException;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class SetMultiSocket
{
    public MulticastSocket getMulticastSocket(String team)
    {
        MulticastSocket socket = null;

        try
        {
            //port 가져와서 멀티캐스트 생성
            socket = new MulticastSocket(setPort(team));
        }
        catch (UnknownHostException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return socket;
    }

    //GUI에서 받은 값으로 임의의 포트를 지정
    public int setPort(String team) {
        switch (team){
            case "A":
                return 7000;
            case "B":
                return 7001;
            case "C":
                return 7002;
            case "D":
                return 7003;
            case "E":
                return 7004;
            case "F":
                return 7005;
            default:
                return -1;
        }
    }
}