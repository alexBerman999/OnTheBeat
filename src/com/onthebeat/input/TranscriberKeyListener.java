package com.onthebeat.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import com.onthebeat.Playback;
import com.onthebeat.Score;
import com.onthebeat.gui.MeasurePanel;


public class TranscriberKeyListener extends KeyAdapter
{
    long lastTime;
    Score s;
    MeasurePanel mp;
    
    public TranscriberKeyListener(Score s, MeasurePanel mp)
    {
        this.lastTime = -1;
        this.mp = mp;
    }
    
    public void setScore(Score s)
    {
        this.s = s;
    }
    
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            if(lastTime == -1)
                lastTime = System.currentTimeMillis();
            if(lastTime != -1)
            {
                int length = (int)(System.currentTimeMillis() - lastTime);
                s.addNote(length, false);
                mp.setMeasure(s.last);
                mp.repaint();
                lastTime = System.currentTimeMillis();
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_P)
        {
            Playback.play(s);
        }
        else if(e.getKeyCode() == KeyEvent.VK_G)
        {
            Playback.play(s);
        }
        else if(e.getKeyCode() == KeyEvent.VK_S)
        {
            String x = ("savename");
            try
            {
                s.saveAs(x);
            }
            catch(FileNotFoundException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_R)
        {
            String fileName = "savename.otb";
            System.out.println("Here");
            try
            {
                Score s = Score.read(fileName);
                Playback.play(s);
                
            }
            catch(FileNotFoundException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    
}
