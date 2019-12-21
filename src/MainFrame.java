
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.*;

public class MainFrame extends JFrame implements ComponentListener, ActionListener
{

    IntroScreen IS;
    MainMap Mm;
    MainMap Mmr1;
    Options Op;
    Instructions inf;
    Credits cf;
    Game1 g1;
    Game2 g2;
    Game3 g3;
    GameOverScreen go;
    
    int c = 0, t = 0;
    
    Timer mTim;
    int timeLimit = 300;
    boolean mRunning = false;
    
    int mainScore = 0;

    public MainFrame()
    {
        super("Final Project - Deliverable 1");
        IS = new IntroScreen();
        IS.addComponentListener(this);
        
        Mm = new MainMap(this);
        Mm.addComponentListener(this);
        Mmr1 = new MainMap(this);
        Mmr1.addComponentListener(this);
        
        Op = new Options();
        Op.addComponentListener(this);
        
        inf = new Instructions();
        inf.addComponentListener(this);
        
        cf = new Credits();
        cf.addComponentListener(this);
        
        g1 = new Game1(this);
        g1.addComponentListener(this);
        g2 = new Game2(this);
        g2.addComponentListener(this);
        g3 = new Game3(this);
        g3.addComponentListener(this);
        
        go = new GameOverScreen();
        go.addComponentListener(this);
        
        
        getContentPane().add(IS, "Center");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 847);
        setVisible(true);
    }
    
    public Timer getTimer()
    {
        return mTim;
    }
    
    public boolean getRunning()
    {
        return mRunning;
    }

    @Override
    public void componentResized(ComponentEvent ce) {
        
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
      
    }

    @Override
    public void componentShown(ComponentEvent ce) 
    {
        
    }
    
    
   @Override
    public void actionPerformed(ActionEvent ae) 
    {
        Object obj = ae.getSource();
        if(obj == mTim && mRunning)
        {
            if(timeLimit > 0)
            {
                timeLimit--;
                Mm.updateTime();
            }
        }
    }
    
    public int gettimeLimit()
    {
        return timeLimit;
    }
    
    
    public int getScore()
    {
        return mainScore;
    }
    
    public void setScore(int mainScore)
    {
        this.mainScore=mainScore;
    }
    
    @Override
    public void componentHidden(ComponentEvent ce)
    {
        if(ce.getComponent() == IS) //Inside Intro Screen
        {
            if(IS.getClicked().equals("b1"))
            {
                getContentPane().add(Mm, "Center");
                Mm.setVisible(true);
                getContentPane().remove(IS);
                mRunning = true; //When the Main Map button is pressed, the timer starts
                mTim = new Timer(1000,this);
                mTim.start();
            }
            if(IS.getClicked().equals("b2"))
            {
                getContentPane().add(Op, "Center");
                Op.setVisible(true);
                getContentPane().remove(IS);
            }
            if(IS.getClicked().equals("b3"))
            {
                getContentPane().add(inf, "Center");
                inf.setVisible(true);
                getContentPane().remove(IS);
            }
            if(IS.getClicked().equals("b4"))
            {
                getContentPane().add(cf, "Center");
                cf.setVisible(true);
                getContentPane().remove(IS);
            }
        }
        if(ce.getComponent() == Mm) //Inside Main Map
        {
            if(Mm.getClicked().equals("gb1"))
            {
                //getContentPane().remove(Mm);
                g1 = new Game1(this);
                g1.addComponentListener(this);
                getContentPane().add(g1, "Center");
                g1.setVisible(true);
            }
            if(Mm.getClicked().equals("gb2"))
            {
                //getContentPane().remove(Mm);
                g2 = new Game2(this);
                g2.addComponentListener(this);
                getContentPane().add(g2, "Center");
                g2.setVisible(true);
            }
            if(Mm.getClicked().equals("gb3"))
            {
//                getContentPane().remove(Mm);
                g3 = new Game3(this);
                g3.addComponentListener(this);
                getContentPane().add(g3, "Center");
                g3.setVisible(true);
            }
            if(Mm.getClicked().equals("Mmr1"))
            {
                getContentPane().add(IS, "Center");
                IS.setVisible(true);
                getContentPane().remove(Mm);
            }
            if(Mm.getClicked().equals("go"))
            {
                go.finalScore = mainScore;
                go.finalTime = (300 - gettimeLimit());
                getContentPane().add(go, "Center");
                go.setVisible(true);
                getContentPane().remove(Mm);
            }
        }
        if(ce.getComponent() == Op) //Inside Options
        {
            if(Op.getClicked().equals("Opr1"))
            {
               getContentPane().add(IS, "Center");
               IS.setVisible(true);
               getContentPane().remove(Mm);
            }
        }
        if(ce.getComponent() == inf) //Inside Instructions
        {
            if(inf.getClicked().equals("infr1"))
            {
               getContentPane().add(IS, "Center");
               IS.setVisible(true);
               getContentPane().remove(inf);
            }
        }
        if(ce.getComponent() == cf) //Inside Credits
        {
            if(cf.getClicked().equals("cfr1"))
            {
               getContentPane().add(IS, "Center");
               IS.setVisible(true);
               getContentPane().remove(cf);
            }
        }
        if(ce.getComponent() == g1) //Inside Game 1
        {
            if(g1.getClicked().equals("g1r1"))
            {
               Mm.updateScore();
               getContentPane().add(Mm, "Center");
               Mm.setVisible(true);
               getContentPane().remove(g1);
            }
        }
        if(ce.getComponent() == g2) //Inside Game 2
        {
            if(g2.getClicked().equals("g2r1"))
            {
               Mm.updateScore();
               getContentPane().add(Mm, "Center");
               Mm.setVisible(true);
               getContentPane().remove(g2);
            }
        }
        if(ce.getComponent() == g3) //Inside Game 3
        {
            if(g3.getClicked().equals("g3r1"))
            {
               Mm.updateScore();
               getContentPane().add(Mm, "Center");
               Mm.setVisible(true);
               getContentPane().remove(g3);
            }
        }
    }
    
}
