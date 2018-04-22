package com.onthebeat.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.onthebeat.Playback;
import com.onthebeat.Score;


public class TranscriberKeyListener extends KeyAdapter
{
    long lastTime;
    Score s;
    
    public TranscriberKeyListener(Score s)
    {
        this.lastTime = -1;
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
                System.out.println("\t" + length);
                s.addNote(length, false);
                lastTime = System.currentTimeMillis();;
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_P)
        {
            Playback.play(s);
        }
    }
}
