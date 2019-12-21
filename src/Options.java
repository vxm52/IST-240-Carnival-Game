
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Options extends JPanel implements ActionListener
{
    JButton Opr1, ch1, ch2, ch3, th1, th2, th3;
    
    String clicked;
    
    JLabel ch, th;
    
    int c=0, t=0;
    
    public Options()
    {
        super();
        setBackground(Color.GREEN);
        setLayout(null);
        
        Opr1 = new JButton("Back");
        add(Opr1);
        Opr1.addActionListener(this);
        Opr1.setBounds(200, 700, 75, 50);
        
        ch = new JLabel("Character Select");
        ch.setBackground(Color.WHITE);
        ch.setOpaque(true);
        add(ch);
        ch.setBounds(525, 100, 150, 50);
        
        ch1 = new JButton(new ImageIcon("Image/Mario select.png"));
        add(ch1);
        ch1.addActionListener(this);
        ch1.setBounds(250, 175, 200, 150);
        
        ch2 = new JButton(new ImageIcon("Image/Luigi select.png"));
        add(ch2);
        ch2.addActionListener(this);
        ch2.setBounds(500, 175, 200, 150);
        
        ch3 = new JButton(new ImageIcon("Image/Yoshi select.png"));
        add(ch3);
        ch3.addActionListener(this);
        ch3.setBounds(750, 175, 200, 150);
        
        th = new JLabel("Theme Select");
        th.setBackground(Color.WHITE);
        th.setOpaque(true);
        add(th);
        th.setBounds(525, 425, 150, 50);
        
        th1 = new JButton("Theme 1");
        add(th1);
        th1.addActionListener(this);
        th1.setBounds(350, 500, 150, 100);
        
        th2 = new JButton("Theme 2");
        add(th2);
        th2.addActionListener(this);
        th2.setBounds(525, 500, 150, 100);
        
        th3 = new JButton("Theme 3");
        add(th3);
        th3.addActionListener(this);
        th3.setBounds(700, 500, 150, 100);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawString("Options", 10, 670);
        this.requestFocusInWindow();
    }
    
    public String getClicked()
    {
        return clicked;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == Opr1)
        {
            System.out.println("Returned to Intro Screen");
            clicked = "Opr1";
            this.setVisible(false);
        }
        if(ae.getSource() == ch1) //Character 1 selected
        {
            System.out.println("Character 1 selected");
            c = 1;
            
        }
        if(ae.getSource() == ch2) //Character 2 selected
        {
            System.out.println("Character 2 selected");
            c = 2;
            
        }
        if(ae.getSource() == ch3) //Character 3 selected
        {
            System.out.println("Character 3 selected");
            c = 3;
            
        }
        if(ae.getSource() == th1) //Theme 1 selected
        {
            System.out.println("Theme 1 selected");
            t = 1;
            repaint();
        }
        if(ae.getSource() == th2) //Theme 2 selected
        {
            System.out.println("Theme 2 selected");
            t = 2;
            repaint();
        }
        if(ae.getSource() == th3) //Theme 3 selected
        {
            System.out.println("Theme 3 selected");
            t = 3;
            repaint();
        }
    }
    
}
