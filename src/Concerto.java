
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {

    private LocalTime ora;

    private double prezzo;

    public Concerto(String titolo, LocalDate data, int numeroPostiTotale, LocalTime ora, double prezzo) {
        this.ora = ora;
        this.prezzo = prezzo;
        super(titolo, data, numeroPostiTotale);
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String toString() {
        return getData().getDayOfMonth() + "/" + getData().getMonth() + "/" + getData().getYear() + " " + ora.getHour() 
                + ":" + ora.getMinute() + " " + getTitolo() + " " + prezzo + "€";
    }

}
