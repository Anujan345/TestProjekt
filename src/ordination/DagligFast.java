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


    private Dosis createDosis(LocalTime tid, double antal){
        Dosis dosis = new Dosis(tid,antal);
        if(tid == (LocalTime.of(6,00))){
        dagligDosis[0] = dosis;
        }else if (tid ==LocalTime.of(12,00)){
            dagligDosis[1] = dosis;
        }else if (tid ==LocalTime.of(18,00)){
            dagligDosis[2] = dosis;
        }else if (tid ==LocalTime.of(23,00)){
            dagligDosis[3] = dosis;
        }
        return dosis;

    }

    public Dosis morgen(double antal){
        return createDosis(LocalTime.of(6,00),antal);
    }
    public Dosis middag(double antal){
        return createDosis(LocalTime.of(12,00),antal);
    }

    public Dosis aften(double antal){
        return createDosis(LocalTime.of(18,00),antal);
    }

    public Dosis nat(double antal){
        return createDosis(LocalTime.of(23,00),antal);
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
