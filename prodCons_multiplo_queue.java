public class prodCons_multiplo_queue {
    public static void main(String[] args) {

        Queue1 queue1 = new Queue1();

        //for(int i = 0; i < 5; i++) {
            //Il numero di prodotti da produrre è definito nella classe Producer
            Producer_mult p = new Producer_mult(queue1/*, 4 */);
            Thread t1 = new Thread(p);
            t1.start();
        //}

        Consumer_mult c = new Consumer_mult(queue1);
        Thread t2 = new Thread(c);
        t2.start();
    }
}