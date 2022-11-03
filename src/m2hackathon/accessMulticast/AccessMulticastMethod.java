package m2hackathon.accessMulticast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class AccessMulticastMethod {
//    private int port;

    //내 컴퓨터 ip주소
    public String getLocalIp() {

        InetAddress local = null;
        try {
            local = InetAddress.getLocalHost();
        }
        catch ( UnknownHostException e ) {
            e.printStackTrace();
        }

        if( local == null ) {
            return "";
        }
        else {
            String ip = local.getHostAddress();
            return ip; //내 ip주소에서 마지막 3글자 출력
        }
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //내 ip주소 확인
        AccessMulticastMethod a = new AccessMulticastMethod();
        a.getLocalIp();
        System.out.println(a.getLocalIp());


//        //현재 열려있는 포트 확인
//        for(int i = 1024; i < 65536; i++){
//            try{
//                ServerSocket ss = new ServerSocket(i);
//                    ss.close();
//            }catch (IOException ee){
//                System.out.println(i);
//            }
//        }
//        List<Integer> intar = a.AvailablePort();
//        System.out.println(intar.toString());

//        System.out.println(a.AvailablePort());
    }
}
