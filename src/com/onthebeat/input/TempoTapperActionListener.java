package com.onthebeat.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.onthebeat.Driver;
import com.onthebeat.gui.Frame;
import com.onthebeat.gui.TempoTapperPanel;


public class TempoTapperActionListener implements ActionListener
{
    private Frame f;
    private TempoTapperPanel t;
    
    public TempoTapperActionListener(Frame f, TempoTapperPanel t)
    {
        this.f = f;
        this.t = t;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == t.backButton)
            f.switchPanel(Driver.MENU);
    }
}
