package week3.ATM;

import java.util.Scanner;

public class AtmBank {
    private double moneyAvailableOnAtm;
    private String bankName;
    private double commission;

    public AtmBank(double moneyAvailableOnAtm, String bankName, double commission) {
        this.moneyAvailableOnAtm = moneyAvailableOnAtm;
        this.bankName = bankName;
        this.commission = commission;
    }

    public AtmBank(){}

    public String getBankName() { return bankName;}
    public double getCommission() { return commission;}
    public double getMoneyAvailableOnAtm(){ return moneyAvailableOnAtm;}

    public void setMoneyAvailableOnAtm(double moneyAvailableOnAtm) {
        this.moneyAvailableOnAtm = moneyAvailableOnAtm;
    }

    private char verifyInput(String input){
        Scanner scanned = new Scanner(System.in);
        while(input!="0" || input!="1") {
            System.out.println("Please insert just 0 for CANCEL or 1 for CONTINUE to authentication!");
            String outChar = scanned.next();
            if(outChar.equals("1") || outChar.equals("0"))
                return outChar.toCharArray()[0];
        }
        return input.toCharArray()[0];
    }

    private boolean verifyPermission(char verify){
        if (verify=='0'){
            return false;
        }
        return true;
    }

    public boolean validatingUser(Account user) {
        Scanner scanned = new Scanner(System.in);
        System.out.println("ACCOUNT: ");
        String account = scanned.next();
        System.out.println("PIN: ");
        String password = scanned.next();
        if(bankName!=user.getBankName()){
            System.out.println(bankName+ "takes "+commission+" % commission!");
            System.out.println("Do you want to continue?");
            String input = scanned.next();
            if(verifyPermission(verifyInput(input))==false){
                return false;
            }
        }
        int i = 0;
        while (i < 4) {
            if (user.getAccount().equals(account) && user.getPassword().equals(password)) {
                System.out.println("Authentication successful!");
                i = 4;
                return true;
            } else {
                System.out.println("Authentication failed! Wrong Account or PIN!");
                i++;
                switch (i) {
                    case 1:
                        System.out.println("Two more tries remaining!");
                        break;
                    case 2:
                        System.out.println("One more try remaining!");
                        break;
                    case 3:
                        System.out.println("Sorry, your account is temporarily locked. Please try again later.");
                        i = 4;
                        break;
                    default:
                        System.out.println("Invalid credentials. Verify your account at your bank: " + user.getBankName());
                }
            }
        }
        return false;
    }
}