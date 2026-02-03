import java.util.Random;
import static java.lang.Thread.sleep;

public class Producer_mult implements Runnable {
    
    private Queue1 queue1;
    //private int numProd;

    //Costruttore della classe Producer
    public Producer_mult(Queue1 queue1/*, int numProd*/){
        this.queue1 = queue1;
        //this.numProd = numProd;
    }

    //Creazione oggetto della classe Random
    Random random = new Random();

    @Override
    public void run() {

        for(int i = 0; i < 5 /*numProd*/; i++){

            int prodotto = random.nextInt(100);

            //Si simula qui che i programma ci metta 2 secondi a produrre
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //Inserimento del prodotto nella coda
            try {
                queue1.semaforoProducer.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            queue1.coda.add(prodotto);
            System.out.println("Producer: " + prodotto);

            queue1.semaforoConsumer.release(); //dice al consumer che ha messo un valore nella scatola
        }
    }
}