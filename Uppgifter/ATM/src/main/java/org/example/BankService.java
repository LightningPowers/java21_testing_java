package org.example;

import java.util.ArrayList;

public class BankService {

    private ArrayList<User> userList = new ArrayList<>();
    private boolean loggedIn = false;
    private int remainingAttempts = 3;

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

    public int verifyPinCode(int pinCode) {
        boolean couldLogin = false;

        for (User user: userList){
            if (pinCode == user.getPinCode()){
                couldLogin = true;
                remainingAttempts = 3;
            }
        }
        if (!couldLogin && remainingAttempts > 0){
            remainingAttempts--;
        }
        else if(!couldLogin){
            for (User user: userList){
                if (pinCode == user.getPinCode()){
                    user.getCard().setLocked(true);
                }
            }
        }
        return remainingAttempts;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
