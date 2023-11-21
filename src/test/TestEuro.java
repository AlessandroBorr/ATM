package test;
import code.Buisness_logic.Euro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEuro {
    @Test
    public void testEuroInt() {
        Euro euro = new Euro(10);
        assertEquals(1000, euro.getValore());
    }

    @Test
    public void testEuroWithCent() {
        Euro euro = new Euro(10, 10);
        assertEquals(1010, euro.getValore());
    }

    @Test
    public void testEuroZero() {
        Euro euro = new Euro(0, 0);
        assertEquals(0, euro.getValore());
    }

    @Test
    public void testEuroNegativeInt() {
        Euro euro = new Euro(-10);
        assertEquals(-1000, euro.getValore());
    }

    @Test
    public void testEuroNegativeWithCent() {
        Euro euro = new Euro(-10, 10);
        assertEquals(-1010, euro.getValore());
    }

    @Test
    public void testEuroDouble() {
        Euro euro = new Euro(10.10);
        assertEquals(1010, euro.getValore());
    }

    @Test
    public void testEuroSomma() {
        Euro euro = new Euro(10, 10);
        Euro euro2 = new Euro(10, 10);
        euro.somma(euro2);
        assertEquals(2020, euro.getValore());
    }

    @Test
    public void testEuroSottrai() {
        Euro euro = new Euro(10, 10);
        Euro euro2 = new Euro(10, 10);
        euro.sottrai(euro2);
        assertEquals(0, euro.getValore());
    }

    @Test
    public void testEuroUgualeA() {
        Euro euro = new Euro(10, 10);
        Euro euro2 = new Euro(10, 10);
        assertTrue(euro.ugualeA(euro2));
    }

    @Test
    public void testEuroNotUgualeA() {
        Euro euro = new Euro(10, 10);
        Euro euro2 = new Euro(10, 20);
        assertFalse(euro.ugualeA(euro2));
    }

    @Test
    public void testEuroMinoreDi() {
        Euro euro = new Euro(10, 10);
        Euro euro2 = new Euro(10, 20);
        assertTrue(euro.minoreDi(euro2));
    }

    @Test
    public void testEuroNotMinoreDi() {
        Euro euro = new Euro(10, 10);
        Euro euro2 = new Euro(10, 9);
        assertFalse(euro.minoreDi(euro2));
    }
    
    @Test
    public void testEuroStampa() {
        Euro euro = new Euro(10, 10);
        assertEquals("10.1 euro", euro.stampa());
    }

    @Test
    public void testEuroStampaNegative() {
        Euro euro = new Euro(-10, 10);
        assertEquals("-10.1 euro", euro.stampa());
    }

    @Test
    public void testEuroStampaZero() {
        Euro euro = new Euro(0, 0);
        assertEquals("0.0 euro", euro.stampa());
    }
}
