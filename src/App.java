
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
        Evento spettacoloTeatrale = new Evento(nomeEvento, dataEvento, postiEvento);
        try {
            spettacoloTeatrale.prenota();
            spettacoloTeatrale.disdici();
        } catch (Exception e) {
            System.err.println(e);
            return;
        }
        System.out.println(spettacoloTeatrale.getNumeroPostiPrenotati());
        System.out.println(spettacoloTeatrale.getNumeroPostiTotale());
        System.out.println(spettacoloTeatrale);

        LocalTime oraConcerto = LocalTime.of(13, 30);
        LocalDate dataConcerto = LocalDate.of(2025, 05, 01);
        Concerto primoMaggio = new Concerto("Primo Maggio", dataConcerto, 500, oraConcerto, 50);
        System.out.println(primoMaggio);

        ProgrammaEventi listaEventi = new ProgrammaEventi("Programma 2025");
        listaEventi.addEvento(primoMaggio);
        listaEventi.addEvento(spettacoloTeatrale);//TODO: DATA AGGIUNTA SEMPRE 01/05
        System.out.println("Lista eventi dopo averli aggiunti: " + listaEventi);
       // listaEventi.listaPerData(dataConcerto);
        System.out.println("Lista di quanti eventi ci sono: " + listaEventi.listaProgramma());
        System.out.println("Lista dopo cancellazione; " + listaEventi.rimuoviTuttiGliEventi());

    }
}
