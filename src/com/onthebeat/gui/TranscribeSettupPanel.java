package com.onthebeat.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.onthebeat.input.TempoListener;
import com.onthebeat.input.TranscribeSettupActionListener;

public class TranscribeSettupPanel extends JPanel implements Updatable
{
    private JLabel titleLabel, timeSigLabel, tempoLabel, tapLabel;
    public JTextField timeSigTop, timeSigBot, tempoField;
    public JButton backButton, nextButton;
    private Frame f;
    private TempoListener t;
    public TranscribeSettupPanel(Frame f)
    {
        this.f = f;
        t = new TempoListener(this);
        TranscribeSettupActionListener s = new TranscribeSettupActionListener(f, this); 
        this.addKeyListener(t);
        this.setPreferredSize(new Dimension(400, 400));
        titleLabel = new JLabel("Settup");
        timeSigLabel = new JLabel("Time Signature");
        timeSigTop = new JTextField("4");
        timeSigTop.setPreferredSize(new Dimension(32, 18));
        timeSigBot = new JTextField("4");
        timeSigBot.setPreferredSize(new Dimension(32, 18));
        tempoLabel = new JLabel("Tempo");
        tempoField = new JTextField("100");
        tempoField.setPreferredSize(new Dimension(32, 18));
        tapLabel = new JLabel("Tap Space For Tap Tempo");
        backButton = new JButton("Back");
        backButton.addActionListener(s);
        nextButton = new JButton("Transcribe");
        nextButton.addActionListener(s);
        
        this.add(titleLabel);
        this.add(timeSigLabel);
        this.add(timeSigTop);
        this.add(timeSigBot);
        this.add(tempoLabel);
        this.add(tempoField);
        this.add(tapLabel);
        this.add(backButton);
        this.add(nextButton);
    }
    @Override
    public void update()
    {
        int tempo = t.getTempo();
        if(tempo != -1)
            tempoField.setText(tempo + "");
    }
}
