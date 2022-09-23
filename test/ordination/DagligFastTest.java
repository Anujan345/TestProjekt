package ordination;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {
    private Patient patient;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.patient = new Patient("1111111111", "Esben", 80);
    }

    @org.junit.jupiter.api.Test
    void morgen() {
        //Arrange
        DagligFast dagligFast = new DagligFast(LocalDate.of(2020, 10, 1),LocalDate.of(2022, 10, 1),patient,null);

        //Act
        Dosis actual = dagligFast.morgen(2);
        Dosis expected = (Dosis) Array.get(dagligFast.getDagligDosis(),0);

        //Assert
        assertEquals(expected, actual);
//        System.out.println(actual);
//        System.out.println(expected);
    }

    @Test
    void middag() {
        //Arrange
        DagligFast dagligFast = new DagligFast(LocalDate.of(2020, 10, 1),LocalDate.of(2022, 10, 1),patient,null);

        //Act
        Dosis actual = dagligFast.middag(2);
        Dosis expected = (Dosis) Array.get(dagligFast.getDagligDosis(),1);

        //Assert
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void aften() {
        //Arrange
        DagligFast dagligFast = new DagligFast(LocalDate.of(2020, 10, 1),LocalDate.of(2022, 10, 1),patient,null);

        //Act
        Dosis actual = dagligFast.aften(2);
        Dosis expected = (Dosis) Array.get(dagligFast.getDagligDosis(),2);

        //Assert
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void nat() {
        //Arrange
        DagligFast dagligFast = new DagligFast(LocalDate.of(2020, 10, 1),LocalDate.of(2022, 10, 1),patient,null);

        //Act
        Dosis actual = dagligFast.nat(2);
        Dosis expected = (Dosis) Array.get(dagligFast.getDagligDosis(),3);

        //Assert
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TC2_samletantal1_start_22_09_22_slut_23_09_22_samletDosis() {
        //Arrange
        DagligFast dagligFast = new DagligFast(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 23),patient,null);
        Dosis morgen = dagligFast.morgen(1);
        Dosis middag = dagligFast.middag(1);
        Dosis aften = dagligFast.aften(1);
        Dosis nat = dagligFast.nat(1);
        double actual = dagligFast.samletDosis();
        double expected = 8;

        //Assert
        assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    void TC2_samletantal2_start_22_09_22_slut_24_09_22_samletDosis() {
        //Arrange
        DagligFast dagligFast = new DagligFast(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 24),patient,null);
        Dosis morgen = dagligFast.morgen(2);
        Dosis middag = dagligFast.middag(2);
        Dosis aften = dagligFast.aften(2);
        Dosis nat = dagligFast.nat(2);
        double actual = dagligFast.samletDosis();
        double expected = 24;

        //Assert
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TC3_samletantal3_start_22_09_22_slut_24_09_22_samletDosis() {
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
    void TC1_setPatient_Null(){
        //Arrange
        DagligFast dagligFast = new DagligFast(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 22),patient,null);

        //Act
        dagligFast.setPatient(null);

        //Arrange
        assertEquals(null, dagligFast.getPatient());
    }


    @Test
    void TC1_setPatient_notNull() {

        //Arrange
        DagligFast dagligFast = new DagligFast(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 22),patient,null);
        Patient patient1 = new Patient("1111111","Hans Kim", 90);

        //Act
        dagligFast.setPatient(patient1);

        Patient expected = patient1;

        //Assert
        assertEquals(expected,dagligFast.getPatient());
    }
}