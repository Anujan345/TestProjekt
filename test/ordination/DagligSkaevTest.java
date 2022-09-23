package ordination;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {
    private Patient patient;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.patient = new Patient("1111111111", "Esben", 80);
    }

    @Test
    void getLaegemiddel() {
    }

    @Test
    void opretDosis() {
    }

    @Test
    void getDoses() {
    }

    @Test
    void void TC1_samletantal1_start_22_09_22_slut_24_09_22_samletDosis() {
            //Arrange
            DagligFast dagligFast = new DagligFast(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 22),patient,null);
            Dosis morgen = dagligFast.morgen(3);
            Dosis middag = dagligFast.middag(3);
            Dosis aften = dagligFast.aften(3);
            Dosis nat = dagligFast.nat(3);
            double actual = dagligFast.samletDosis();
            double expected = 12;

            //Assert
            assertEquals(expected, actual);
    }

    @Test
    void TC1_samletantal1_start_22_09_22_slut_24_09_22_døgndosis(){
            //Arrange
            DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 22),patient,null);

            double actual = dagligSkaev.doegnDosis();
            double expected = 12;

            //Assert
            assertEquals(expected, actual);
    }

    @Test
    void getType() {
    }
}