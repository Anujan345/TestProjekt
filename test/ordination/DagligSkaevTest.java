package ordination;


import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {
    private Patient patient;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.patient = new Patient("1111111111", "Esben", 80);
    }

    @Test
    void TC1_samletantal1_start_22_09_22_slut_23_09_22() {
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 23),patient,null);

        //act
        LocalTime[] tid = new LocalTime[3];
        double[] antal = new double[3];
        tid[0] = LocalTime.of(10, 0);
        antal[0] = 5;
        tid[1] = LocalTime.of(12, 0);
        antal[1] = 5;
        tid[2] = LocalTime.of(12, 0);
        antal[2] = 5;
        dagligSkaev.opretDosis(tid, antal);
        double actual = dagligSkaev.samletDosis();
        double expected = 30;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC2_samletantal2_start_22_09_22_slut_24_09_22() {
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 24),patient,null);

        //act
        LocalTime[] tid = new LocalTime[4];
        double[] antal = new double[4];
        tid[0] = LocalTime.of(10, 30);
        antal[0] = 2;
        tid[1] = LocalTime.of(13, 40);
        antal[1] = 3;
        tid[2] = LocalTime.of(15, 0);
        antal[2] = 5;
        tid[3] = LocalTime.of(17, 0);
        antal[3] = 7;
        dagligSkaev.opretDosis(tid, antal);
        double actual = dagligSkaev.samletDosis();
        double expected = 51;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC3_samletantal3_start_22_09_22_slut_22_09_22() {
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 22),patient,null);

        //act
        LocalTime[] tid = new LocalTime[5];
        double[] antal = new double[5];
        tid[0] = LocalTime.of(10, 30);
        antal[0] = 1;
        tid[1] = LocalTime.of(13, 40);
        antal[1] = 5;
        tid[2] = LocalTime.of(15, 0);
        antal[2] = 2;
        tid[3] = LocalTime.of(17, 0);
        antal[3] = 3;
        tid[4] = LocalTime.of(17, 0);
        antal[4] = 7;
        dagligSkaev.opretDosis(tid, antal);
        double actual = dagligSkaev.samletDosis();
        double expected = 18;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC1_døgndosis1_start_22_09_22_slut_24_09_22(){
        //Arrange
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 23),patient,null);

        //act
        LocalTime[] tid = new LocalTime[2];
        double[] antal = new double[2];
        tid[0] = LocalTime.of(10, 0);
        antal[0] = 2;
        tid[1] = LocalTime.of(12, 0);
        antal[1] = 4;
        dagligSkaev.opretDosis(tid, antal);
        double actual = dagligSkaev.doegnDosis();
        double expected = 6;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC2_døgndosis2_start_22_09_22_slut_24_09_22(){
        //Arrange
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 24),patient,null);

        //act
        LocalTime[] tid = new LocalTime[5];
        double[] antal = new double[5];
        tid[0] = LocalTime.of(5, 0);
        antal[0] = 2;
        tid[1] = LocalTime.of(7, 0);
        antal[1] = 1;
        tid[2] = LocalTime.of(9, 0);
        antal[2] = 3;
        tid[3] = LocalTime.of(12, 0);
        antal[3] = 1;
        tid[4] = LocalTime.of(14, 0);
        antal[4] = 2;
        dagligSkaev.opretDosis(tid, antal);
        double actual = dagligSkaev.doegnDosis();
        double expected = 9;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC3_døgndosis3_start_22_09_22_slut_22_09_22(){
        //Arrange
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 22),patient,null);

        //act
        LocalTime[] tid = new LocalTime[7];
        double[] antal = new double[7];
        tid[0] = LocalTime.of(8, 0);
        antal[0] = 1;
        tid[1] = LocalTime.of(10, 0);
        antal[1] = 1;
        tid[2] = LocalTime.of(12, 0);
        antal[2] = 1;
        tid[3] = LocalTime.of(14, 0);
        antal[3] = 1;
        tid[4] = LocalTime.of(16, 0);
        antal[4] = 1;
        tid[5] = LocalTime.of(18, 0);
        antal[5] = 1;
        tid[6] = LocalTime.of(20, 0);
        antal[6] = 1;
        dagligSkaev.opretDosis(tid, antal);
        double actual = dagligSkaev.doegnDosis();
        double expected = 7;

        //Assert
        assertEquals(expected, actual);
    }
}