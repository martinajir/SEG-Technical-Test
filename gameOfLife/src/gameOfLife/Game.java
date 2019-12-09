package gameOfLife;

import gameOfLife.gui.GameWindow;
import gameOfLife.rules.RuleSet;
import gameOfLife.structures.Grid;

public class Game {
    public static final int STARTER_CELLS_COUNT = 15;

    private Grid gameGrid;
    private RuleSet ruleSet;

    public static void main(String[] args){
        new GameWindow(5,5);
    }
}
