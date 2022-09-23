package controller;

import ordination.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
Controller controller;
Patient patient;
Laegemiddel laegemiddel;


    @Test
    void TC1_Opret_Dagligfast() {
        //Arrange
        patient = new Patient("111111","Anujan",112);
        laegemiddel = new Laegemiddel("LSD",5,10,15,"enhed");
        controller = Controller.getController();

        //Act && Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> controller.opretPNOrdination(LocalDate.of(2022,9,22),LocalDate.of(2021, 9, 22),
                patient,laegemiddel,20));
        String expected = "Den er udenfor ordinationsdatoerne";

        assertEquals(expected, exception.getMessage());


    }

    @Test
    void TC2_Opret_Dagligfast() {
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
    void TC3_Opret_Dagligfast() {
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
    void TC1_opretDagligFastOrdination() {
        //Arrange
        patient = new Patient("111111","Anujan",20);
        laegemiddel = new Laegemiddel("asd",10,20,30,"sa");
        controller = Controller.getController();

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> controller.opretDagligFastOrdination(LocalDate.of(2022, 9, 22),
                LocalDate.of(2021, 9, 22),patient,laegemiddel,2, 3, 4, 5));
        String expected = "Den er udenfor ordinationsdatoerne";

        //Assert
        assertEquals(expected,exception.getMessage() );
    }

    @Test
    void TC2_opretDagligFastOrdination() {
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
    void TC3_opretDagligFastOrdination() {
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
    void opretDagligSkaevOrdination() {
        //Arrange
        patient = new Patient("111111","Anujan",20);
        laegemiddel = new Laegemiddel("asd",10,20,30,"sa");
        controller = Controller.getController();


        //Act
        DagligSkaev actual = controller.opretDagligSkaevOrdination(LocalDate.of(2002, 10, 10),
                LocalDate.of(2002, 10, 20),patient,laegemiddel,null , null);
        Ordination expected = patient.getOrdinations().get(0);

        //Assert
        assertEquals(expected,actual );
    }

    @Test
    void ordinationPNAnvendt() {
    }

    @Test
    void anbefaletDosisPrDoegn() {
    }

    @Test
    void antalOrdinationerPrVægtPrLægemiddel() {
    }
}