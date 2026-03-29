import com.example.pc.Consumer;
import com.example.pc.Producer;
import com.example.pc.SharedBuffer;

public class Main {
    public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer(5);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();;
        consumerThread.start();
    }
}