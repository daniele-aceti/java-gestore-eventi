
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi extends Evento implements Comparable<Evento> {

    private String titolo;

    private List<Evento> eventi;

    public ProgrammaEventi(String titolo, LocalDate data, int numeroPostiTotale) {
        super(titolo, data, numeroPostiTotale);
        this.titolo = titolo;
        this.eventi = new ArrayList<Evento>();
    }

    public Boolean addEvento(Evento evento) {
        return eventi.add(evento);
    }

    public void listaPerData(int giorno, int mese, int anno) {
        LocalDate ricercaData = LocalDate.of(anno, mese, giorno);
        List<Evento> nuovaLista = new ArrayList<Evento>();
        for (int i = 0; i < eventi.size(); i++) {
            if (eventi.get(i).getData().equals(ricercaData)) {
                nuovaLista.add(eventi.get(i));
            }
        }
        System.out.println("Eventi trovati a questa data: " + nuovaLista);
    }

    public int listaProgramma() {
        int numeroEventi = eventi.size();
        return numeroEventi;
    }

    //ATTENZIONE: con questo metodo si elmina tutto il programma eventi
    public List<Evento> rimuoviTuttiGliEventi() {
        eventi.clear();
        return eventi;
    }

    @Override
    public int compareTo(Evento eventi) {
        for (int i = 0; i < this.eventi.size(); i++) {
            if (this.eventi.get(i).getData().isAfter(this.eventi.get(i + 1).getData())) {
                return +1;
            } else if (this.eventi.get(i).getData().isBefore(this.eventi.get(i + 1).getData())) {
                return +0;
            }
        }
        return -1;

    }

    @Override
    public String toString() {
        String formatProgrammaEventi = "";
        for (int i = 0; i < eventi.size(); i++) {
            formatProgrammaEventi += eventi.get(i).formatData() + " - " + eventi.get(i).getTitolo() + "\n";
        }

        return formatProgrammaEventi;
    }
}
