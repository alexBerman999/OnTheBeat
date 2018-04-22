package com.onthebeat.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.onthebeat.input.TempoListener;
import com.onthebeat.input.TempoTapperActionListener;

public class TempoTapperPanel extends JPanel implements Updatable
{
    private JLabel tempoTap;
    public JButton backButton;
    private TempoListener t;
    private Frame f;
    
    public TempoTapperPanel(Frame f)
    {
        this.f = f;
        this.setPreferredSize(new Dimension(400, 400));
        t = new TempoListener(this);
        TempoTapperActionListener a = new TempoTapperActionListener(f, this);
        
        tempoTap = new JLabel();
        backButton = new JButton("Back");
        backButton.addActionListener(a);
        
        this.add(tempoTap);
        this.add(backButton);
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