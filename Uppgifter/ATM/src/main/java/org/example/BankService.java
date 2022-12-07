package org.example;

import java.util.ArrayList;

public class BankService {

    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUsers(){
        return userList;
    }

    public void depositBalance(User user, double balanceToDeposit){
        if(balanceToDeposit > 0){
            double currentBalance = user.getAccount().getBalance();

            user.getAccount().setBalance(
                    currentBalance + balanceToDeposit
            );
        }
    }

    public String withdrawBalance(User user, double balanceToWithdraw){
        String returnString = "";

        double currentBalance = user.getAccount().getBalance();
        user.getAccount().setBalance(currentBalance - balanceToWithdraw);
        returnString = "Specified balance of " + balanceToWithdraw + "was withdrawn successfully!";

        return returnString;
    }

    public static String getAtmBank(){
        return "Insert bank name here";
    }
}
