package week3.Arrays;

public class MyArrayList {
    private int[] values;
    private int index;

    public MyArrayList(){
        this.values = new int[0];
        this.index = -1;
    }

    public void add(int newValue) {
        if (index > this.values.length - 1) {
            int[] array = new int[this.values.length + 1];
            for (int i=0; i<=index; i++) {
                array[i]=values[i];
            }
            values=array;
        }
        values[index++]=newValue;
        index++;
    }
    //TO DO
}
