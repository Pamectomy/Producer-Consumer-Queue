import java.util.concurrent.Semaphore;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {

    public Semaphore semaforoProducer = new Semaphore(5);
    public Semaphore semaforoConsumer = new Semaphore(0);

    Queue<Integer> coda = new LinkedList<Integer>();
}