package solutions.threadTest;

import java.util.function.Consumer;

/**
 * Created by yael on 12/01/17.
 */
public class TestThread implements Runnable {

    private Consumer<Object> consumer;

    public TestThread( Consumer<Object> consumer){
        this.consumer = consumer;
    }

    @Override
    public void run(){
        consumer.accept(null);
    }
}