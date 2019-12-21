
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Credits extends JPanel implements ActionListener
{
    JButton cfr1;
    
    String clicked;
    
    public Credits()
    {
        super();
        setBackground(Color.GREEN);
        setLayout(null);
        
        cfr1 = new JButton("Back");
        add(cfr1);
        cfr1.addActionListener(this);
        cfr1.setBounds(200, 700, 75, 50);
        
    }
    
     @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawString("Credits/About", 10, 670);
        g.drawString("THANK YOU FOR PLAYING!", 500, 400);
        g.drawString("Created by- Vaibhav Sen Malla", 495, 500);
        this.requestFocusInWindow();
    }
    
    public String getClicked()
    {
        return clicked;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == cfr1)
        {
            System.out.println("Returned to Intro Screen");
            clicked = "cfr1";
            this.setVisible(false);
        }
    }
    
}
