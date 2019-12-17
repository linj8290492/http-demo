package com.http.demo.chapterdemo1.serversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author deke
 * @description socket客户端
 * @date 2019/12/16
 */
public class ClientSocketDemo {

    public static void main(String[] args) {
        Socket socket=null;
        PrintWriter out = null;
        try {
            //获取一个本地的连接
            socket = new Socket("localhost", 8080);

            //在当前链接上写入输入
            out = new PrintWriter(socket.getOutputStream(),true);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

            String line = sin.readLine();
            while (!line.equals("bye")){
                out.println(line);
                //读取客户端传过来的数据
                System.out.println("server:"+in.readLine());
                //重新读取控制台的数据
                line = sin.readLine();
            }

            out.println("Hello 林俊");




        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
