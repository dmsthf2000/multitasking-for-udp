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
    private int setPort(String team) {
        switch (team){
            case "A":
                return 7000;
            case "B":
                return 7001;
            case "C":
                return 7002;
            default:
                return -1;
        }
    }

    //사용 가능한 포트번호를 리스트로 출력(추후에 사용 예정)
//    public List<Integer> AvailablePort() {
//        List<Integer> portArray = new ArrayList<>();
//        for (int i = 1024; i < 65536; i++) {
//            try {
//                ServerSocket ss = new ServerSocket(i);
//                ss.close();
//            } catch (IOException ee) {
//                portArray.add(i);
//                break;
//            }
//        }
//        return portArray;
//    }
}