package week2;

import java.lang.Math;

public class NewChessBoard {
    public static void newKnightMoves(int x, int y){
        int[] direction = {-2,-1,1,2};
        for(int i=0;i<direction.length; i++){
            for(int j=0;j<direction.length;j++){
                int sum = Math.abs(direction[i]+direction[j]);
                //valid move
                if( sum ==1 || sum ==3){
                    if(isOnBoard(x+direction[i],y+direction[j])){
                        System.out.println("Valid position: ("+(x+direction[i])+", "+(y+direction[j])+");");
                    }
                }
            }
        }
    }

    public static boolean isOnBoard(int x, int y) {
        return x<=8 && x>=1 && y<=8 && y>=1;
    }
}