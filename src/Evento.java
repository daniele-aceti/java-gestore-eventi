
import java.time.LocalDate;
import java.util.Scanner;

public class Evento implements Comparable<Evento> {
    
    private String titolo;

    private LocalDate data;

    private int numeroPostiTotale;

    private int numeroPostiPrenotati;

    private Boolean controlloData;

  
    public Evento(String titolo, LocalDate data, int numeroPostiTotale) throws Exception {
        this.controlloData = data.isEqual(LocalDate.now()) || data.isAfter(LocalDate.now());
        if (controlloData && numeroPostiTotale > 0) {
            this.titolo = titolo;
            this.data = data;
            this.numeroPostiTotale = numeroPostiTotale;
            numeroPostiPrenotati = 0;
        } else {
            throw new Exception("Non è possibile completare l'operazione controllare i dati inseriti");
        }

    }

    public int prenota() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vuoi prenotare il tuo posto all'evento? Ripondi si o no");
        String risposta = scan.nextLine();
        int postiDaPrenotare = 0;
        Boolean rispostaSi = risposta.equalsIgnoreCase("si") ? true : false;
        Boolean rispostaNo = risposta.equalsIgnoreCase("no") ? true : false;
        if (rispostaSi) {
            System.out.println("Quanti posti vuoi prenotare?");
            postiDaPrenotare = scan.nextInt();
            if (this.controlloData && postiDaPrenotare >= 0 && postiDaPrenotare <= numeroPostiTotale) {
                return numeroPostiPrenotati += postiDaPrenotare;
            }
        } else if (rispostaNo) {
            return postiDaPrenotare = 0;
        }
        throw new Exception("Non è possibile completare l'operazione controllare i dati inseriti");
    }

    public int disdici() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vuoi disdire il tuo posto all'evento? Ripondi si o no");
        String risposta = scan.nextLine();
        Boolean rispostaSi = risposta.equalsIgnoreCase("si") ? true : false;
        Boolean rispostaNo = risposta.equalsIgnoreCase("no") ? true : false;
        if (rispostaSi) {
            System.out.println("Quanti posti vuoi disdire?");
            int postiDaDisdire = scan.nextInt();
            if (this.controlloData && numeroPostiPrenotati >= postiDaDisdire && postiDaDisdire >= 0) {
                return numeroPostiPrenotati -= postiDaDisdire;
            }
        } else if (rispostaNo) {
            return 0;
        }
        throw new Exception("Non è possibile completare l'operazione controllare i dati inseriti");

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
        return numeroPostiTotale;
    }

    public int postiRimanenti(){
        return getNumeroPostiTotale() - getNumeroPostiPrenotati();
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;

    }

    public String formatData() {
        return data.getDayOfMonth() + "/" + data.getMonth() + "/" + data.getYear();
    }
    

    @Override
    public int compareTo(Evento evento) {
        if (evento.getData().isAfter(data)) {
            return -1;
        } else if (evento.getData().isBefore(data)) {
            return +1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return formatData() + " - " + titolo + "\n";
    }
}
