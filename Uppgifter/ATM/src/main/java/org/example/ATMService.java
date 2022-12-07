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

    public int verifyPinCode(int pinCode) {
        boolean couldLogin = false;

        for (User user: bankService.getUsers()){
            if (pinCode == user.getPinCode()) {
                couldLogin = true;
                remainingAttempts = 3;
                break;
            }
        }
        if (!couldLogin && remainingAttempts > 0){
            remainingAttempts--;
        }
        else if(!couldLogin){
            for (User user: bankService.getUsers()){
                if (pinCode == user.getPinCode()){
                    user.getCard().setLocked(true);
                }
            }
        }
        System.out.println("Remaining attempts: " + remainingAttempts);
        return remainingAttempts;
    }
}
