import java.util.List;

public class Cell {

    private boolean life;

    public Cell(boolean life){
        this.life = life;
    }

    public boolean hasLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }
}
