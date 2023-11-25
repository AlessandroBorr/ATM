package test;
import code.Buisness_logic.Euro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEuro {

    // Test per il constructor di Euro, con solo euro, euro e cent, zero e euro negativi
    @Test
    public void testEuroOnlyEuro() {
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
    public void testEuroNegativeOnlyEuro() {
        Euro euro = new Euro(-10);
        assertEquals(-1000, euro.getValore());
    }

    @Test
    public void testEuroNegativeWithCent() {
        Euro euro = new Euro(-10, 10);
        assertEquals(-1010, euro.getValore());
    }

    // Test per convertire double a Euro positivo, negativo e zero

    @Test
    public void testEuroDouble() {
        Euro euro = new Euro(10.10);
        assertEquals(1010, euro.getValore());
    }

    @Test
    public void testEuroDoubleNegative() {
        Euro euro = new Euro(-10.10);
        assertEquals(-1010, euro.getValore());
    }

    @Test
    public void testEuroDoubleZero() {
        Euro euro = new Euro(0.0);
        assertEquals(0, euro.getValore());
    }

    // Test per la somma di Euro

    @Test
    public void testEuroSomma() {
        Euro euro = new Euro(10, 10);
        Euro euro2 = new Euro(10, 10);
        euro.somma(euro2);
        assertEquals(2020, euro.getValore());
    }

    // Test per la sottrazione di Euro

    @Test
    public void testEuroSottrai() {
        Euro euro = new Euro(10, 10);
        Euro euro2 = new Euro(10, 10);
        euro.sottrai(euro2);
        assertEquals(0, euro.getValore());
    }

    // Test per l'uguaglianza/disuguaglianza di due oggetti Euro

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

    // Test per valutare se un oggetto Euro sia minore/non minore di un altro

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
    
    // Test per la stampa di un oggetto Euro positivo, negativo e zero

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
