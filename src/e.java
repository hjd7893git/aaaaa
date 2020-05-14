import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2019/6/11.
 */

public class e {
    public static void main(String[] args) throws IOException {
        //线程池
        ExecutorService service = Executors.newFixedThreadPool(2); //定长
        ExecutorService executorService = Executors.newCachedThreadPool();   //可缓存
        for (int i = 0; i < 10; i++) {
            int sr3 = rest();
            int finalI = i;
            service.execute(() -> System.out.println(Thread.currentThread().getName() + ">>>" + finalI));
        }

    }

    public static int rest() {
        return 23;
    }
}