
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;


public class Game3 extends JPanel implements ActionListener 
{
    JButton g3r1, original, jumble, piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9, blankPiece;
    
    String clicked;
    MainFrame main;
    
    int a = 0;
    int limit = 0;
    int delay = 0;
    JProgressBar pbVertical;
    int i = 0, j = 800, l = 125, w = 125;
    boolean running = false;
    
    Timer tim;
    
    Icon i1 = new ImageIcon("Image/Mushroom 1.jpg");
        Icon i2 = new ImageIcon("Image/Mushroom 4.jpg");
        Icon i3 = new ImageIcon("Image/Mushroom 7.jpg");
        Icon i4 = new ImageIcon("Image/Mushroom 5.jpg");
        Icon i5 = new ImageIcon("Image/Mushroom 3.jpg");
        Icon i6 = new ImageIcon("Image/Mushroom 8.jpg");
        Icon i7 = new ImageIcon("Image/Mushroom 6.jpg");
        Icon i8 = new ImageIcon("Image/Mushroom 2.jpg");
        Icon i9 = new ImageIcon("Image/Mushroom 9.jpg");
        Icon i0 = new ImageIcon("Image/Blank.jpg"); //In case "icon blank" doesn't work.
        Icon blank;

    
    //-----------------------------------QUIZ GAME-----------------------------------------------------------------------------------
    
    public Game3(MainFrame main)
    {
        super();
        setBackground(Color.GREEN);
        setLayout(null);
        
        g3r1 = new JButton("Back");
        add(g3r1);
        g3r1.addActionListener(this);
        g3r1.setBounds(200, 700, 75, 50);
        
        original = new JButton(new ImageIcon("Image/Mushroom.jpg"));
        add(original);
        original.addActionListener(this);
        original.setBounds(950, 100, 125, 125);
        
        //The icons will contain the fractured images
    
        blankPiece = new JButton(i0);
        blankPiece.setBounds(500, 700, 75, 75);
        
        //The buttons will not move. The icons will be set to them to give the illusion that you are moving the pieces
        piece1 = new JButton(i1);
        add(piece1);
        piece1.addActionListener(this);
        piece1.setBounds(400, 200, 100, 100);
        piece2 = new JButton(i2);
        add(piece2);
        piece2.addActionListener(this);
        piece2.setBounds(500, 200, 100, 100);
        piece3 = new JButton(i3);
        add(piece3);
        piece3.addActionListener(this);
        piece3.setBounds(600, 200, 100, 100);
        piece4 = new JButton(i4);
        add(piece4);
        piece4.addActionListener(this);
        piece4.setBounds(400, 300, 100, 100);
        piece5 = new JButton(i5);
        add(piece5);
        piece5.addActionListener(this);
        piece5.setBounds(500, 300, 100, 100);
        piece6 = new JButton(i6);
        add(piece6);
        piece6.addActionListener(this);
        piece6.setBounds(600, 300, 100, 100);
        piece7 = new JButton(i7);
        add(piece7);
        piece7.addActionListener(this);
        piece7.setBounds(400, 400, 100, 100);
        piece8 = new JButton(i8);
        add(piece8);
        piece8.addActionListener(this);
        piece8.setBounds(500, 400, 100, 100);
        piece9 = new JButton();
        add(piece9);
        piece9.addActionListener(this);
        piece9.setBounds(600, 400, 100, 100);
        
        
        jumble = new JButton("Jumble");
        add(jumble);
        jumble.addActionListener(this);
        jumble.setBounds(500, 600, 100, 75);
     
        pbVertical = new JProgressBar(JProgressBar.VERTICAL, 0, 800);// 500 the maximun number of intervals that the progress bar will show
        pbVertical.setValue(j);
        pbVertical.setBounds(1100, 0, 100, 800); //First two: set location (x-y axis), Second two: set dimensions (length/width)      
        add(pbVertical);
        
        //------TIMER-------------------------------------------
        delay = 1000; //milliseconds
        tim = new Timer(delay, this);
        //------TIMER-------------------------------------------
        
        tim.start(); //Starts the timer
        
        
        this.main=main;   
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
        
        
        g.drawString("Game 3", 10, 470);
        g.drawString("Puzzle Game", 10, 490);
        g.drawString("Click on a piece to move it to the blank slot", 10, 510);
        g.drawString("Arrange the pieces to form the original image", 10, 530);
        g.drawString("Click the 'Jumble' button to start the timer", 10, 550);
        g.drawString("You have 1 minute to complete the puzzle", 10, 570);
        g.drawString("Original Image:", 970, 90);
        this.requestFocusInWindow();
    }
    
     public String getClicked()
    {
        return clicked;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        Object obj = ae.getSource();
        if(obj == g3r1)
        {
            System.out.println("Returned to Main Map");
            clicked = "g3r1";
            this.setVisible(false);
        }
        if(obj == jumble) //This button will jumble the pieces and will start the timer.
        {
            System.out.println("Puzzle jumbled");
            running = true;
            repaint();
            piece1.setIcon(new ImageIcon("Image/Mushroom 1.jpg"));
            piece2.setIcon(new ImageIcon("Image/Mushroom 4.jpg"));
            piece3.setIcon(new ImageIcon("Image/Mushroom 7.jpg"));
            piece4.setIcon(new ImageIcon("Image/Mushroom 5.jpg"));
            piece5.setIcon(new ImageIcon("Image/Mushroom 3.jpg"));
            piece6.setIcon(new ImageIcon("Image/Mushroom 8.jpg"));
            piece7.setIcon(new ImageIcon("Image/Mushroom 6.jpg"));
            piece8.setIcon(new ImageIcon("Image/Mushroom 2.jpg"));
            Icon i0 = null;
            piece9.setIcon(i0);
            
        }
        if(obj == tim && running)
        {
            if(tim.getDelay()-10 > 0)
            {
                tim.setDelay(tim.getDelay()-10);
            }
            else    
            {
                tim.setDelay(0);
            }
            j=j-13;
            
            if(j<0)
            {   
                j=0;
                jumble.setBounds(500, 600, 200, 75);
                jumble.setText("Time's up! Jumble again?");    
            }
            
            pbVertical.setValue(j);
            this.repaint();
        }
        Icon blank = null; //One piece needs to be blank so you can move the pieces
        if(obj == piece1) //When the piece is clicked, it will do the following check and move the pieces (sets the icon/image of the piece to the one next to it)
        {
            Icon swapThis = piece1.getIcon();
            if(piece2.getIcon() == blank) //When piece 1 is clicked, the surrounding pieces (piece 2 and piece 4 will be checked to see if they are blank pieces. 
            {
                piece2.setIcon(swapThis); //If piece 2 is indeed blank, the icon that was in piece 1 will be set to piece 2
                piece1.setIcon(blank); //Now piece 1 will become the blank slot
            }
            else if(piece4.getIcon() == blank) //The above check is repeated for piece 4 and the other following pieces.
            {
                piece4.setIcon(swapThis);
                piece1.setIcon(blank);
            }
        }
        if(obj == piece2)
        {
            Icon a1 = piece2.getIcon();
            if(piece1.getIcon() == blank)
            {
                piece1.setIcon(a1);
                piece2.setIcon(blank);
            }
            else if(piece5.getIcon() == blank)
            {
                piece5.setIcon(a1);
                piece2.setIcon(blank);
            }
            else if(piece3.getIcon() == blank)
            {
                piece3.setIcon(a1);
                piece2.setIcon(blank);
            }
        }
        if(obj == piece3)
        {
            Icon a1 = piece3.getIcon();
            if(piece2.getIcon() == blank)
            {
                piece2.setIcon(a1);
                piece3.setIcon(blank);
            }
            else if(piece6.getIcon() == blank)
            {
                piece6.setIcon(a1);
                piece3.setIcon(blank);
            }
        }
        if(obj == piece4)
        {
            Icon a1 = piece4.getIcon();
            if(piece1.getIcon() == blank)
            {
                piece1.setIcon(a1);
                piece4.setIcon(blank);
            }
            else if(piece5.getIcon() == blank)
            {
                piece5.setIcon(a1);
                piece4.setIcon(blank);
            }
            else if(piece7.getIcon() == blank)
            {
                piece7.setIcon(a1);
                piece4.setIcon(blank);
            }
        }
        if(obj == piece5) //piece5 is in the center so it has more surrounding buttons to check for blank spots
        {
            Icon a1 = piece5.getIcon();
            if(piece2.getIcon() == blank)
            {
                piece2.setIcon(a1);
                piece5.setIcon(blank);
            }
            else if(piece4.getIcon() == blank)
            {
                piece4.setIcon(a1);
                piece5.setIcon(blank);
            }
            else if(piece6.getIcon() == blank)
            {
                piece6.setIcon(a1);
                piece5.setIcon(blank);
            }
            else if(piece8.getIcon() == blank)
            {
                piece8.setIcon(a1);
                piece5.setIcon(blank);
            }
        }
        if(obj == piece6)
        {
            Icon a1 = piece6.getIcon();
            if(piece3.getIcon() == blank)
            {
                piece3.setIcon(a1);
                piece6.setIcon(blank);
            }
            else if(piece5.getIcon() == blank)
            {
                piece5.setIcon(a1);
                piece6.setIcon(blank);
            }
            else if(piece9.getIcon() == blank)
            {
                piece9.setIcon(a1);
                piece6.setIcon(blank);
            }
        }
        if(obj == piece7)
        {
            Icon a1 = piece7.getIcon();
            if(piece4.getIcon() == blank)
            {
                piece4.setIcon(a1);
                piece7.setIcon(blank);
            }
            else if(piece8.getIcon() == blank)
            {
                piece8.setIcon(a1);
                piece7.setIcon(blank);
            }
        }
        if(obj == piece8)
        {
            Icon a1 = piece8.getIcon();
            if(piece7.getIcon() == blank)
            {
                piece7.setIcon(a1);
                piece8.setIcon(blank);
            }
            else if(piece5.getIcon() == blank)
            {
                piece5.setIcon(a1);
                piece8.setIcon(blank);
            }
            else if(piece9.getIcon() == blank)
            {
                piece9.setIcon(a1);
                piece8.setIcon(blank);
            }
        }
        if(obj == piece9)
        {
            Icon a1 = piece9.getIcon();
            if(piece8.getIcon() == blank)
            {
                piece8.setIcon(a1);
                piece9.setIcon(blank);
            }
            else if(piece6.getIcon() == blank)
            {
                piece6.setIcon(a1);
                piece9.setIcon(blank);
            }
        }
    }
}
