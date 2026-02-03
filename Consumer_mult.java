public class Consumer_mult implements Runnable {

    private Queue1 queue1;


    public Consumer_mult(Queue1 queue1){
        this.queue1 = queue1;
    }

    @Override
    public void run(){

        for(int i = 0 ;i < 5; i++){

            try {
                queue1.semaforoConsumer.acquire();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int prodotto = queue1.coda.remove();

            System.out.println("Consumatore: " + prodotto);
            System.out.println("");

            queue1.semaforoProducer.release();
        }
    }
}


            //Per controllare se il producer aspetta che il consumer prelevi il valore dalla scatola
             /* try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } */