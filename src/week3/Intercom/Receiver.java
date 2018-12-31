package week3.Intercom;

public class Receiver {
    private int apartmentNumber;
    private boolean isReceiver;

    public Receiver(int apartmentNumber, boolean isReceiver){
        this.apartmentNumber = apartmentNumber;
        this.isReceiver = isReceiver;
    }

    public Receiver(int apartmentNumber){
        this.apartmentNumber = apartmentNumber;
        this.isReceiver = true;
    }

    public boolean getIsReceiver(){
        return isReceiver;
    }

    public int getApartmentNumber(){
        return apartmentNumber;
    }

    public void setIsReceiver(boolean isReceiver){
        this.isReceiver = isReceiver;
    }
}
