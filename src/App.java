
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
        try {
            Evento spettacoloTeatrale = new Evento(nomeEvento, dataEvento, postiEvento);
            spettacoloTeatrale.prenota();
            spettacoloTeatrale.disdici();
            System.out.println(spettacoloTeatrale.getNumeroPostiPrenotati());
            System.out.println(spettacoloTeatrale.getNumeroPostiTotale());
            System.out.println(spettacoloTeatrale);
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

        //Inserimento concerto
        LocalTime oraConcerto = LocalTime.of(13, 30);
        LocalDate dataConcerto = LocalDate.of(2025, 05, 01);
        try {
            Concerto primoMaggio = new Concerto("Primo Maggio", dataConcerto, 500, oraConcerto, 50.5);
            System.out.println(primoMaggio);
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

        //Lista eventi
        LocalDate dataListaEvento = LocalDate.of(2025, 05, 01);
        LocalDate dataListaEvento2 = LocalDate.of(2026, 05, 01);
        LocalDate dataListaEvento3 = LocalDate.of(2025, 03, 01);
        try {
            //listaEventi.addEvento(EventoPiazza);
            Evento eventoPiazza = new Evento("Evento Piazza", dataListaEvento, 500);
            Evento eventoPiazza2 = new Evento("Evento Piazza2", dataListaEvento2, 500);
            Evento eventoPiazza3 = new Evento("Evento Piazza3", dataListaEvento3, 500);
            ProgrammaEventi lisProgrammaEventi = new ProgrammaEventi("Nuovo Programma");
            lisProgrammaEventi.addEvento(eventoPiazza);
            lisProgrammaEventi.addEvento(eventoPiazza2);
            lisProgrammaEventi.addEvento(eventoPiazza3);
            System.out.println(lisProgrammaEventi);
            System.out.println(lisProgrammaEventi);
            lisProgrammaEventi.listaPerData(01, 05, 2025);
            System.out.println("Lista di quanti eventi ci sono: " + lisProgrammaEventi.numeroEventi());
            //Collections.sort(lisProgrammaEventi);
            lisProgrammaEventi.rimuoviTuttiGliEventi();
            System.out.println(lisProgrammaEventi);
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

    }
}
