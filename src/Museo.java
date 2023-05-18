public class Museo {
    int PostiMax;
    int PostiOccupati = 0;
    String blu = "\u001B[36m";
    String verde = "\u001B[32m";
    String rosso = "\u001B[31m";
    String giallo = "\u001B[33m";
    String reset = "\u001B[0m";

    public Museo(int PostiMax) {
        this.PostiMax = PostiMax;
    }

    public synchronized void entra(int tempoVisita) {
        String ThreadName = Thread.currentThread().getName();

        while (PostiOccupati >= PostiMax) {
            try {
                System.out.println(giallo + ThreadName + " sta aspettando che un posto si liberi");
                wait();
            } catch (InterruptedException e) {
            }
        }
        PostiOccupati++;
        System.out.println(blu + ThreadName + " e' entrato nel museo, posti occupati: " + rosso + PostiOccupati + reset +
                          "\ntempo di visita previsto: " + verde + (float)tempoVisita/1000 + "s\n");        
    }

    public synchronized void esce() {
        String ThreadName = Thread.currentThread().getName();
        PostiOccupati--;
        System.out.println("\n" + blu + ThreadName + " ha visto la gioconda ed esce dal museo, posti occupati: " + verde + PostiOccupati + "\n");
        notifyAll();
    }
}
