public class Turista extends Thread {
    Museo museo;

    public Turista(String cognome, Museo m) {
        super(cognome);
        museo = m;
    }

    @Override
    public void run() {
        try {
            int tempoAttesa = (int) (Math.random() * 1000 + 2000);
            int tempoVisita = (int) (Math.random() * 4000 + 1000);
            System.out.println(tempoAttesa);
            sleep(tempoAttesa);
            museo.entra(tempoVisita);
            sleep(tempoVisita);
            museo.esce();
        } catch (InterruptedException e) {}
    }
}
