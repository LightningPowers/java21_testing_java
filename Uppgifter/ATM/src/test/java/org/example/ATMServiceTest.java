package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ATMServiceTest {

    Card card1;
    User user1;
    ArrayList<User> users = new ArrayList<>();

    @Mock
    BankService bankService;

    @InjectMocks
    ATMService atmService;

    @BeforeEach
    public void setUp(){
        card1 = new Card(10001);
        user1 = new User("Jonas Persson", card1, 5555);
        users.add(user1);
    }

    @Test
    public void TestGetUsersFromBank() {
        when(bankService.getUsers()).thenReturn(users);
        System.out.println(bankService.getUsers().size());
        assertEquals(atmService.getBankService().getUsers().size(), 1);
    }

    //1 Using card ID, returns associated user
    @Test
    public void TestGetUserWithCardId() {
        when(bankService.getUsers()).thenReturn(users);
        User actual = atmService.getUserFromList(user1.getId());
        assertEquals(user1, actual);
    }

    @Test
    public void TestNotGetUserWithCardId() {
        when(bankService.getUsers()).thenReturn(users);
        User actual = atmService.getUserFromList(15121);
        assertNull(actual);
    }

    //2 Login successfully with PIN code
    @Test
    public void TestCorrectPinCode() {
        when(bankService.getUsers()).thenReturn(users);
        int actual = atmService.verifyPinCode(user1.getPinCode(), card1);
        assertEquals(3, actual);
    }

    //3 Failing to log in with multiple attempts
    @Test
    public void TestMultipleIncorrectPinCodes() {
        when(bankService.getUsers()).thenReturn(users);
        atmService.verifyPinCode(10100, card1);
        atmService.verifyPinCode(11000, card1);
        int actual = atmService.verifyPinCode(10010, card1);
        assertEquals(0, actual);
    }

    //4 Check if card is locked before logging in
    @Test
    public void TestIfCardIsLocked() {
        Card card1 = new Card(10001);

        boolean actual = atmService.insertCard(card1);
        assertFalse(actual);
    }

    //5 Getting account balance from user account via bank
    @ParameterizedTest
    @ValueSource(doubles = {1004.2, 2700.62, 7001.13})
    public void TestCheckAccountBalance(double accountBalance) {
        users.get(0).getAccount().setBalance(accountBalance);

        when(bankService.getUsers()).thenReturn(users);
        double actual = atmService.checkAccountBalance(10001);
        assertEquals(accountBalance, actual);
    }

    //6 Deposit balance into account via bank
    @Test
    public void TestDepositBalance() {
        atmService.depositToAccount( 100, user1);
        verify(bankService, times(1)).depositBalance(any(), anyDouble());
    }

    //7 Withdraw balance from account via bank
    @Test
    public void TestWithdrawBalance() {
        user1.getAccount().setBalance(1500);
        atmService.withdrawFromAccount(1337, user1);
        verify(bankService, times(1)).withdrawBalance(any(), anyDouble());
    }

    //8 Withdrawing balance with insufficient funds
    @Test
    public void TestInsufficientBalance() {
        user1.getAccount().setBalance(3000);

        String actual = atmService.withdrawFromAccount(5000, user1);
        assertEquals("Insufficient balance. No funds were withdrawn!", actual);
    }

    //9 Exit the bank process
    @Test
    public void TestLogOut() {
        boolean actual = atmService.signOut();
        assertFalse(actual);
    }

    //10 Get ATM's associated bank name
    @Test
    public void TestGetAtmBankName() {
        try (MockedStatic<BankService> mockedStatic = mockStatic(BankService.class)) {
            mockedStatic.when(BankService::getAtmBank).thenReturn("United Banks of Scandinavia");

            assertEquals("United Banks of Scandinavia", BankService.getAtmBank());
        }
    }
}