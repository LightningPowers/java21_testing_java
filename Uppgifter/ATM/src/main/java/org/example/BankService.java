package org.example;

import java.util.ArrayList;

public class BankService {

    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUsers(){
        return userList;
    }

    public User getUserFromList(double id) {
        User returnedUser = null;

        for (User user: userList){
            if (id == user.getId()){
                returnedUser = user;
            }
        }
        return returnedUser;
    }

    public boolean verifyPinCode(int pinCode) {
        int remainingAttempts = 3;
        boolean couldLogin = false;

        for (User user: userList){
            if (pinCode == user.getPinCode()){
                couldLogin = true;
            }
        }
        if (!couldLogin){
            remainingAttempts--;
            System.out.println("message to user here");
        }

        return couldLogin;
    }
}
