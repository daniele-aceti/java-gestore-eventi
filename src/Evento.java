
import java.time.LocalDate;
import java.util.Scanner;

public class Evento {

    private String titolo;

    private LocalDate data;

    private int numeroPostiTotale;

    private int numeroPostiPrenotati;

    public Evento(String titolo, LocalDate data, int numeroPostiTotale) {
        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotale = numeroPostiTotale;
        numeroPostiPrenotati = 0;
    }

    public int prenota() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Quanti posti vuoi prenotare?");
        int postiDaPrenotare = scan.nextInt();
        boolean dataEventoValida = data.isEqual(LocalDate.now()) || data.isAfter(LocalDate.now());
        if (dataEventoValida && numeroPostiTotale >= 0) {
            return numeroPostiPrenotati += postiDaPrenotare;
        } else {
            throw new Exception("Non è possibile completare l'operazione controllare i dati inseriti");
        }

    }

    public int disdici() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Quanti posti vuoi disdire?");
        int postiDaDisdire = scan.nextInt();
        boolean dataEventoValida = data.isEqual(LocalDate.now()) || data.isAfter(LocalDate.now());
        if (dataEventoValida && numeroPostiPrenotati > postiDaDisdire) {
            return numeroPostiPrenotati -= postiDaDisdire;
        } else {
            throw new Exception("Non è possibile completare l'operazione controllare i dati inseriti");
        }
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNumeroPostiTotale() {
        numeroPostiTotale = numeroPostiTotale - numeroPostiPrenotati;
        return numeroPostiTotale;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;

    }

    @Override
    public String toString() {
        return data.getDayOfMonth() + "/" + data.getMonth() + "/" + data.getYear() + " " + titolo;
    }

}
