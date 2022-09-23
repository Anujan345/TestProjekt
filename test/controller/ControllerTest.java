package controller;

import ordination.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
Controller controller;
Patient patient;
Laegemiddel laegemiddel;


    @Test
    void TC1_opretPnOrdination_minus1_Dag() {
        //Arrange
        patient = new Patient("111111","Anujan",112);
        laegemiddel = new Laegemiddel("LSD",5,10,15,"enhed");
        controller = Controller.getController();

        //Act && Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> controller.opretPNOrdination(LocalDate.of(2022,9,22),LocalDate.of(2022, 9, 21),
                patient,laegemiddel,20));
        String expected = "Den er udenfor ordinationsdatoerne";

        assertEquals(expected, exception.getMessage());


    }

    @Test
    void TC2_opretPNOrdination_plus1_dag() {
        //Arrange
        patient = new Patient("111111","Anujan",112);
        laegemiddel = new Laegemiddel("LSD",5,10,15,"enhed");
        controller = Controller.getController();

        //Act
        PN Actual = controller.opretPNOrdination(LocalDate.of(2022,9,22),LocalDate.of(2023, 9, 2),
                patient,laegemiddel,20);
        Ordination expected = patient.getOrdinations().get(0);

        //Assert
        assertEquals(expected, Actual);


    }

    @Test
    void TC3_opretPnOrdination_laegemiddel_null() {
        //Arrange
        patient = new Patient("111111","Anujan",112);
        laegemiddel = new Laegemiddel("LSD",5,10,15,"enhed");
        controller = Controller.getController();

        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> controller.opretPNOrdination(LocalDate.of(2022,9,22),LocalDate.of(2025, 9, 22),
                patient,null,20));
        String expected = "sæt patient og laegemiddel";

        assertEquals(expected, exception.getMessage());

    }
    @Test
    void TC1_opretDagligFastOrdination_minus1_dag() {
        //Arrange
        patient = new Patient("111111","Anujan",20);
        laegemiddel = new Laegemiddel("asd",10,20,30,"sa");
        controller = Controller.getController();

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> controller.opretDagligFastOrdination(LocalDate.of(2022, 9, 22),
                LocalDate.of(2022, 9, 21),patient,laegemiddel,1, 1, 1, 1));
        String expected = "Den er udenfor ordinationsdatoerne";

        //Assert
        assertEquals(expected,exception.getMessage() );
    }

    @Test
    void TC2_opretDagligFastOrdination_plus1_dag() {
        //Arrange
        patient = new Patient("111111","Anujan",20);
        laegemiddel = new Laegemiddel("asd",10,20,30,"sa");
        controller = Controller.getController();

        //Act
        DagligFast actual =controller.opretDagligFastOrdination(LocalDate.of(2022, 9, 22),
                LocalDate.of(2022, 9, 23),patient,laegemiddel,2, 2, 0, 0);
        Ordination expected = patient.getOrdinations().get(0);

        //Assert
        assertEquals(expected,actual);
    }
    @Test
    void TC3_opretDagligFastOrdination_plus3_dage() {
        //Arrange
        patient = new Patient("111111","Anujan",20);
        laegemiddel = new Laegemiddel("asd",10,20,30,"sa");
        controller = Controller.getController();

        //Act
        DagligFast actual =controller.opretDagligFastOrdination(LocalDate.of(2022, 9, 22),
                LocalDate.of(2022, 9, 25),patient,laegemiddel,3, 2, 1, 0);
        Ordination expected = patient.getOrdinations().get(0);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void TC1_opretDagligSkaevOrdination_minus1_dag() {
        //Arrange
        patient = new Patient("111111","Anujan",20);
        laegemiddel = new Laegemiddel("asd",10,20,30,"sa");
        controller = Controller.getController();
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

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> controller.opretDagligSkaevOrdination(LocalDate.of(2022, 9, 22),
                LocalDate.of(2021, 9, 22),patient,laegemiddel,tid,antal));
        String expected = "Den er udenfor ordinationsdatoerne";

        //Assert
        assertEquals(expected,exception.getMessage());
    }

    @Test
    void TC2_opretDagligSkaevOrdination_plus1_dag() {
        //Arrange
        patient = new Patient("111111","Anujan",20);
        laegemiddel = new Laegemiddel("asd",10,20,30,"sa");
        controller = Controller.getController();
        LocalTime[] tid = new LocalTime[2];
        double[] antal = new double[2];
        tid[0] = LocalTime.of(12, 00);
        antal[0] = 2;
        tid[1] = LocalTime.of(18, 00);
        antal[1] = 2;

        //Act
        DagligSkaev actual = controller.opretDagligSkaevOrdination(LocalDate.of(2022, 9, 22),
                LocalDate.of(2022, 9, 23),patient,laegemiddel,tid,antal);
        Ordination expected = patient.getOrdinations().get(0);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void TC1_ordinationPNAnvendt_input_26_09_22() {
        //Arrange
        patient = new Patient("111111","Anujan",20);
        laegemiddel = new Laegemiddel("asd",10,20,30,"sa");
        controller = Controller.getController();
        PN pn = controller.opretPNOrdination(LocalDate.of(2022, 9, 22),
                LocalDate.of(2022, 9, 25),patient,laegemiddel,20);
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> controller.ordinationPNAnvendt(pn, LocalDate.of(2022,9,26)));
        String expected = "Den er udenfor ordinationsdatoerne";
        //Assert
        assertEquals(expected,exception.getMessage());

    }

    @Test
    void TC2_ordinationPNAnvendt_input_21_09_22() {
        //Arrange
        patient = new Patient("111111","Anujan",20);
        laegemiddel = new Laegemiddel("asd",10,20,30,"sa");
        controller = Controller.getController();
        PN pn = controller.opretPNOrdination(LocalDate.of(2022, 9, 22),
                LocalDate.of(2022, 9, 25),patient,laegemiddel,20);
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> controller.ordinationPNAnvendt(pn, LocalDate.of(2022,9,21)));
        String expected = "Den er udenfor ordinationsdatoerne";
        //Assert
        assertEquals(expected,exception.getMessage());

    }

    @Test
    void T1_anbefaletDosisPrDoegn() {
        //Arrange
        laegemiddel = new Laegemiddel("asd",0.1,0.2,0.3,"sa");
        controller = Controller.getController();
        patient = new Patient("111111","Anujan",20);

        //Act
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        double expected = 2;

        //Assert
        assertEquals(expected, actual);

    }
    @Test
    void T2_anbefaletDosisPrDoegn() {
        //Arrange
        laegemiddel = new Laegemiddel("asd",0.1,0.2,0.3,"sa");
        controller = Controller.getController();
        patient = new Patient("111111","Anujan",24);

        //Act
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        double expected = 2.4;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void T3_anbefaletDosisPrDoegn() {
        //Arrange
        laegemiddel = new Laegemiddel("asd",0.1,0.2,0.3,"sa");
        controller = Controller.getController();
        patient = new Patient("111111","Anujan",25);

        //Act
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        double expected = 5;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void T4_anbefaletDosisPrDoegn() {
        //Arrange
        laegemiddel = new Laegemiddel("asd",0.1,0.2,0.3,"sa");
        controller = Controller.getController();
        patient = new Patient("111111","Anujan",120);

        //Act
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        double expected = 24;

        //Assert
        assertEquals(expected, actual);
    }
    @Test
    void T5_anbefaletDosisPrDoegn() {
        //Arrange
        laegemiddel = new Laegemiddel("asd",0.1,0.2,0.3,"sa");
        controller = Controller.getController();
        patient = new Patient("111111","Anujan",121);

        //Act
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        double expected = 36.3;

        //Assert
        assertEquals(expected, actual);
    }
    @Test
    void antalOrdinationerPrVægtPrLægemiddel() {
    }
}