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
        //new Game().play(5);
    }

    public void play(int numOfSteps){
        gameGrid = new Grid(5,5, 15);
        ruleSet = new RuleSet();
        System.out.println("step 0");
        gameGrid.printGrid();

        for(int i = 1; i <= numOfSteps; i++){
            System.out.println("step " + i);
            gameGrid = ruleSet.applyRules(gameGrid);
            gameGrid.printGrid();
        }

    }

}
