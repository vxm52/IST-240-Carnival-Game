
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;


public class IntroScreen extends JPanel implements ActionListener 
{
    JButton b1, b2, b3, b4;
    MainMap Mm;
    Options Op;
    Instructions ins;
    Credits cd;
    
    String clicked;
    public IntroScreen()
    {
        super();
        setBackground(Color.CYAN);
        setLayout(null);
       
        
        b1 = new JButton("Main Map");
        add(b1);
        b1.addActionListener(this);
        b1.setBounds(510, 400, 125, 75);
        
        b2 = new JButton("Options");
        add(b2);
        b2.addActionListener(this);
        b2.setBounds(510, 500, 125, 75);
        
        b3 = new JButton("Instructions");
        add(b3);
        b3.addActionListener(this);
        b3.setBounds(510, 600, 125, 75);
        
        b4 = new JButton("Credits/About");
        add(b4);
        b4.addActionListener(this);
        b4.setBounds(510, 700, 125, 75);
        
    }
    
    public String getClicked()
    {
        return clicked;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawString("Intro Screen", 10, 670);
        this.requestFocusInWindow();
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1) //Main Map button is pressed
        {
            System.out.println("Main Map button pressed");
            clicked = "b1";
            this.setVisible(false);
        }
        if(ae.getSource() == b2) //Options button is pressed
        {
            System.out.println("Options button pressed");
            clicked = "b2";
            this.setVisible(false);
        }
        if(ae.getSource() == b3) //Instructions button is pressed
        {
            System.out.println("Instructions button pressed");
            clicked = "b3";
            this.setVisible(false);
        }
        if(ae.getSource() == b4) //Credits button is pressed
        {
            System.out.println("Credits button pressed");
            clicked = "b4";
            this.setVisible(false);
        }
    }
    
}
