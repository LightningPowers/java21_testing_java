package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
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

    //3 Attempting to log in until it locks card
    @Test
    public void TestMultipleIncorrectPinCodes(){
        Card card1 = new Card(10001);
        User user1 = new User("Jonas Persson", card1, 5555);

        when(bankService.verifyPinCode(1337)).thenReturn(2);
        int actual = atmService.getBankService().verifyPinCode(user1.getPinCode());
        assertEquals(2, actual);
    }
}