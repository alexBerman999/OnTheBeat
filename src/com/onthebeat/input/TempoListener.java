package com.onthebeat.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.onthebeat.gui.TempoTapperPanel;
import com.onthebeat.gui.Updatable;


public class TempoListener extends KeyAdapter
{
    private static final int MILLIS_PER_MINUTE = 60000;
    private int tempo;
    private long lastTime;
    private TempoTapperPanel tPanel;
    private Updatable u;
    
    public TempoListener(Updatable u)
    {
        this.u = u;
        tempo = -1;
        lastTime = -1;
    }
    
    public int getTempo()
    {
        return tempo;
    }
    
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            if(lastTime == -1)
                lastTime = System.currentTimeMillis();
            else
            {
                int time = (int)(System.currentTimeMillis() - lastTime);
                tempo = MILLIS_PER_MINUTE / time;
                lastTime = System.currentTimeMillis();
            }
        }
        u.update();
    }
}