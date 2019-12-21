
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;



public class Game1 extends JPanel implements KeyListener, ActionListener
{

    JButton b1, g1r1;
    int score = 0;
    int limit = 0;
    int delay = 0;
    JProgressBar pbVertical;
    int i = 0, j = 800, l = 125, w = 125;
    boolean running = false;
    
    Timer tim;
    double locRan;
    
    String clicked;
    MainFrame main;


    public Game1(MainFrame main)
    {
        super();
        setBackground(Color.WHITE);
        setLayout(null);
        
        this.main=main;
        
        b1 = new JButton(new ImageIcon("Image/Bowser 2.png"));
        add(b1);
        b1.addActionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        b1.setBounds(500, 0, 125, 125);
        
        g1r1 = new JButton("Back");
        add(g1r1);
        g1r1.addActionListener(this);
        g1r1.setBounds(25, 740, 75, 50);
        
        pbVertical = new JProgressBar(JProgressBar.VERTICAL, 0, 800);// 500 the maximun number of intervals that the progress bar will show
        pbVertical.setValue(j);
        pbVertical.setBounds(1100, 0, 100, 800); //First two: set location (x-y axis), Second two: set dimensions (length/width)      
        add(pbVertical);
  
        
        
        
        //------TIMER-------------------------------------------
        delay = 1000; //milliseconds
        tim = new Timer(delay, this);
        //------TIMER-------------------------------------------
        
        tim.start(); //Starts the timer
        
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
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
        
        g.drawString("Game 1", 10, 630);
        g.drawString("Score = " + score, 10, 650);
        g.drawString("Press Spacebar to start the game", 10, 670);
        g.drawString("Click on Bowser to hit him", 10, 690);
        g.drawString("You have 60 seconds", 10, 710);
        this.requestFocusInWindow();
        
    }

    public String getClicked()
    {
        return clicked;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) 
    {
        System.out.println("Key= " + ke.getKeyCode());
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent ke) 
    {
        if(ke.getKeyCode() == ke.VK_SPACE)
        {
            setBackground(Color.YELLOW);
            running = true;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent ke)
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        Object obj = ae.getSource();
        if(obj==tim && running)
        {
            if(tim.getDelay()-10 > 0)
            {
                tim.setDelay(tim.getDelay()-10);
                b1.setBounds((int)randomLocation(), (int)randomLocation(), l - 10, w -10); //Every tick of timer, the "CLICK ME" button gets a random x and y location, while it's length and width get smaller by 10 units
            }
            else    
            {
                tim.setDelay(0);
            }
            j=j-13;
            
            if(j<0)
            {   
                j=0;
                b1.setBounds(330, 225, 375, 300);
                b1.setText("GAME OVER! You're score: " + score);    
            }
            
            pbVertical.setValue(j);
            this.repaint();
            
        }
        else if(obj == b1)
        {
            this.setFocusable(true);
            this.requestFocusInWindow();
            score = score + 1;
            main.setScore(main.getScore() + 1);
            System.out.println(score);
        }
        if(obj == g1r1)
        {
            System.out.println("Returned to Main Map");
            clicked = "g1r1";
            this.setVisible(false);
        }
        
    }
    
    double randomLocation()
    {
        double r = Math.random();
        double locRan_as_double = (r * 500.0);
        locRan = locRan_as_double;
        return locRan;
    }

    
}
