package week3.ATM;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Server {
    private Account[] accounts;
    private AtmBank[] atmBanks;

    public Server() {
        this.accounts = new Account[5];
        this.atmBanks = new AtmBank[5];
    }

    public Account[] getAccounts(){return this.accounts;}
    public AtmBank[] getAtmBanks(){return this.atmBanks;}

    public boolean withdraw(Account account, AtmBank atmBank) {
        Scanner scanned = new Scanner(System.in);
        if (atmBank.validatingUser(account) == true) {
            System.out.println("Insert the amount of money you want to withdraw.");
            double amountMoney = scanned.nextDouble();
            double balance = account.getBalance();
            double moneyAvailableOnAtm = atmBank.getMoneyAvailableOnAtm();
            String accountBankName = account.getBankName();
            String atmBankName = atmBank.getBankName();
            double commission = atmBank.getCommission()/100*amountMoney;
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            if (atmBankName.equals(accountBankName)) {
                if (amountMoney > balance) {
                    System.out.println("Insufficient funds in your account!");
                    return false;
                } else if (amountMoney > moneyAvailableOnAtm) {
                    System.out.println("We apologize, this ATM can not provide the amount of money you want to withdraw from your account!");
                    return false;
                } else{
                    account.setBalance(balance - amountMoney);
                    atmBank.setMoneyAvailableOnAtm(moneyAvailableOnAtm - amountMoney);
                    Date date = new Date();
                    String[] transaction = new String[]{dateFormat.format(date),"Amount withdrawn: "+amountMoney,"At the Bank: "+atmBankName,"Commission: 0.00"};
                    account.history.add(transaction);
                }
            }
            else{
                if (amountMoney + commission > balance) {
                    System.out.println("Insufficient founds in your account!");
                    return false;
                } else if (amountMoney > moneyAvailableOnAtm) {
                    System.out.println("We apologize, this ATM can not provide the amount of money you want to withdraw from your account!");
                    return false;
                } else{
                    account.setBalance(balance - amountMoney - commission);
                    atmBank.setMoneyAvailableOnAtm(moneyAvailableOnAtm - amountMoney);
                    Date date = new Date();
                    String[] transaction = new String[]{dateFormat.format(date),"Amount withdrawn: "+amountMoney,"At the Bank: "+atmBankName,"Commission: "+commission};
                    account.history.add(transaction);
                }
            }
            return true;
        }
        return false;
    }

    public void checkWithdraw(Account account, AtmBank atmBank){
        if(withdraw(account,atmBank)==true){
            System.out.println("Withdraw with success!");
        }
        else{
            System.out.println("Please contact your "+account.getBankName()+" bank. An error has occurred!");
        }
    }

    public void checkBalance(Account account){
        System.out.println("Your balance account is: " + account.getBalance());
    }

    public boolean deposit(Account account, AtmBank atmBank) {
        Scanner scanned = new Scanner(System.in);
        if (atmBank.validatingUser(account) == true) {
            System.out.println("Insert the amount of money you want to deposit.");
            double amountMoney = scanned.nextDouble();
            double balance = account.getBalance();
            double moneyAvailableOnAtm = atmBank.getMoneyAvailableOnAtm();
            String accountBankName = account.getBankName();
            String atmBankName = atmBank.getBankName();
            double commission = atmBank.getCommission()/100*amountMoney;
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            if (atmBankName.equals(accountBankName)) {
                account.setBalance(balance + amountMoney);
                atmBank.setMoneyAvailableOnAtm(moneyAvailableOnAtm + amountMoney);
                Date date = new Date();
                String[] transaction = new String[]{dateFormat.format(date),"Amount deposit: "+amountMoney,"At the Bank: "+atmBankName,"Commission: 0.00"};
                account.history.add(transaction);
            }
            else{
                account.setBalance(balance + amountMoney - commission);
                atmBank.setMoneyAvailableOnAtm(moneyAvailableOnAtm + amountMoney);
                Date date = new Date();
                String[] transaction = new String[]{dateFormat.format(date),"Amount deposit: "+amountMoney,"At the Bank: "+atmBankName,"Commission: "+commission};
                account.history.add(transaction);
            }
            return true;
        }
        return false;
    }

    public void checkDeposit(Account account, AtmBank atmBank){
        if(deposit(account,atmBank)==true){
            System.out.println("Deposit with success!");
        }
        else{
            System.out.println("Please contact your "+account.getBankName()+" bank. An error has occurred!");
        }
    }

    public void changePIN(Account account, AtmBank atmBank){
        Scanner scanned = new Scanner(System.in);
        String accountBankName = account.getBankName();
        String atmBankName = atmBank.getBankName();
        double commission = atmBank.getCommission();
        double balance = account.getBalance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        if (atmBank.validatingUser(account) == true) {
            if (atmBankName.equals(accountBankName)) {
                System.out.println("ACCOUNT DETAILS: ");
                account.printDetails(account);
                System.out.println("Please insert your new PIN.");
                String password = scanned.next();
                account.setPassword(password);
                System.out.println("Operation terminated with success! Your new PIN is: "+password);
                Date date = new Date();
                String[] transaction = new String[]{dateFormat.format(date),"New PIN: "+password,"At the Bank: "+atmBankName,"Commission: 0.00"};
                account.history.add(transaction);
            }
            else{
                if(balance>commission) {
                    System.out.println("ACCOUNT DETAILS: ");
                    account.printDetails(account);
                    System.out.println("Please insert your new PIN.");
                    String password = scanned.next();
                    account.setPassword(password);
                    account.setBalance(balance - commission);
                    System.out.println("Operation terminated with success! Your new PIN is: " + password);
                    Date date = new Date();
                    String[] transaction = new String[]{dateFormat.format(date), "New PIN: " + password, "At the Bank: " + atmBankName, "Commission: " + commission};
                    account.history.add(transaction);
                }
                else{
                    System.out.println("Insufficient funds in your account to change your PIN on this ATM bank!");
                }
            }
        }
    }

    private double verifyAmountToTrasfer(Account account, double amountOfMoney){
        Scanner scanned = new Scanner(System.in);
        double balance = account.getBalance();
        while(amountOfMoney>balance){
            System.out.println("Insufficient funds to transfer. Please insert an amount of money less than "+balance+"!");
            double newAmount = scanned.nextDouble();
            if(newAmount<balance){
                return newAmount;
            }
        }
        return amountOfMoney;
    }

    private boolean checkExistingAccounts(String account, Account[] accounts) {
        for(Account acc : accounts){
            if(acc.getAccount().equals(account)){
                return true;
            }
        }
        return false;
    }

    public void transfer (Account accountThatTransfers, Server accounts){
        AtmBank atmBank = new AtmBank();
        double balance = accountThatTransfers.getBalance();
        Scanner scanned = new Scanner(System.in);
        Account[] accountsFromServer = accounts.getAccounts();
        if (atmBank.validatingUser(accountThatTransfers) == true) {
            System.out.println("Insert the amount you want to transfer.");
            double amountToTransfer = scanned.nextDouble();
            verifyAmountToTrasfer(accountThatTransfers,amountToTransfer);
            System.out.println("Insert the account you want to transfer money.");
            String accountToTrasnfer = scanned.next();
            if (checkExistingAccounts(accountToTrasnfer,accountsFromServer)==true){
                accountThatTransfers.setBalance(balance-verifyAmountToTrasfer(accountThatTransfers,amountToTransfer));
                for(Account acc:accountsFromServer){
                    if(accountThatTransfers.getAccount().equals(acc.getAccount())){
                        acc.setBalance(acc.getBalance()+verifyAmountToTrasfer(accountThatTransfers,amountToTransfer));
                    }
                }
            }
        }
        else{
            System.out.println("Please contact your "+accountThatTransfers.getBankName()+" bank. An error has occurred!");
        }
    }
}
