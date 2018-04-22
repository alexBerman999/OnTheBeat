package com.onthebeat.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.onthebeat.Playback;
import com.onthebeat.Score;
import com.onthebeat.gui.ReviewPanel;


public class ReviewKeyListener extends KeyAdapter
{
    Score s;
    ReviewPanel r;
    
    public ReviewKeyListener(Score s, ReviewPanel r)
    {
        this.s = s;
        this.r = r;
    }
    
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_P)
        {
            Playback.play(s);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            r.moveLeft();
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            r.moveRight();
        }
    }
}