package pack.newbie;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;

@Data
@NoArgsConstructor
public class BusinessTask {
    private Lock lock;
    private boolean needPutInCache = false;
    private byte innerCount = 10;
    private String id;

    public String process() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println(this);
        return this.toString();
    }

    public BusinessTask(Lock lock, boolean needPutInCache, byte innerCount, String id) {
        this.lock = lock;
        this.needPutInCache = needPutInCache;
        this.innerCount = innerCount;
        this.id = id;
    }

    public Lock getLock() {
        return lock;
    }

    public boolean isNeedPutInCache() {
        return needPutInCache;
    }

    public byte getInnerCount() {
        return innerCount;
    }

    public String getId() {
        return id;
    }

    public void throwException() throws Exception{
        throw  new Exception("Message exception in class ["+getClass()+"]");
    }
}
