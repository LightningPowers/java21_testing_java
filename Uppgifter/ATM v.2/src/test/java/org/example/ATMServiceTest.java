package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ATMServiceTest {

    @Mock
    BankService bankService;

    @InjectMocks
    ATMService atmService;

    @Test
    public void TestGetUsersFromBank(){
        Card card1 = new Card(10001);
        User user1 = new User("Jonas Persson", card1, 5555);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);

        when(bankService.getUsers()).thenReturn(users);
        System.out.println(bankService.getUsers().size());
        assertEquals(atmService.getBankService().getUsers().size(), 1);
    }

    //1 Using card ID, returns associated user
    @Test
    public void TestGetUserWithCardId(){
        Card card1 = new Card(10001);
        User user1 = new User("Jonas Persson", card1, 5555);

        when(bankService.getUserFromList(anyDouble())).thenReturn(user1);
        User actual = atmService.getBankService().getUserFromList(card1.getId());
        assertEquals(user1, actual);
    }

    //2 Login successfully with PIN code
    @Test
    public void TestCorrectPinCode(){
        Card card1 = new Card(10001);
        User user1 = new User("Jonas Persson", card1, 5555);

        when(bankService.verifyPinCode(anyInt())).thenReturn(3);
        int actual = atmService.getBankService().verifyPinCode(user1.getPinCode());
        assertEquals(3, actual);
    }

    //3 Logging in with multiple attempts
    @Test
    public void TestMultipleIncorrectPinCodes(){
        Card card1 = new Card(10001);
        User user1 = new User("Jonas Persson", card1, 5555);

        when(bankService.verifyPinCode(anyInt())).thenReturn(0);
        int actual = atmService.getBankService().verifyPinCode(user1.getPinCode());
        assertEquals(0, actual);
    }

    //4 Check if card is locked when logging in
    @Test
    public void TestIfCardIsLocked(){
        Card card1 = new Card(10001);

        when(bankService.insertCard(card1)).thenReturn(true);
        boolean actual = atmService.getBankService().insertCard(card1);
        assertTrue(actual);
    }

    //5 Getting account balance from user account via bank
    @ParameterizedTest
    @ValueSource(doubles = {1001.2, 2700.62, 7001.13})
    public void TestCheckAccountBalance(double accountBalance){
        Card card1 = new Card(10001);
        User user1 = new User("Jonas Persson", card1, 5555);

        when(bankService.checkAccountBalance(user1)).thenReturn(accountBalance);
        double actual = atmService.getBankService().checkAccountBalance(user1);
        assertEquals(accountBalance, actual);
    }

    //6 Deposit balance into account via bank
    @ParameterizedTest
    @ValueSource(doubles = {1001.2, 2700.62, 7001.13})
    public void TestDepositBalance(double balanceToDeposit){
        Card card1 = new Card(10001);
        User user1 = new User("Jonas Persson", card1, 5555);

        when(bankService.depositBalance(user1, balanceToDeposit)).thenReturn(true);
        boolean actual = atmService.getBankService().depositBalance(user1, balanceToDeposit);
        assertNotEquals(false, actual);
    }

    //6 Deposit balance into account via bank
    @Test
    public void TestDepositBalance2(){
        Card card1 = new Card(10001);
        User user1 = new User("Jonas Persson", card1, 5555);

        verify(bankService.depositBalance(user1, 420));
    }

    //7 Withdraw balance from account via bank
    @Test
    public void TestWithdrawBalance(){

    }
}