package com.onthebeat.gui;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TempoTapperPanel extends JPanel
{
    private JLabel tempoTap;
    private JButton tempoButton, backButton;
    private TempoListener t;
    
    public TempoTapperPanel()
    {
        this.setPreferredSize(new Dimension(400, 400));
        t = new TempoListener(this);
        
        tempoTap = new JLabel();
        
        this.add(tempoTap);
        this.addKeyListener(t);
        update();
    }
    
    public void update()
    {
        int tempo = t.getTempo();
        if(tempo == -1)
            tempoTap.setText("Hit Space for Tempo");
        else
            tempoTap.setText(tempo+"");
    }
}

class TempoListener extends KeyAdapter
{
    private int tempo;
    private long lastTime;
    private TempoTapperPanel tPanel;
    public TempoListener(TempoTapperPanel tPanel)
    {
        tempo = -1;
        lastTime = -1;
        this.tPanel = tPanel;
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
                System.out.println(time);
                tempo = 60000/time;
                lastTime = -1;
            }
        }
        tPanel.update();
    }
}
