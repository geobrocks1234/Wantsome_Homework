package week1;
import java.util.Scanner;
import java.lang.System;

//Exercise 11

public class ChessBoard {

    private static boolean CheckPosition(int column, int row){
        boolean a = (column>0 && column<9)?true:false;
        boolean b = (row>0 && row<9)?true:false;
        boolean check = (a==true && b==true)?true:false;
        return check;
    }

    private static void CalculateMoves(int column, int row){
        int col1 = column-1, row1 = row-2;
        boolean a = CheckPosition(col1,row1)?true:false;
        String message1 = (a==true)?"("+col1+","+row1+")\n":"";
        int col2 = column-2, row2 = row-1;
        boolean b = CheckPosition(col2,row2)?true:false;
        String message2 = (b==true)?"("+col2+","+row2+")\n":"";
        int col3 = column+1, row3 = row-2;
        boolean c = CheckPosition(col3,row3)?true:false;
        String message3 = (c==true)?"("+col3+","+row3+")\n":"";
        int col4 = column+2, row4 = row+1;
        boolean d = CheckPosition(col4,row4)?true:false;
        String message4 = (d==true)?"("+col4+","+row4+")\n":"";
        int col5 = column-2, row5 = row+1;
        boolean e = CheckPosition(col5,row5)?true:false;
        String message5 = (e==true)?"("+col5+","+row5+")\n":"";
        int col6 = column-1, row6 = row+2;
        boolean f = CheckPosition(col6,row6)?true:false;
        String message6 = (f==true)?"("+col6+","+row6+")\n":"";
        int col7 = column+1, row7 = row+2;
        boolean g = CheckPosition(col7,row7)?true:false;
        String message7 = (g==true)?"("+col7+","+row7+")\n":"";
        int col8 = column+2, row8 = row+1;
        boolean h = CheckPosition(col8,row8)?true:false;
        String message8 = (h==true)?"("+col8+","+row8+")\n":"";
        System.out.println("Possible moves of the knight are:\n"+message1+""+message2+""+message3+""+message4+""+message5+""+message6+""+message7+""+message8);
    }

    public static void main(String[] args){
        System.out.println("This program calculates the moves of the given column and row for a knight on chess board.");
        System.out.println("================================================================\n\n");
        System.out.println("Please insert the values for column and row origin for the knight on chess board.");

        Scanner scanned = new Scanner(System.in);
        System.out.println("Column value is : ");
        int c = scanned.nextInt();
        System.out.println("Row value is : ");
        int r = scanned.nextInt();
        String massage = (CheckPosition(c,r)==true)?"Origin given is suitable!\n":"Please insert a position that includes numbers between 1 and 8 inclusive!\n";
        System.out.println(massage);
        CalculateMoves(c,r);
    }
}
