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
}
