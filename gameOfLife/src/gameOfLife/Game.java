package gameOfLife;

import gameOfLife.gui.GameWindow;

public class Game {
    public static final int STARTER_CELLS_COUNT = 15;

    public static void main(String[] args){
        if(args.length == 2) {
            new GameWindow(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
        else {
            System.out.println("Bad args. Please input 2 integer arguments - no. of columns and no. of rows.");
            System.out.println("Using default size 5x5");
            new GameWindow(5, 5);
        }
    }
}
