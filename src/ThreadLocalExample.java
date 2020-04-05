import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {

    // SimpleDateFormat is not thread-safe, so give one to each thread
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(obj,""+ i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }
    @Override
    public void run() {
        System.out.println("Thread Name=" + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name=" + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
        System.out.println(formatter2.get().toPattern());
    }

    //ThreadLocal nem java 8 method withInitial()
    private static final ThreadLocal<SimpleDateFormat> formatter2 = ThreadLocal.<SimpleDateFormat>withInitial(
            (() -> {return new SimpleDateFormat("yy.MM.dd hh.mm");})
    );
}
