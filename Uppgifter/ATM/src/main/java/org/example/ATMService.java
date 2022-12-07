package org.example;

public class ATMService {

    private BankService bankService;

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
}
