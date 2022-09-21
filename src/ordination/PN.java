package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN  extends Ordination{

    private double antalEnheder;
    private int givetdosis = 0;
    private ArrayList<LocalDate> datoer = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,double antalEnheder) {
        super(startDen, slutDen, patient, laegemiddel);
        this.antalEnheder = antalEnheder;
    }

    @Override
    public Laegemiddel getLaegemiddel() {
        return super.getLaegemiddel();
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        boolean dato = false;
        if (givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen())){
            datoer.add(givesDen);
            dato = true;
        }
        return dato;
    }

    public double doegnDosis() {
        double døgndosis;
        døgndosis = (datoer.size()*antalEnheder)/ ChronoUnit.DAYS.between(getStartDen(), getSlutDen());
        return døgndosis;
    }

    @Override
    public String getType() {
        return "PN";
    }


    public double samletDosis() {
        double døgndosis;
        døgndosis = (datoer.size()*antalEnheder);
        return døgndosis;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return datoer.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
