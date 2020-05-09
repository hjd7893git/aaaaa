import java.io.*;
import java.net.Socket;

import static java.lang.System.in;

/**
 * Created by Administrator on 2019/6/11.
 */
public class e {
    public static void main(String[] args) throws IOException {
        String mesg = "0001793f6abfcf-3af1-11e8-8f91-507b9ddd8bdc07console02A02{\"keySchema\":\"Y\",\"ZMKSchema\":\"Y\",\"keyValue\":\"YDFCCB1E0C884682181542E90EE91F2AFBE2AB5FFCFE1981E\",\"keyCode\":\"000\",\"createMode\":\"1\"}";
        Socket socket = new Socket("192.168.0.200", 21205);
        OutputStream out = socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.write(mesg.getBytes());
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        out.close();
        out.flush();
        br.close();

99999999999999999

    }
}