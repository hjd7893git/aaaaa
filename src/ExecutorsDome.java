
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutorsDome {

    private List<WorkThread> workThreads;
    private BlockingQueue<Runnable> taskRunables;
    private volatile Boolean isWorking = true;

    public ExecutorsDome(int workThreads, int taskRunables) {
        this.taskRunables = new LinkedBlockingQueue<>(taskRunables);
        this.workThreads = new ArrayList<WorkThread>();
        for (int i = 0; i < workThreads; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            this.workThreads.add(workThread); //����
        }
    }

    public boolean execute(Runnable runnable) {
        //2������execute�ķ���ʱ��������뵽������
        return taskRunables.offer(runnable);
    }

    public void shodn() {
        this.isWorking = false;
    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            while (isWorking || taskRunables.size() > 0) {
                //3�������е��̲߳��ϴӶ��л�ȡ����
                Runnable task = taskRunables.poll();
                if (task != null) {
                    task.run();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorsDome executorsDome = new ExecutorsDome(3, 6);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executorsDome.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "����ʼ��" + finalI);
                }
            });
        }
        executorsDome.shodn();
    }


}
