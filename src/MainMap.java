
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MainMap extends JPanel implements KeyListener, ActionListener
{
    Timer tm = new Timer(5, this);
    int x = 0, y = 0, velX = 0, velY = 0, finalTime;
    
    JButton gb1, gb2, gb3, Mmr1, go, Character;
    Game1 g1;
    Game2 g2;
    Game3 g3;
    
    String clicked;
    
    MainFrame main;
    int mDelay;
    JLabel t1, s1;
    
    ImageIcon Images;
    
    public MainMap(MainFrame main)
    {
        super();
        setBackground(Color.GREEN);
        setLayout(null);
        
        this.main=main;
        
        t1 = new JLabel("Time Elapsed: " + (300-main.gettimeLimit()));
        t1.setBackground(Color.WHITE);
        t1.setOpaque(true);
        add(t1);
        t1.setBounds(50, 50, 175, 50);
        
        s1 = new JLabel("Total Score: " + main.getScore());
        s1.setBackground(Color.WHITE);
        s1.setOpaque(true);
        add(s1);
        s1.setBounds(1000, 50, 150, 50);
        
        
        gb1 = new JButton("Game 1");
        add(gb1);
        gb1.addActionListener(this);
        gb1.setBounds(100, 200, 125, 75);
        
        gb2 = new JButton("Game 2");
        add(gb2);
        gb2.addActionListener(this);
        gb2.setBounds(530, 650, 125, 75);
        
        gb3 = new JButton("Game 3");
        add(gb3);
        gb3.addActionListener(this);
        gb3.setBounds(950, 250, 125, 75);
        
        Mmr1 = new JButton("Back");
        add(Mmr1);
        Mmr1.addActionListener(this);
        Mmr1.setBounds(50, 700, 75, 50);
        
        go = new JButton("Game Over");
        add(go);
        go.addActionListener(this);
        go.setBounds(1050, 700, 100, 50);
        
        Character = new JButton(" ");
        add(Character);
        Character.setBounds(x, y, 100, 150);
     //   Character.addKeyListener(this);
        Character.setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawString("Main Map", 10, 670);
        this.requestFocusInWindow();
   
        
        //Conditions for different characters
        if(main.Op.c == 1) 
        {
            ImageIcon img = new ImageIcon("Image/Mario.png"); 
            ImageIcon resized = new ImageIcon(((img).getImage().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH)));
            Character.setIcon(resized);
        }
        if(main.Op.c == 2)
        {
            ImageIcon img = new ImageIcon("Image/Luigi.png"); 
            ImageIcon resized = new ImageIcon(((img).getImage().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH)));
            Character.setIcon(resized);
        }
        if(main.Op.c == 3)
        {
            ImageIcon img = new ImageIcon("Image/Yoshi.png"); 
            ImageIcon resized = new ImageIcon(((img).getImage().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH)));
            Character.setIcon(resized);
        }
        
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
    
    
    
    
    @Override
    public void keyTyped(KeyEvent ke) 
    {
        System.out.println("Key= " + ke.getKeyCode());
        repaint();
    } 

    @Override
    public void keyPressed(KeyEvent ke) 
    {
        if(ke.getKeyCode() == ke.VK_LEFT)
        {
            System.out.println("Moved ←");
            velX = -3;
            velY = 0;
        }
        if(ke.getKeyCode() == ke.VK_RIGHT)
        {
            System.out.println("Moved →");
            velX = 3;
            velY = 0;
        }
        if(ke.getKeyCode() == ke.VK_UP)
        {
            System.out.println("Moved ↑");
            velX = 0;
            velY = -3;
        }
        if(ke.getKeyCode() == ke.VK_DOWN)
        {
            System.out.println("Moved ↓");
            velX = 0;
            velY = 3;
        }
        Character.setBounds(new Rectangle(x, y, 100, 150));
        Rectangle rect1 = Character.getBounds();
        Rectangle rect2 = gb1.getBounds();
        Rectangle rect3 = gb2.getBounds();
        Rectangle rect4 = gb3.getBounds();
        Rectangle rect5 = go.getBounds();
        
        if(rect1.intersects(rect2))
        {
            gb1.doClick();
        }
        if(rect1.intersects(rect3))
        {
            gb2.doClick();
        }
        if(rect1.intersects(rect4))
        {
            gb3.doClick();
        }
        if(rect1.intersects(rect5)) //This works, but the processing time takes very long so the Game Over screen does not load up.
        {
            go.doClick();
        }
        validate();
        repaint();
        
    }
    
    @Override
    public void keyReleased(KeyEvent ke) //When the key is released, the character will halt
    {
        velX = 0;
        velY = 0;
    }
    
    
    
    
    public String getClicked()
    {
        return clicked;
    }
    
    public void updateTime()
    {
        t1.setText("Time Elapsed: " + (300-main.gettimeLimit()) + " secs");
    }
    
    public void updateScore()
    {
        s1.setText("Total Score: " + main.getScore());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == gb1) //Action when the following buttons are clicked
        {
            System.out.println("Game 1 was entered");
            clicked = "gb1";
            this.setVisible(false);
        }
        if(ae.getSource() == gb2)
        {
            System.out.println("Game 2 was entered");
            clicked = "gb2";
            this.setVisible(false);
        }
        if(ae.getSource() == gb3)
        {
            System.out.println("Game 3 was entered");
            clicked = "gb3";
            this.setVisible(false);
        }
        if(ae.getSource() == Mmr1)
        {
            System.out.println("Return to Intro Screen");
            clicked = "Mmr1";
            this.setVisible(false);
        }
        if(ae.getSource() == go)
        {
            System.out.println("Game ended");
            clicked = "go";
            this.setVisible(false);
            tm.stop();
        }
  
        
        if(x < 0) //If the character is on the outer left side of the screen, it will be relocated back to left edge of the screen
        {
            velX = 0;
            x = 0;
        }
        if(x > 1110)
        {
            velX = 0;
            x = 1110;
        }
        if(y < 0)
        {
            velY = 0;
            y = 0;
        }
        if(y > 729)
        {
            velY = 0;
            y = 729;
        }
        
        if(x < 200 && x > 400)
        {
            clicked = "gb1";
            this.setVisible(false);
        }
        
        x = x + velX;
        y = y + velY;
        Character.setBounds(x, y, 100, 125);
    }

}
