import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Administrator on 2019/6/17.
 */
public final class b {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("www.hxtc.com", 21201);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println("GET /1.html  / HTTP/1.1");
        pw.println("Accept: */*");
        pw.println("Host: localhost:8888");
        pw.println("Connection: Keep-Alive");
        pw.println("");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

    }
}
