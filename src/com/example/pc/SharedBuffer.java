package com.example.pc;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    private final Queue<Integer> buffer = new LinkedList<>();
    private  int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    /*
    Method is synchronized
    Can be executed only by one thread for this buffer
     */
    public synchronized void produce(int item) throws InterruptedException {
        while(buffer.size() == capacity) {
            System.out.println("Buffer capacity full, please wait");
            wait();
        }

        buffer.add(item);
        System.out.println("Produced :" +  item);

        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while(buffer.isEmpty()) {
            System.out.println("Buffer is empty, consumer is still waiting");
            wait();
        }

        int item =  buffer.poll();
        System.out.println("Consumed: "+ item);
        notifyAll();

        return item;
    }
}
