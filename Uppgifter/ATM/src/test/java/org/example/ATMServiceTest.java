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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ATMServiceTest {

    @Mock
    BankService bankService;

    @InjectMocks
    ATMService atmService;

    @Test
    public void TestGetUsersFromBank(){
        Card card1 = new Card(1001);
        User user1 = new User("Jonas Persson", card1);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);

        when(bankService.getUsers()).thenReturn(users);
        System.out.println(bankService.getUsers().size());
        assertEquals(atmService.getBankService().getUsers().size(), 1);
    }

    @Test
    public void TestGetUserWithCardId(){
        Card card1 = new Card(1001);
        User user1 = new User("Jonas Persson", card1);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);

        when(bankService.getUsers()).thenReturn(users);
        User actual = atmService.getBankService().getUserFromList(1001);
        System.out.println(actual.getName());
    }
}