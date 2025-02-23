
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    private String titolo;

    private List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.eventi = new ArrayList<Evento>();
    }

    public Boolean addEvento(Evento evento) {
        return eventi.add(evento);
    }
/* 
    public void listaPerData(LocalDate ricercaData) {
        if (ricercaData.equals(Evento.getData())) {
            System.out.println(eventi);
        } else {
            System.out.println("Nessun evento in questa data");
        }
    } */

    public int listaProgramma() {
        int numeroEventi = eventi.size();
        return numeroEventi;
    }

    //ATTENZIONE: con questo metodo si elmina tutto il programma
    public List<Evento> rimuoviTuttiGliEventi() {
        eventi.clear();
        return eventi;
    }

  

    @Override
    public String toString() {
        return "" + eventi;
    }
}
