package com.onthebeat.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.onthebeat.Driver;
import com.onthebeat.gui.Frame;
import com.onthebeat.gui.MainMenuPanel;


public class MainMenuActionListener implements ActionListener
{
    private Frame f;
    private MainMenuPanel m;
    
    public MainMenuActionListener(Frame f, MainMenuPanel m)
    {
        this.f = f;
        this.m = m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == m.tempoTapButton)
            f.switchPanel(Driver.TEMPO);
        else if(e.getSource() == m.transcribeButton)
            f.switchPanel(Driver.TRANSCRIBE_SETTUP);
        else if(e.getSource() == m.reviewButton)
            f.switchPanel(Driver.REVIEW);
    }
    
}
