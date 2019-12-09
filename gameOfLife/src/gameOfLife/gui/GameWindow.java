package gameOfLife.gui;
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

    public GameWindow(int r, int c){
        this.r = r;
        this.c = c;
        gameGrid = new Grid(r,c, 15);
        ruleSet = new RuleSet();
        System.out.println("step 0");
        gameGrid.printGrid();

        f = new JFrame();
        f.setSize(500,500);
        f.setLayout(new GridLayout(r+1,c));//using no layout managers

        next = new JButton(">>");
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                play();
                refresh();
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


    private void refresh(){
        f.getContentPane().removeAll();

        for(int y = c-1; y >=0; y-- ){
            for(int x = 0; x < r; x++){
                JButton b = new JButton("");
                if(gameGrid.get(x,y).hasLife()){
                    b.setText("*");
                }
                b.setEnabled(false);
                f.add(b);
            }
        }
        steps = new JLabel("Steps: " + stepCount);
        f.add(steps);
        f.add(next);
        f.setVisible(true);//making the frame visible
    }
}
