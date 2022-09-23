package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class   PNTest {
Patient patient;
Laegemiddel laegemiddel;
    @BeforeEach
    void setUp() {
    patient = new Patient("11111111","Anujan",120);
    laegemiddel = new Laegemiddel("abc", 10, 12, 15, "sad");
    }

    @Test
    void getLaegemiddel() {
        //Arrange
        PN pn = new PN(LocalDate.of(2002, 10, 10),
                LocalDate.of(2002, 10, 12),patient,laegemiddel,20);

        //Act
        Laegemiddel actual = pn.getLaegemiddel();
        Laegemiddel expected = laegemiddel;
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    void givDosis() {
        //Arrange
        PN pn = new PN(LocalDate.of(2002, 10, 10),
                LocalDate.of(2002, 10, 12),patient,laegemiddel,20);

        //Act
        pn.givDosis(LocalDate.of(2002,10,10));
        pn.givDosis(LocalDate.of(2002, 10, 11));
        pn.givDosis(LocalDate.of(2002, 10, 12));

        //Assert
        assertEquals(3, pn.getAntalGangeGivet());

    }

    @Test
    void doegnDosis() {
    }

    @Test
    void getType() {
    }

    @Test
    void samletDosis() {
    }

    @Test
    void getAntalGangeGivet() {
    }

    @Test
    void getAntalEnheder() {
    }
}