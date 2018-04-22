package com.onthebeat.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import com.onthebeat.Playback;
import com.onthebeat.Score;


public class ReviewKeyListener extends KeyAdapter
{
    Score s;
    
    public ReviewKeyListener(Score s)
    {
        this.s = s;
    }
    
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_P)
        {
            Playback.play(s);
        }
    }
}