package org.example;

public class LibraryRequest {

    private String userID;
    private boolean isBorrowing;
    private int currentDebt;

    public LibraryRequest(String userID, boolean isBorrowing, int currentDebt) {
        this.userID = userID;
        this.isBorrowing = isBorrowing;
        this.currentDebt = currentDebt;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isBorrowing() {
        return isBorrowing;
    }

    public void setBorrowing(boolean borrowing) {
        isBorrowing = borrowing;
    }

    public int getCurrentDebt() {
        return currentDebt;
    }

    public void setCurrentDebt(int currentDebt) {
        this.currentDebt = currentDebt;
    }
}
