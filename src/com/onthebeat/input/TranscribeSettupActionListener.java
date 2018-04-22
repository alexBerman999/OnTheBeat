package com.onthebeat.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.onthebeat.Driver;
import com.onthebeat.gui.Frame;
import com.onthebeat.gui.TranscribeSettupPanel;

public class TranscribeSettupActionListener implements ActionListener
{
    private Frame f;
    private TranscribeSettupPanel t;
    
    public TranscribeSettupActionListener(Frame f, TranscribeSettupPanel t)
    {
        this.f = f;
        this.t = t;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == t.backButton)
            f.switchPanel(Driver.MENU);
        else if(e.getSource() == t.nextButton)
            f.switchPanel(Driver.TRANSCRIBE);
    }
}
