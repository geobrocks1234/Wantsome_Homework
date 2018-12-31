package week3.ATM;

import java.util.List;

public class Account {
    private String account;
    private String password;
    private String bankName;
    public List<String[]> history;
    private double balance;

    public Account(String account, String password, double balance, String bankName, List<String[]> history){
        this.account = account;
        this.password = password;
        this.balance = balance;
        this.bankName = bankName;
        this.history = history;
    }

    public String getAccount() {return this.account;}
    public String getPassword() {return  this.password;}
    public String getBankName() {return this.bankName;}
    public double getBalance() {return this.balance;}
    public List<String[]> getHistory() {return this.history;}
    public void setPassword(String password){this.password=password;}
    public void setBalance(double balance) {this.balance = balance;}

    public void printDetails(Account account){
        System.out.println("Your account is: "+ account.getAccount());
        System.out.println("Your PIN is: "+account.getPassword());
        System.out.println("Your bank account is on: "+account.getBankName());
        System.out.println("Your balance is: "+ account.getBalance());
        System.out.println("Your transactions: ");
        for (String[] transaction : account.getHistory()){
            int len = transaction.length;
            for(int i=0;i<len;i++){
                System.out.println("Transaction "+i+": ");
                System.out.println(transaction[i]);
            }
        }
    }
}
