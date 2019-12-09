package gameOfLife.structures;

import java.util.Iterator;

/**
 * Iterator that allows easier access to the internal 2-dimensional array
 */
public class GridIterator implements Iterator {
    int currentX;
    int currentY;
    int maxX;
    int maxY;
    Grid grid;

    public GridIterator (Grid grid) {
        this.grid = grid;
        currentX = 0;
        currentY = 0;
        maxX = grid.getMaxX();
        maxY = grid.getMaxY();
    }

    public boolean hasNext() {
        return (currentX+1 < maxX) || (currentY+1 < maxY);
    }

    public Cell next() {
        int oldX = currentX;
        int oldY = currentY;
        if(currentY+1 < maxY){
            currentY++;
        }
        else {
            currentY = 0;
            currentX++;
        }
        return grid.get(oldX,oldY);
    }
}
