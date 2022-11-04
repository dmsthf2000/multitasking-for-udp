package m2hackathon.receiver;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReceiveData
{
    DatagramPacket receivedPacket;

    public void receiveDataToSender(MulticastSocket mulSocket)
    {
        byte[] receivedData = new byte[65508];
        receivedPacket = new DatagramPacket(receivedData, receivedData.length);
        try
        {
            mulSocket.receive(receivedPacket);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public String getData()
    {
        if(receivedPacket == null || receivedPacket.getData().length < 1)
            return null;

        Charset charset = Charset.forName("utf-8");
        return new String(receivedPacket.getData(), charset).trim();
    }

    public SocketAddress getSender()
    {
        if(receivedPacket == null)
            return null;

        return receivedPacket.getSocketAddress();
    }

    public String getDate()
    {
        if(receivedPacket == null)
            return null;

        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate now = LocalDate.now();

        // 연도, 월(문자열, 숫자), 일, 일(year 기준), 요일(문자열, 숫자)
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();

        String date = year + "년 " + monthValue + "월" + dayOfMonth + "일";
        return date;
    }

    public String getTime()
    {
        if(receivedPacket == null)
            return null;

        // 포맷 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
        // 포맷 적용하기
        String formatedNow = LocalTime.now().format(formatter);

        return formatedNow;
    }
}
