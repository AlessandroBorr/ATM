package test;
import code.Buisness_logic.Account;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestAccount {

    Account account;

    @BeforeEach
    public void setUp (){
        account = new Account(54321, 12345, 1000.0, 1200.0);
    }

    @AfterEach
    public void tearDown (){
        account = null;
    }

    @Test
    public void testValidatePIN(){
        assertTrue(account.validatePIN(12345));
    }

    @Test
    public void testNotValidatePIN(){
        assertFalse(account.validatePIN(12545));
    }

    @Test
    public void testGetAvailableBalance(){
        assertEquals(1000.0, account.getAvailableBalance());
    }

    @Test
    public void testGetTotalBalance(){
        assertEquals(1200.0, account.getTotalBalance());
    }

    @Test
    public void testCredit(){
        account.credit(100.0);
        assertEquals(1300.0, account.getTotalBalance());
 
    }

    @Test
    public void testDebit(){
        account.debit(100.0);
        assertAll ( () -> assertEquals(1100.0, account.getTotalBalance()),
                    () -> assertEquals(900.0, account.getAvailableBalance()));
    }

    @Test
    public void testGetAccountNumber(){
        assertEquals(54321, account.getAccountNumber());
    }
    
}
