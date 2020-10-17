package com.example.semana9;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPConnection extends  Thread{

    private DatagramSocket socket;

    public void run(){
        try {
            socket = new DatagramSocket(6000);
            while (true) {
                byte[] buffer = new byte[100];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                System.out.println("Waiting datagram");
                socket.receive(packet);
                String msg = new String(packet.getData()).trim();
                Log.e(">>>", msg);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String mensa){
        new Thread(
                ()->{
                    try {
                        InetAddress ip = InetAddress.getByName("127.0.0.1");
                        DatagramPacket packette = new DatagramPacket(mensa.getBytes(), mensa.getBytes().length, ip, 5000);
                        socket.send(packette);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
