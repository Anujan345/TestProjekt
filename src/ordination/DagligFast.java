package ordination;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DagligFast extends Ordination{
    private Dosis[] dagligDosis = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel) {
        super(startDen, slutDen, patient, laegemiddel);
    }




    public Dosis morgen(double antal){
        Dosis dosis = new Dosis(LocalTime.of(6, 0),antal);
        dagligDosis[0] = dosis;
        return dosis;
    }
    public Dosis middag(double antal){
        Dosis dosis = new Dosis(LocalTime.of(12, 0),antal);
        dagligDosis[1] = dosis;
        return dosis;
    }

    public Dosis aften(double antal){
        Dosis dosis = new Dosis(LocalTime.of(18, 0),antal);
        dagligDosis[2] = dosis;
        return dosis;
    }

    public Dosis nat(double antal){
        Dosis dosis = new Dosis(LocalTime.of(23, 0),antal);
        dagligDosis[3] = dosis;
        return dosis;
    }



    @Override
    public double samletDosis() {
        int dage = (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen());
        double samletdosis = 0;
        for (Dosis d : dagligDosis){
            samletdosis += d.getAntal();
        }
        return samletdosis * dage;
    }

    public Dosis[] getDagligDosis() {
        return dagligDosis;
    }

    @Override
    public Laegemiddel getLaegemiddel() {
        return super.getLaegemiddel();
    }

    @Override
    public double doegnDosis() {
        double samletdosis = 0;
        for (Dosis d : dagligDosis){
            samletdosis += d.getAntal();
        }
        return samletdosis;
    }

    @Override
    public String getType() {
        return "Daglig fast";
    }
}
