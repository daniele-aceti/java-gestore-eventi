
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //Inserimento dati utente
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

        //Inserimento concerto
        LocalTime oraConcerto = LocalTime.of(13, 30);
        LocalDate dataConcerto = LocalDate.of(2025, 05, 01);
        Concerto primoMaggio = new Concerto("Primo Maggio", dataConcerto, 500, oraConcerto, 50.5);
        System.out.println(primoMaggio);

        //Prove inserimento eventi
        LocalTime oraConcerto2 = LocalTime.of(14, 30);
        LocalDate dataConcerto2 = LocalDate.of(2025, 06, 10);
        Concerto primoMaggio2 = new Concerto("Primo Maggio2", dataConcerto2, 500, oraConcerto2, 50.5);

        LocalTime oraConcerto3 = LocalTime.of(14, 30);
        LocalDate dataConcerto3 = LocalDate.of(2025, 05, 02);
        Concerto primoMaggio3 = new Concerto("Primo Maggio3", dataConcerto3, 500, oraConcerto3, 50.5);

        ProgrammaEventi listaEventi = new ProgrammaEventi("Evento: ", dataConcerto, 500);

        listaEventi.addEvento(primoMaggio);
        listaEventi.addEvento(primoMaggio2);
        listaEventi.addEvento(primoMaggio3);
        listaEventi.addEvento(spettacoloTeatrale);
        System.out.println(listaEventi);
        listaEventi.listaPerData(01, 05, 2025);
        System.out.println("Lista di quanti eventi ci sono: " + listaEventi.listaProgramma());
        System.out.println("Lista dopo cancellazione; " + listaEventi.rimuoviTuttiGliEventi());

        //TODO:--COMPARETO FORMAT BONUS---
    }
}
