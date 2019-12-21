
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameOverScreen extends JPanel implements ActionListener
{
    
    String clicked;
    MainFrame main;
    
    int finalScore;
    int finalTime;
    
    public GameOverScreen()
    {
        super();
        setBackground(Color.GREEN);
        setLayout(null);
        
        this.main=main;

        
    }
    
     @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawString("GAME OVER", 10, 670);
        g.drawString("THANK YOU FOR PLAYING!", 500, 400);
        g.drawString("Your total score: " + finalScore, 500, 420);
        g.drawString("Your time: " + finalTime, 500, 440);
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
       
    }
    
}
