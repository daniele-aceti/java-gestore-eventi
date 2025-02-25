
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    private String titolo;

    private List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }

    public List<Evento> addEvento(Evento evento) {
        this.eventi.add(evento);
        return eventi;

    }

    public List<Evento> listaPerData(int giorno, int mese, int anno) {
        LocalDate ricercaData = LocalDate.of(anno, mese, giorno);
        List<Evento> nuovaLista = new ArrayList<>();
        for (int i = 0; i < eventi.size(); i++) {
            if (eventi.get(i).getData().equals(ricercaData)) {
                nuovaLista.add(eventi.get(i));
            }
        }
        return nuovaLista;
    }

    public int numeroEventi() {
        int numeroEventi = eventi.size();
        return numeroEventi;
    }

    //ATTENZIONE: con questo metodo si elmina tutto il programma eventi
    public List<Evento> rimuoviTuttiGliEventi() {
        eventi.clear();
        return eventi;
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
