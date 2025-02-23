
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //INSERIMENTO DATI UTENTE
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci il nome dell'evento");
        String nomeEvento = scan.nextLine();
        System.out.println("Inersci l'anno dell'evento, AAAA");
        int annoEvento = scan.nextInt();
        System.out.println("Inserisci il mese, MM ");
        int meseEvento = scan.nextInt();
        System.out.println("Inserire il giorno, GG");
        int giornoEvento = scan.nextInt();
        System.out.println("Inserire i numeri dei posti totali dell'evento");
        int postiEvento = scan.nextInt();

        LocalDate dataEvento = LocalDate.of(annoEvento, meseEvento, giornoEvento);
        Evento concerto = new Evento(nomeEvento, dataEvento, postiEvento);
        try {
            concerto.prenota();
            concerto.disdici();
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

        System.out.println(concerto.getNumeroPostiPrenotati());
        System.out.println(concerto.getNumeroPostiTotale());
        System.out.println(concerto);

        LocalTime oraConcerto = LocalTime.of(13, 30);
        LocalDate dataConcerto = LocalDate.of(2025, 05, 01);
        Evento primoMaggio = new Concerto("primo maggio", dataConcerto, 500, oraConcerto, 50);
        System.out.println(primoMaggio);

    }
}
