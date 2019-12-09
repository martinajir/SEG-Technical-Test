package gameOfLife.rules;

import gameOfLife.structures.Cell;
import gameOfLife.structures.Grid;
import gameOfLife.structures.GridIterator;

public class RuleSet {

    /**
     * Iterate through grid and change each cell according to gameOfLife.rules
     * @param gameGrid current game grid
     * @return game grid at the next step of the game
     */
    public Grid applyRules(Grid gameGrid){
        Grid newGrid = new Grid(gameGrid.getMaxX(), gameGrid.getMaxY());
        GridIterator gridIterator = (GridIterator) gameGrid.iterator();
        while(gridIterator.hasNext()){
            Cell thisCell = gridIterator.next();
            int x = thisCell.getX();
            int y = thisCell.getY();
            boolean willSurvive = survives(thisCell.hasLife(), gameGrid.getNeighbourCount(x, y));
            if (willSurvive) {
                newGrid.get(x, y).setLife(true);
            } else {
                newGrid.get(x, y).setLife(false);
            }
        }

        return newGrid;
    }

    /**
     * Evaluate if a given cell will survive according to supplied gameOfLife.rules
     * @param isAlive is true if this cell contains life
     * @param neighbourCount is the number of neighbours of this cell
     * @return true if cell will survive to the next step
     */
    private boolean survives(boolean isAlive, int neighbourCount) {
        if ((neighbourCount == 2 || neighbourCount == 3) && isAlive) {
            return true;
        } else if (neighbourCount == 3 && !isAlive) {
            return true;
        }

        return false;
    }

}
