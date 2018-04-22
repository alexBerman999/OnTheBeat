package com.onthebeat.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.onthebeat.Driver;
import com.onthebeat.Score;
import com.onthebeat.gui.Frame;
import com.onthebeat.gui.TranscribeSettupPanel;
import com.onthebeat.gui.TranscriberPanel;

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
        {
            int top = Integer.parseInt(t.timeSigTop.getText());
            int bot = Integer.parseInt(t.timeSigBot.getText());
            int tempo = Integer.parseInt(t.tempoField.getText());
            f.switchPanel(Driver.TRANSCRIBE);
            
            ((TranscriberPanel)f.cardMap.get(Driver.TRANSCRIBE)).setScore(new Score("Test", top, bot, tempo));
        }
    }
}
