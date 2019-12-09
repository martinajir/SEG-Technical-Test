package gameOfLife.gui;
import gameOfLife.Game;
import gameOfLife.rules.RuleSet;
import gameOfLife.structures.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow {
    JFrame f;
    Grid gameGrid;
    RuleSet ruleSet;
    int r;
    int c;
    JLabel steps;
    int stepCount = 0;
    JButton next;
    JButton restart;

    public GameWindow(int r, int c){
        //initialise game grid and rules
        this.r = r;
        this.c = c;
        gameGrid = new Grid(r,c, Game.STARTER_CELLS_COUNT);
        ruleSet = new RuleSet();
        System.out.println("initial grid");
        gameGrid.printGrid();

        //initialise main frame
        f = new JFrame();
        f.setSize(500,500);
        f.setLayout(new GridLayout(r+1,c));

        //register buttons
        next = new JButton(">>");
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                play();
                refresh();
            }
        });
        restart = new JButton("Restart");
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        refresh();
    }

    public void play(){
        System.out.println("step " + stepCount);
        gameGrid = ruleSet.applyRules(gameGrid);
        gameGrid.printGrid();
        stepCount++;
    }


    /**
     * Refresh the whole game
     */
    private void refresh(){
        f.getContentPane().removeAll(); //remove all elements from frame

        for(int y = c-1; y >=0; y-- ){
            for(int x = 0; x < r; x++){
                JButton b = new JButton("");
                if(gameGrid.get(x,y).hasLife()){
                    b.setText("*");
                }
                b.setEnabled(false);
                b.setFont(new Font("Arial", Font.BOLD, 40));
                f.add(b);
            }
        }
        steps = new JLabel("Steps: " + stepCount);
        f.add(steps);
        f.add(next);
        f.add(restart);
        f.setVisible(true);//making the frame visible
    }

    public void restartGame(){
        gameGrid = new Grid(r,c, Game.STARTER_CELLS_COUNT);
        stepCount = 0;
        System.out.println("initial grid");
        gameGrid.printGrid();
        refresh();
    }
}
