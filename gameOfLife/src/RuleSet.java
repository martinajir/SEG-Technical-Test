public class RuleSet {

    public RuleSet() {

    }

    public Grid applyRules(Grid gameGrid) throws CloneNotSupportedException{
        Grid newGrid = new Grid(gameGrid.getMaxX(), gameGrid.getMaxY());
        for(int x = 0; x < gameGrid.getMaxX(); x++){
            for(int y = 0; y < gameGrid.getMaxY();y++) {
                boolean willSurvive = survives(gameGrid.get(x, y).hasLife(), gameGrid.getNeighbourCount(x, y));
                if (willSurvive) {
                    newGrid.get(x, y).setLife(true);
                } else {
                    newGrid.get(x, y).setLife(false);
                }
            }

        }
        return newGrid;
    }

    private boolean survives(boolean isAlive, int neighbourCount) {
        if ((neighbourCount == 2 || neighbourCount == 3) && isAlive) {
            return true;
        } else if (neighbourCount == 3 && !isAlive) {
            return true;
        }

        return false;
    }

}
