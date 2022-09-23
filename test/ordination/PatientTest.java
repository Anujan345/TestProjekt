package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void addOrdination() {
        //Arrange
        Patient patient = new Patient("11111111", "Hans kim", 90);
        DagligFast dagligFast = new DagligFast(LocalDate.of(2022, 9, 22),LocalDate.of(2022, 9, 22),patient,null);

        //Act
        patient.addOrdination(dagligFast);

        //Assert
        assertEquals(dagligFast, patient.getOrdinations().get(0));
    }

}