package gameOfLife;

import gameOfLife.gui.GameWindow;

public class Game {
    public static final int STARTER_CELLS_COUNT = 15;

    public static void main(String[] args){
        new GameWindow(5,5);
    }
}
