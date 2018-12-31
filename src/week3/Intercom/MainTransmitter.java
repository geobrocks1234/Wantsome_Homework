package week3.Intercom;

import java.util.Scanner;
import java.util.Random;

public class MainTransmitter {
    private int idNumber;
    private String message;
    private final static String getKeyCode = "Key005Enter01024";
    private Receiver[] receivers;
    private boolean isOpened;
    final static String chars = "01";

    public MainTransmitter(int apartmentNumber, String message){
        this.idNumber = apartmentNumber;
        this.message = message;
        //numbers of receivers
        this.receivers = new Receiver[19];
        this.isOpened = false;
    }

    public String getMessage(){
        return  message;
    }

    public int getIdNumber(){
        return idNumber;
    }

    public Receiver[] getReceivers(){
        return receivers;
    }

    public void setIsOpened(boolean isOpened){

        this.isOpened = isOpened;
    }

    private char checkInput(String input){
        Scanner scanned = new Scanner(System.in);
        while(input!="0" || input!="1") {
            System.out.println("If you want to enter the building please type 0 to scan your key card or 1 to call an ID!");
            String outChar = scanned.next();
            if(outChar.equals("1") || outChar.equals("0"))
                return outChar.toCharArray()[0];
        }
        return input.toCharArray()[0];
    }

    private Receiver getRandomReceiverId(Receiver[] receivers) {
        int rnd = new Random().nextInt(receivers.length);
        return receivers[rnd];
    }

    private boolean callingId(char c){
        if(c=='0'){
            System.out.println("Apartment ID is not answering!");
        } else if (c == '1') {
            getRandomReceiverId(this.receivers).setIsReceiver(true);
            System.out.println("Hello! Who is it?");
            return true;
        }
        return false;
    }

    private void enterTheBuilding(){
        System.out.println("Hello!");
        Scanner scanned = new Scanner(System.in);
        String input = scanned.next();
        Random rnd = new Random();
        char c = chars.charAt(rnd.nextInt(chars.length()));
        if(checkInput(input)=='0'){
            System.out.println("Please scan your key card!");
            Scanner scan = new Scanner(System.in);
            System.out.println("Your key code is: ");
            String keyCard = scan.next();
            if(keyCard.equals(getKeyCode)){
                ActivateEnter.activate();
                setIsOpened(true);
                while(isOpened==true){
                    if(ActivateEnter.isActive()==true) {
                        System.out.println("The door is open!");
                    }
                    else {
                        System.out.println("The 5 seconds for entering the building has expired. Please scan again your key card or call an apartment!");
                        setIsOpened(false);
                    }
                }
            }
        }
        else if(checkInput(input)=='1'){
            setIsOpened(false);
            while(isOpened==true){
                if(callingId(c)==true) {
                    callingId(c);
                    ActivateEnter.activate();
                    Scanner scann = new Scanner(System.in);
                    String message = scann.next();
                    System.out.println("Come in, "+message+"!");
                }
                else {
                    System.out.println("The 5 seconds for entering the building has expired. Please scan again your key card or call an apartment!");
                    setIsOpened(true);
                }
            }
        }

    }

}
