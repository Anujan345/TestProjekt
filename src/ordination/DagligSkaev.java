package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    ArrayList<Dosis> doses = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel) {
        super(startDen, slutDen, patient, laegemiddel);
    }


    @Override
    public Laegemiddel getLaegemiddel() {
        return super.getLaegemiddel();
    }

    public void opretDosis(LocalTime[] tid, double[] antal) {
        for (int i = 0; i < tid.length-1; i++) {
            doses.add(new Dosis(tid[i],antal[i]));
        }
    }

    public ArrayList<Dosis> getDoses() {
        return new ArrayList<>(doses);
    }

    @Override
    public double samletDosis() {
        int dage = (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen())+1;
        double sum =0;
        for (Dosis d : doses){
            sum += d.getAntal();
        }
        return sum * dage;
    }

    @Override
    public double doegnDosis() {
        double sum =0;
        for (Dosis d : doses){
            sum += d.getAntal();
        }
        return sum;
    }

    @Override
    public String getType() {
        return "Daglig skæv";
    }
}
