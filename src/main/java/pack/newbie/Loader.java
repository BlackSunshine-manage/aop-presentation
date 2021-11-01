package pack.newbie;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Loader {
    static Lock lock = new ReentrantLock();

    static BusinessTask businessTask = new BusinessTask(lock,true, (byte) 12,"id");
    private static final String processId = "1";
    public static void main(String[] args) throws Exception {
        Hello hi = new Hello();
        hi.receive(processId, businessTask);
        System.out.println("\n\n\n\n");
        hi.receiveWithAspect(processId, businessTask);
    }
}
