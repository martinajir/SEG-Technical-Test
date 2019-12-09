package structures;

import java.util.Iterator;
import java.util.Random;

public class Grid implements Iterable {
    private Cell[][] cells;
    private int maxX;
    private int maxY;

    private Random rand = new Random();

    public Iterator iterator() {
        return new GridIterator(this);
    }

    public Grid(int maxX, int maxY){
        this.maxX = maxX;
        this.maxY = maxY;
        cells = new Cell[maxX][maxY];
        initialiseGrid(maxX,maxY);
    }

    public Grid(int maxX, int maxY, int starterCellsCount){
        this.maxX = maxX;
        this.maxY = maxY;
        cells = new Cell[maxX][maxY];
        initialiseGrid(maxX,maxY);
        addRandomCells(starterCellsCount);
    }

    private void initialiseGrid(int maxX, int maxY){
        for(int x = 0; x < maxX; x++){
            for(int y = 0; y < maxY; y++){
                cells[x][y] = new Cell(x,y,false);
            }
        }
    }

    /**
     * initialise the grid with some random live cells
     * @param count is the number of live cells desired in a grid
     */
    private void addRandomCells(int count){
        for(int i = 0; i < count; i++) {
            int randX = rand.nextInt(maxX);
            int randY = rand.nextInt(maxY);
            cells[randX][randY].setLife(true);
        }
    }

    /**
     * Return the number of live cells neighbouring a given cell
     * @param x x coordinate of given cell
     * @param y y coordinate of given cell
     * @return number of alive neighbours
     */
    public int getNeighbourCount(int x, int y){
        int[] xModifiers = {0,1,1,1,0,-1,-1,-1}; //clockwise starting from 12
        int[] yModifiers = {1,1,0,-1,-1,-1,0,1};
        int neighbourCount = 0;

        for(int j = 0; j < xModifiers.length; j++){
            int newX = x + xModifiers[j];
            int newY = y + yModifiers[j];
            if(isValid(newX,newY)) {
                Cell thisCell = cells[newX][newY];
                if (thisCell.hasLife()) {
                    neighbourCount++;
                }
            }
        }
        return neighbourCount;
    }

    /**
     * Evaluate if given coordinates are valid
     */
    private boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x < maxX && y < maxY;
    }

    /**
     * Print grid with 0,0 coordinate in bottom left corner
     */
    public void printGrid(){
        for(int y = maxY-1; y >=0; y-- ){
            for(int x = 0; x < maxX; x++){
                    if(cells[x][y].hasLife()){
                        System.out.print(" * ");
                    }
                    else{
                        System.out.print(" - ");
                    }
            }
            System.out.println();
        }
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public Cell get(int x, int y){
        return cells[x][y];
    }

}
