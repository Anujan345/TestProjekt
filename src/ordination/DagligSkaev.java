package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    ArrayList<Dosis> doses = new ArrayList<>();
    public DagligSkaev(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
    }

    public void opretDosis(LocalTime[] tid, double[] antal) {
        for (int i = 0; i < tid.length; i++) {
            for (int j = 0; j < antal.length; j++) {
                doses.add(new Dosis(tid[i],antal[j]));
                i++;
                j++;
            }
        }
    }

    @Override
    public double samletDosis() {
        int dage = (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen());
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
