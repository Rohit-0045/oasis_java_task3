import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String userID;
    private String userPin;
    private int balance;

    private List<String> transactionHistoryList  = new ArrayList<>();
    public User() {
    }

    public User(String userID, String userPin) {
        this.userID = userID;
        this.userPin = userPin;
        this.balance = 0;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPin() {
        return userPin;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public List<String> getTransactionHistoryList() {
        return transactionHistoryList;
    }

    public void setTransaction(String statement) {
        this.transactionHistoryList.add(statement);
    }

}
