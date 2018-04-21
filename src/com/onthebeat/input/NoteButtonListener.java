package com.onthebeat.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javafx.scene.input.KeyCode;

public class NoteButtonListener extends KeyAdapter
{   
    private long startTime;
    
    public NoteButtonListener()
    {
        startTime = -1;
    }
    
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            if(startTime  == -1)
                startTime = System.currentTimeMillis();
        }
    }
    
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            startTime = -1;
        }
    }
}
