
import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public String formatPrezzo() {
        BigDecimal prezzoDecimale = new BigDecimal(prezzo);
        prezzoDecimale = prezzoDecimale.setScale(2, RoundingMode.HALF_UP);
        return String.format("%s", prezzoDecimale).replace(".", ",");
    }

    //STAMPA : GIORNO/MESE/ANNO- ORA:MINUTI- PREZZO IN €
    public String toString() {
        return formatData() + " " + getOra() + " " + getTitolo() + " " + formatPrezzo() + " Euro";
    }

}
