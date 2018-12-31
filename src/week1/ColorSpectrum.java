package week1;
import java.util.Scanner;
import java.lang.System;

//Exercise 13

public class ColorSpectrum {
    private static final double RED = 4.29;
    private static final double ORANGE = 5.00;
    private static final double YELLOW = 5.16;
    private static final double GREEN = 5.45;
    private static final double CYAN = 5.99;
    private static final double BLUE = 6.66;
    private static final double INDIGO = 7.08;
    private static final double VIOLET = 7.50;

    private static boolean InRange(double color){
        return (color>=RED && color<=VIOLET)?true:false;
    }

    private static void GetColourName(double color){
        String message1=(color==RED && InRange(color)==true)?"For the frequency "+color+" the color is RED!":"";
        String message2=(color>RED && color<ORANGE)?"For the frequency "+color+" the color is between RED and ORANGE!":"";
        String message3=(color==ORANGE && InRange(color)==true)?"For the frequency "+color+" the color is ORANGE!":"";
        String message4=(color>ORANGE && color<YELLOW)?"For the frequency "+color+" the color is between ORANGE and YELLOW!":"";
        String message5=(color==YELLOW && InRange(color)==true)?"For the frequency "+color+" the color is YELLOW!":"";
        String message6=(color>YELLOW && color<GREEN)?"For the frequency "+color+" the color is between YELLOW and GREEN!":"";
        String message7=(color==GREEN && InRange(color)==true)?"For the frequency "+color+" the color is GREEN!":"";
        String message8=(color>GREEN && color<CYAN)?"For the frequency "+color+" the color is between GREEN and CYAN!":"";
        String message9=(color==CYAN && InRange(color)==true)?"For the frequency "+color+" the color is CYAN !":"";
        String message10=(color>CYAN && color<BLUE)?"For the frequency "+color+" the color is between CYAN and BLUE!":"";
        String message11=(color==BLUE&& InRange(color)==true)?"For the frequency "+color+" the color is BLUE!":"";
        String message12=(color>BLUE && color<INDIGO)?"For the frequency "+color+" the color is between BLUE and INDIGO!":"";
        String message13=(color==INDIGO && InRange(color)==true)?"For the frequency "+color+" the color is INDIGO!":"";
        String message14=(color>INDIGO && color<VIOLET)?"For the frequency "+color+" the color is between INDIGO and VIOLET!":"";
        String message15=(color==VIOLET && InRange(color)==true)?"For the frequency "+color+" the color is VIOLET!":"";
        String message16=(InRange(color)==false)?"The frequency is not recognized by human eye!":"";
        System.out.println(message1+message2+message3+message4+message5+message6+message7+message8+message9+message10+message11+message12+message13+message14+message15+message16);
    }

    public static void main(String[] args) {
        System.out.println("This program provide the name of a colour if user inserts a frequency in Hertz.");
        System.out.println("================================================================");
        System.out.println("Please insert the value for frequency in Hertz.\n\n");
        Scanner scanned = new Scanner(System.in);
        System.out.println("Value in Hertz for frequency is: ");
        double color = scanned.nextDouble();
        GetColourName(color);
    }
}
