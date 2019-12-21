
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Instructions extends JPanel implements ActionListener
{
    JButton infr1;
    
    String clicked;
    
    
    public Instructions()
    {
        super();
        setBackground(Color.WHITE);
        setLayout(null);
        
        infr1 = new JButton("Back");
        add(infr1);
        infr1.addActionListener(this);
        infr1.setBounds(190, 190, 75, 50);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        ImageIcon img = new ImageIcon("Image/pointing.jpg");
        g.drawImage(img.getImage(), 0, 0, this);
        g.drawString("Instructions", 10, 500);
        g.drawString("-Game timer starts once you enter the Main Map", 20, 540);
        g.drawString("-You have 5 minutes (300 seconds) to complete the entire game", 20, 560);
        g.drawString("-There are three mini games inside the Main Map", 20, 580);
        g.drawString("-The Main Score is the sum of your scores from each of the mini games", 20, 600);
        g.drawString("-Game 1 is a 'Click me' game", 20, 620);
        g.drawString("-Game 2 is a 'Rock/Paper/Scissors' game", 20, 640);
        g.drawString("-Game 3 is a 'Puzzle' game", 20, 660);
        this.requestFocusInWindow();
    }
    
    public String getClicked()
    {
        return clicked;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == infr1)
        {
            System.out.println("Returned to Intro Screen");
            clicked = "infr1";
            this.setVisible(false);
        }
    }
    
}
