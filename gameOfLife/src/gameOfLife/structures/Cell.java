package gameOfLife.structures;

public class Cell {

    private boolean life;
    private int x;
    private int y;

    public Cell(int x, int y, boolean life){
        this.x = x;
        this.y = y;
        this.life = life;
    }

    /**
     * whether cell is inhabited or not
     */
    public boolean hasLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
