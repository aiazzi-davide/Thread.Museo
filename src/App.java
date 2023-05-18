import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        int numTuristi = 20;
        Museo museo1 = new Museo(5);

        ArrayList<Turista> turisti = new ArrayList<>();
        for (int i = 0; i < numTuristi; i++) {
            Turista t = new Turista("Turista" + (i + 1), museo1);
            turisti.add(t);
            //t.start();
        }
        turisti.forEach((turista) -> {
            turista.start();
        }); 
    }
}
