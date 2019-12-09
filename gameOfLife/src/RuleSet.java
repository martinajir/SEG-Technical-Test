public class RuleSet {

    public RuleSet() { }

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

    private boolean survives(boolean isAlive, int neighbourCount) {
        if ((neighbourCount == 2 || neighbourCount == 3) && isAlive) {
            return true;
        } else if (neighbourCount == 3 && !isAlive) {
            return true;
        }

        return false;
    }

}
