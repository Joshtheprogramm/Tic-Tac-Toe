package Tic_Tac_Toe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tic_Tac_Toe implements ActionListener{
        //Global variables are called
	Random rand = new Random();
	JFrame frame = new JFrame();
	JPanel p = new JPanel();
	JPanel b2 = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] b = new JButton[9];
	boolean p1;
	Tic_Tac_Toe(){
            //Frame settings are called
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800,800);
            frame.getContentPane().setBackground(new Color(50,50,50));
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);
            textfield.setHorizontalAlignment(JLabel.CENTER);
            textfield.setText("Tic-Tac-Toe");
            textfield.setOpaque(true);
            p.setLayout(new BorderLayout());
            p.setBounds(0,0,800,100);
            b2.setLayout(new GridLayout(3,3));
            b2.setBackground(new Color(150,150,150));
            //Buttons are created
            for(int i=0;i<9;i++) {
                b[i] = new JButton();
                b2.add(b[i]);
                b[i].setFont(new Font("MV Boli",Font.BOLD,120));
                b[i].setFocusable(false);
                b[i].addActionListener(this);
            }
            //Panel is added to frame
            p.add(textfield);
            frame.add(p,BorderLayout.NORTH);
            frame.add(b2);

            firstTurn();
    }
        //Method used to mark the board
    @Override
    public void actionPerformed(ActionEvent e) {
            //
            for(int i=0;i<9;i++) {
                if(e.getSource()==b[i]) {
                    if(p1) {
                        if(b[i].getText()=="") {
                            b[i].setForeground(new Color(255,0,0));
                            b[i].setText("X");
                            p1=false;
                            textfield.setText("O turn");
                            check();
                            }
                    }
                        else {
                            if(b[i].getText()=="") {
                                b[i].setForeground(new Color(0,0,255));
                                b[i].setText("O");
                                p1=true;
                                textfield.setText("X turn");
                                check();
                                }
                            }
                    }			
            }
    }
        //Method determines which player goes 
        //first using Random class
        
    public void firstTurn() {
            if(rand.nextInt(2)==0) {
                   p1=true;
                    textfield.setText("X turn");
            }
            else {
                    p1=false;
                    textfield.setText("O turn");
            }
    }

    public void check() {
            //check X win conditions
            if(
                            (b[0].getText()=="X") &&
                            (b[1].getText()=="X") &&
                            (b[2].getText()=="X")
                            ) {
                    xWins(0,1,2);
            }
            if(
                            (b[3].getText()=="X") &&
                            (b[4].getText()=="X") &&
                            (b[5].getText()=="X")
                            ) {
                    xWins(3,4,5);
            }
            if(
                            (b[6].getText()=="X") &&
                            (b[7].getText()=="X") &&
                            (b[8].getText()=="X")
                            ) {
                    xWins(6,7,8);
            }
            if(
                            (b[0].getText()=="X") &&
                            (b[3].getText()=="X") &&
                            (b[6].getText()=="X")
                            ) {
                    xWins(0,3,6);
            }
            if(
                            (b[1].getText()=="X") &&
                            (b[4].getText()=="X") &&
                            (b[7].getText()=="X")
                            ) {
                    xWins(1,4,7);
            }
            if(
                           
                    (b[2].getText()=="X") &&
                            (b[5].getText()=="X") &&
                            (b[8].getText()=="X")
                            ) 
                    {
                    xWins(2,5,8);
            }
            if(
                            (b[0].getText()=="X") &&
                            (b[4].getText()=="X") &&
                            (b[8].getText()=="X")
                            ) {
                    xWins(0,4,8);
            }
            if(
                            (b[2].getText()=="X") &&
                            (b[4].getText()=="X") &&
                            (b[6].getText()=="X")
                            ) {
                    xWins(2,4,6);
            }
            //check O win conditions
            if(
                            (b[0].getText()=="O") &&
                            (b[1].getText()=="O") &&
                            (b[2].getText()=="O")
                            ) {
                    oWins(0,1,2);
            }
            if(
                            (b[3].getText()=="O") &&
                            (b[4].getText()=="O") &&
                            (b[5].getText()=="O")
                            ) {
                    oWins(3,4,5);
            }
            if(
                            (b[6].getText()=="O") &&
                            (b[7].getText()=="O") &&
                            (b[8].getText()=="O")
                            ) {
                    oWins(6,7,8);
            }
            if(
                            (b[0].getText()=="O") &&
                            (b[3].getText()=="O") &&
                            (b[6].getText()=="O")
                            ) {
                    oWins(0,3,6);
            }
            if(
                            (b[1].getText()=="O") &&
                            (b[4].getText()=="O") &&
                            (b[7].getText()=="O")
                            ) {
                    oWins(1,4,7);
            }
            if(
                            (b[2].getText()=="O") &&
                            (b[5].getText()=="O") &&
                            (b[8].getText()=="O")
                            ) {
                    oWins(2,5,8);
            }
            if(
                            (b[0].getText()=="O") &&
                            (b[4].getText()=="O") &&
                            (b[8].getText()=="O")
                            ) {
                    oWins(0,4,8);
            }
            if(
                            (b[2].getText()=="O") &&
                            (b[4].getText()=="O") &&
                            (b[6].getText()=="O")
                            ) {
                    oWins(2,4,6);
            }
    }
        //When X wins the background changes to Green
        //X is set to win 
    public void xWins(int x,int y,int z) {
            b[x].setBackground(Color.GREEN);
            b[y].setBackground(Color.GREEN);
            b[z].setBackground(Color.GREEN);

            for(int i=0;i<9;i++) {
                    b[i].setEnabled(false);
            }
            textfield.setText("X wins");
    }
        //When O wins the background changes to Blue
        //O is set to win 
    public void oWins(int x,int y,int z) {
            b[x].setBackground(Color.BLUE);
            b[y].setBackground(Color.BLUE);
            b[z].setBackground(Color.BLUE);

            for(int i=0;i<9;i++) {
                b[i].setEnabled(false);
            }
            textfield.setText("O wins");
    }
}

    

