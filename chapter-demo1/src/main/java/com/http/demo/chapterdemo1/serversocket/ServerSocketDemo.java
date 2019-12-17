package com.http.demo.chapterdemo1.serversocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author deke
 * @description socket f服务端
 * @date 2019/12/16
 */
public class ServerSocketDemo {

    private static ServerSocket serverSocket;
    private static PrintWriter out = null;

    public static void main(String[] args) {
        try {
            //服务端一定需要去监听一个端口号，ip默认就是本机的ip地址
            //ip:port
            serverSocket = new ServerSocket(8080);
            //阻塞式的接受客户端的连接
            Socket socket = serverSocket.accept();
            //拿到输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获取客户端的输入信息
            System.out.println("Client:"+in.readLine());

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            String line = sin.readLine();
            while (!line.equals("bye")){
                out.println(line);
                //读取客户端传过来的数据
                System.out.println("client:"+in.readLine());
                //重新读取控制台的数据
                line = sin.readLine();
            }


            socket.close();
            in.close();
            out.close();
            sin.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
