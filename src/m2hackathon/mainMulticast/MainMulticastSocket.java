package m2hackathon.mainMulticast;

import m2hackathon.view.LogView;
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
import java.util.List;

public class MainMulticastSocket
{
    MulticastSocket teamSocket = null;
    SetMultiSocket sm = new SetMultiSocket();
    InetAddress address = null;
    ReceiveData receiveData = new ReceiveData();

    public void init(String team)
    {
        //멀티캐스트 팀소켓 생성
        teamSocket = sm.getMulticastSocket(team);

        //임의의 멀티캐스트 ip 지정
        try {
            address = InetAddress.getByName("239.0.0.1");
            //멀티캐스트 접속
            teamSocket.joinGroup(address);
            //데이터 수신 기다리는 코드
            Thread receiver = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("receiver start");

                            //데이터를 받은 후 다시 데이터를 받기위해 기다림
                            while(true)
                                receiveMessage();
                        }
                    }
            );
            receiver.setName("receiverThread");
            receiver.start();

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

    public void leaveGroup()
    {
        try
        {
            teamSocket.leaveGroup(address);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    //데이터 송신하는 부분
    public void sendMessage(ArrayList<String> sendList, String msg)
    {
        Thread sender = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("sender start");

                        //team 값을 port로 변환
                        List<Integer> portArray = new ArrayList<>();
                        portArray = getPortArray(sendList);

                        //선택한 모든 port에 데이터 전송
                        SendData sendData = new SendData();
                        for(int i = 0; i < portArray.size(); i++)
                        {
                            sendData.sendDataToRecevier(teamSocket, address, portArray.get(i), msg);
                        }
                    }
                }
        );
        sender.setName("senderThread");
        sender.start();

    }

    private List<Integer> getPortArray(List<String> sendList)
    {
        List<Integer> portArray = new ArrayList<>();
        for(int i = 0; i < sendList.size(); i++)
        {
            portArray.add(sm.setPort(sendList.get(i)));
        }

        return portArray;
    }

    public void receiveMessage()
    {
        receiveData.receiveDataToSender(teamSocket);

        String msg = receiveData.getData();
        SocketAddress sender = receiveData.getSender();
        String date = receiveData.getDate();
        String time = receiveData.getTime();

        ArrayList<String> receiveArray = new ArrayList<>();
        if(msg != null || msg.length() > 0)
        {
            receiveArray.add(msg);
            receiveArray.add(sender.toString());
            receiveArray.add(date);
            receiveArray.add(time);
        }

        if(receiveArray.size()>0) {
            receiveData.addLogDataArray(receiveArray);
            new RecView(receiveArray);
        }
    }

    public void getAllData()
    {
        new LogView(receiveData.getLogDataArray());
    }
}
