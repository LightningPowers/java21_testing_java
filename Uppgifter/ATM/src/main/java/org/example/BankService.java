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
        System.out.println("Remaining attempts: " + remainingAttempts);
        return remainingAttempts;
    }

    public boolean insertCard(Card card){
        if (!card.isLocked()){
            loggedIn = true;
        }
        return loggedIn;
    }

    public double checkAccountBalance(User user){
        return user.getAccount().getBalance();
    }

    public boolean depositBalance(User user, double balanceToDeposit){
        boolean isSuccessful = true;

        if(balanceToDeposit > 0){
            double currentBalance = user.getAccount().getBalance();

            user.getAccount().setBalance(
                    currentBalance += balanceToDeposit
            );
        }
        else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    public String withdrawBalance(User user, double balanceToWithdraw){
        String returnString = "";

        if(user.getAccount().getBalance() > balanceToWithdraw){
            double currentBalance = user.getAccount().getBalance();
            user.getAccount().setBalance(
                    currentBalance -= balanceToWithdraw
            );
            returnString = "Specified balance of " + balanceToWithdraw + "was withdrawn successfully!";
        }
        else {
            returnString = "Insufficient balance. No funds were withdrawn!";
        }

        return returnString;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
