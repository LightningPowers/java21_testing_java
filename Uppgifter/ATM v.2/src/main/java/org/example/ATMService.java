package org.example;

public class ATMService {

    private BankService bankService;

    public ATMService(BankService bankService) {
        this.bankService = bankService;
    }

    public void logonToATMWithUser(User user){
        //do stuff
    }

    public BankService getBankService() {
        return bankService;
    }
}
