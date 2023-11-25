package test;
import code.Database.BankDatabase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBankDatabase {
    
    BankDatabase bankDatabase;

    @BeforeEach
    public void setUp (){
        bankDatabase = new BankDatabase();
    }

    @AfterEach
    public void tearDown (){
        bankDatabase = null;
    }

    @Test
    public void testAuthenticateUser(){
        assertTrue(bankDatabase.authenticateUser(12345, 54321));
    }

    @Test
    public void testNotAuthenticateUser(){
        assertFalse(bankDatabase.authenticateUser(12346, 64321));
    }

    @Test
    public void testGetAvailableBalance(){
        assertEquals(1000.0, bankDatabase.getAvailableBalance(12345));
    }

    @Test
    public void testGetTotalBalance(){
        assertEquals(1200.0, bankDatabase.getTotalBalance(12345));
    }

    @Test
    public void testCredit(){
        bankDatabase.credit(12345, 100.0);
        assertEquals(1300.0, bankDatabase.getTotalBalance(12345));
    }

    @Test
    public void testDebit(){
        bankDatabase.debit(12345, 100.0);
        assertAll ( () -> assertEquals(1100.0, bankDatabase.getTotalBalance(12345)),
                    () -> assertEquals(900.0, bankDatabase.getAvailableBalance(12345)));
    }

}
