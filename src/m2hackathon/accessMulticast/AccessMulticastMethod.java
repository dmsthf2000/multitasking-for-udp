package m2hackathon.accessMulticast;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AccessMulticastMethod {
    public String getServerIp() {

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
            String result = ip.substring(ip.length()-3, ip.length());
            return result; //내 ip주소에서 마지막 3글자 출력
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AccessMulticastMethod a = new AccessMulticastMethod();
        a.getServerIp();
        System.out.println(a.getServerIp());
    }
}
