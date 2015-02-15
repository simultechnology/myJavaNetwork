package com.simultechnology.network.three.single;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/07/20
 * Time: 8:49
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionHandler implements Runnable {

    private Socket socket;
    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        handleConversation(this.socket);
    }
    public void handleConversation(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            System.out.println(inputStream);

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(inputStream));
            String line = br.readLine();
            line = URLDecoder.decode(line, StandardCharsets.UTF_8.name());
            String[] splits = line.split("\\s");
            line = splits[1];
            int index = line.indexOf("?");
            line = line.substring(index + 1);
            System.out.println(line);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(line.getBytes());
            outputStream.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                System.out.println("close!!");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
