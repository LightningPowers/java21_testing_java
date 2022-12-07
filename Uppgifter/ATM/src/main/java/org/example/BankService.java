package org.example;

import java.util.ArrayList;

public class BankService {

    private ArrayList<User> userList = new ArrayList<>();
    private boolean loggedIn = false;

    public ArrayList<User> getUsers(){
        return userList;
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

    public boolean signOut(){
        loggedIn = false;
        return true;
    }

    public static String getAtmBank(){
        return "något";
    }
}
