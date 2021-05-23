import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

public class lekarstwo implements Serializable {
    private String nazwa;
    private double cena;
    private double procentRefundacji;
    private Set<Float> skladnikiCzynne;
    private boolean czyNaRecepte;

    public lekarstwo(String nazwa, double cena, double producentRefundacji, Set<Float> skladnikiCzynne,
                     boolean czyNaRecepte) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.procentRefundacji = producentRefundacji;
        this.skladnikiCzynne = skladnikiCzynne;
        this.czyNaRecepte = czyNaRecepte;

    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getProcentRefundacji() {
        return procentRefundacji;
    }

    public void setProcentRefundacji(double procentRefundacji) {
        this.procentRefundacji = procentRefundacji;
    }

    public Set<Float> getSkladnikiCzynne() {
        return skladnikiCzynne;
    }

    public void setSkladnikiCzynne(Set<Float> skladnikiCzynne) {
        this.skladnikiCzynne = skladnikiCzynne;
    }

    public boolean isCzyNaRecepte() {
        return czyNaRecepte;
    }

    public void setCzyNaRecepte(boolean czyNaRecepte) {
        this.czyNaRecepte = czyNaRecepte;
    }

    public double podajCene(boolean czyRefundowany) {
        if (czyRefundowany) {
            return cena - (this.cena * procentRefundacji);
        } else return this.cena;
    }
    public String sprzedajLekarstwo(boolean refundacja, boolean czyKlientPosiadaRecepte) {

        String wiadomosc = "Sprzedaż lekarstwa " + nazwa;

        if (czyNaRecepte) {
            if (czyKlientPosiadaRecepte) {
                wiadomosc = wiadomosc + " z receptą ";
            } else {
                wiadomosc = wiadomosc + " niemożliwa z powodu braku recepty";
                return wiadomosc;
            }
        } else {
            wiadomosc = wiadomosc + "bez recepty ";
        }

        wiadomosc = wiadomosc + " w cenie ";

        double c = cena;
        if (refundacja) {
            c = cena - (cena * procentRefundacji);
            wiadomosc = wiadomosc + " refundowanej ";
        }
        wiadomosc = wiadomosc + c;

        return wiadomosc;
    }
    public void zapisz(String nazwaLeku) throws IOException {

        FileOutputStream fileOut = new FileOutputStream(nazwaLeku);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }
    public float sredniaWagaSkladnikaCzynnego(){

        float suma = 0;
        for (float czynnik: skladnikiCzynne){
            suma = suma + czynnik;
        }

        return suma / skladnikiCzynne.size();
    }
}