package m2hackathon.mainMulticast;

import m2hackathon.view.RecView;
import m2hackathon.accessMulticast.SetMultiSocket;
import m2hackathon.receiver.ReceiveData;
import m2hackathon.sender.SendData;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MainMulticastSocket
{
    MulticastSocket teamSocket = null;
    InetAddress address = null;
    public void init(String team)
    {
        //멀티캐스트 팀소켓 생성
        SetMultiSocket sm = new SetMultiSocket();
        teamSocket = sm.getMulticastSocket(team);

        //임의의 멀티캐스트 ip 지정
        try {
            address = InetAddress.getByName("224.128.1.5");
            teamSocket.joinGroup(address);
            Thread th5 = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("5");
                            receiveMessage();
                        }
                    }
            );
            th5.start();

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


        Thread sender = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("5");

                        SendData sendData = new SendData();
                        System.out.println("nowPort : "+teamSocket.getLocalPort());
                        System.out.println("address : "+address.getHostAddress());
                        sendData.sendDataToRecevier(teamSocket, address, 3000, msg);
                    }
                }
        );
        sender.start();

    }

    public void receiveMessage()
    {
        ReceiveData receiveData = new ReceiveData();
        receiveData.receiveDataToSender(teamSocket);
        String msg = receiveData.getData();
        SocketAddress sender = receiveData.getSender();
        ArrayList<String> receiveArray = new ArrayList<>();
        if(msg != null || msg.length() > 0)
        {
            receiveArray.add(msg);
            receiveArray.add(sender.toString());
        }
        if(receiveArray.size()>0)
            new RecView(receiveArray);
    }
}
