package org.example;

public class ATMService {

    private BankService bankService;
    private int remainingAttempts = 3;


    public ATMService(BankService bankService) {
        this.bankService = bankService;
    }

    public BankService getBankService() {
        return bankService;
    }

    public User getUserFromList(int id) {
        User returnedUser = null;
        for (User user: getBankService().getUsers()){
            if (id == user.getId()){
                returnedUser = user;
            }
        }
        return returnedUser;
    }

    public int verifyPinCode(int pinCode, Card card) {
        boolean couldLogin = false;

        for (User user: bankService.getUsers()){
            if (pinCode == user.getPinCode()) {
                couldLogin = true;
                remainingAttempts = 3;
                break;
            }
        }

        if(!couldLogin && remainingAttempts == 1){
            card.setLocked(true);
            remainingAttempts--;
            System.out.println("Remaining attempts: " + remainingAttempts);
            System.out.println("Locked card!");
        }
        else if (!couldLogin && remainingAttempts > 1){
            remainingAttempts--;
            System.out.println("Remaining attempts: " + remainingAttempts);
        }
        return remainingAttempts;
    }
}
