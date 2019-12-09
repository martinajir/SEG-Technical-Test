public class Game {

    private Grid gameGrid;
    private RuleSet ruleSet;

    public static void main(String[] args) throws  CloneNotSupportedException{
        new Game().play(5);
    }

    public void play(int numOfSteps) throws CloneNotSupportedException{
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
