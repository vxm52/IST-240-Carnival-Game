
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Game2 extends JPanel implements ActionListener 
{
    JButton g2r1, Paper, Rock, Scissors, YourPick, Enemy, EnemyPick, Result;
    int pick = 0;
    int ePick = 0;
    
    int score = 0;
    
    String clicked;
    MainFrame main;

    //-----------------------------------ROCK PAPER SCISSORS-----------------------------------------------------------------------------------
    
    
    public Game2(MainFrame main)
    {
        super();
        setBackground(Color.CYAN);
        setLayout(null);
        
        g2r1 = new JButton("Back");
        add(g2r1);
        g2r1.addActionListener(this);
        g2r1.setBounds(100, 700, 75, 50);
        
        Enemy = new JButton(new ImageIcon("Image/Bowser 2.png"));
        add(Enemy);
        Enemy.addActionListener(this);
        Enemy.setBounds(500, 25, 150, 150);
        
        EnemyPick = new JButton(" ");
        add(EnemyPick);
        EnemyPick.addActionListener(this);
        EnemyPick.setBounds(525, 275, 100, 100);
        
        Rock = new JButton("ROCK");
        add(Rock);
        Rock.addActionListener(this);
        Rock.setBounds(375, 600, 100, 100);
        
        Paper = new JButton("PAPER");
        add(Paper);
        Paper.addActionListener(this);
        Paper.setBounds(525, 600, 100, 100);
       
        Scissors = new JButton("SCISSORS");
        add(Scissors);
        Scissors.addActionListener(this);
        Scissors.setBounds(675, 600, 100, 100);
        
        YourPick = new JButton(" ");
        add(YourPick);
        YourPick.addActionListener(this);
        YourPick.setBounds(525, 415, 100, 100);
        
        Result = new JButton(" ");
        add(Result);
        Result.addActionListener(this);
        Result.setBounds(925, 275, 250, 250);
        
        this.main=main;
  
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawString("Game 2", 10, 530);
        g.drawString("Score = " + score, 10, 550);
        g.drawString("Make your pick", 10, 590);
        g.drawString("Win = +5 Points", 10, 610);
        g.drawString("Draw = 0 Points", 10, 630);
        g.drawString("Loss = -5 Points", 10, 650);
        
        g.drawString("▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲", 0, 400); //Just to display the mid-line between enemy and player in case a theme has not been selected
        this.requestFocusInWindow();
        
         //Conditions for different themes
        if(main.Op.t == 1) 
        {
            ImageIcon img = new ImageIcon("Image/Mushroom Kingdom.png"); 
            g.drawImage(img.getImage(), 0, 0, this);
        }
        if(main.Op.t == 2)
        {
            ImageIcon img = new ImageIcon("Image/shore.gif"); 
            g.drawImage(img.getImage(), 0, 0, this);
        }
        if(main.Op.t == 3)
        {
            ImageIcon img = new ImageIcon("Image/firewatch_2.jpg"); 
            g.drawImage(img.getImage(), 0, 0, this);
        }
        
    }
    
    
    public String getClicked()
    {
        return clicked;
    }
    
    public void finishGame()
    {
        ePick = (int)(Math.random()*3+1);
        if(ePick == 1)
        {
            ImageIcon img = new ImageIcon("Image/The Rock.jpg"); 
            ImageIcon resized = new ImageIcon(((img).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            EnemyPick.setIcon(resized);
        }
        if(ePick == 2)
        {
            ImageIcon img = new ImageIcon("Image/Paper.jpg"); 
            ImageIcon resized = new ImageIcon(((img).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            EnemyPick.setIcon(resized);
        }
        if(ePick == 3)
        {
            ImageIcon img = new ImageIcon("Image/Scissors.jpg"); 
            ImageIcon resized = new ImageIcon(((img).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            EnemyPick.setIcon(resized);
        }
        
        if(pick == 1 && ePick == 1)
        {
            System.out.println("It's a draw!");
            Result.setBackground(Color.YELLOW);
            Result.setText("It's a draw");
        }
        
        if(pick == 1 && ePick == 2)
        {
            System.out.println("You lose");
            Result.setBackground(Color.RED);
            Result.setText("You lose!  Score: " + (score - 5));
            score = score - 5;
            main.setScore(main.getScore() - 5);
            repaint();
        }
        if(pick == 1 && ePick == 3)
        {
            System.out.println("You win");
            Result.setBackground(Color.GREEN);
            Result.setText("You win!  Score: " + (score + 5));
            score = score + 5;
            main.setScore(main.getScore() + 5);
            repaint();
        }
        if(pick == 2 && ePick == 1)
        {
            System.out.println("You win");
            Result.setBackground(Color.GREEN);
            Result.setText("You win!  Score: " + (score + 5));
            score = score + 5;
            main.setScore(main.getScore() + 5);
            repaint();
        }
        if(pick == 2 && ePick == 2)
        {
            System.out.println("It's a draw");
            Result.setBackground(Color.YELLOW);
            Result.setText("It's a draw!");
        }
        if(pick == 2 && ePick == 3)
        {
            System.out.println("You lose");
            Result.setBackground(Color.RED);
            Result.setText("You lose!  Score: " + (score - 5));
            score = score - 5;
            main.setScore(main.getScore() - 5);
            repaint();
        }
        if(pick == 3 && ePick == 1)
        {
            System.out.println("You lose");
            Result.setBackground(Color.RED);
            Result.setText("You lose!  Score: " + (score - 5));
            score = score - 5;
            main.setScore(main.getScore() - 5);
            repaint();     
        }
        if(pick == 3 && ePick == 2)
        {
            System.out.println("You win");
            Result.setBackground(Color.GREEN);
            Result.setText("You win!  Score: " + (score + 5));
            score = score + 5;
            main.setScore(main.getScore() + 5);
            repaint();
        }
        if(pick == 3 && ePick == 3)
        {
            System.out.println("It's a draw");
            Result.setBackground(Color.YELLOW);
            Result.setText("It's a draw");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == g2r1)
        {
            System.out.println("Returned to Main Map");
            clicked = "g2r1";
            this.setVisible(false);
        }
        if(ae.getSource() == Rock)
        {
            System.out.println("Rock chosen");
            ImageIcon img = new ImageIcon("Image/The Rock.jpg"); 
            ImageIcon resized = new ImageIcon(((img).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            YourPick.setIcon(resized);
            pick = 1;
            finishGame();
        }
        if(ae.getSource() == Paper)
        {
            System.out.println("Paper chosen");
            ImageIcon img = new ImageIcon("Image/Paper.jpg"); 
            ImageIcon resized = new ImageIcon(((img).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            YourPick.setIcon(resized);
            pick = 2;
            finishGame();
            
        }
        if(ae.getSource() == Scissors)
        {
            System.out.println("Scissors chosen");
            ImageIcon img = new ImageIcon("Image/Scissors.jpg"); 
            ImageIcon resized = new ImageIcon(((img).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            YourPick.setIcon(resized);
            pick = 3;
            finishGame();
        }
    }
    
    

    
}
