package com.onthebeat.gui;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.onthebeat.Score;
import com.onthebeat.input.TranscriberKeyListener;

public class TranscriberPanel extends JPanel
{
    private Score s;
    private TranscriberKeyListener k;
    private MeasurePanel mp;
    public TranscriberPanel()
    {
        this.setPreferredSize(new Dimension(800, 200));
        mp = new MeasurePanel();
        k = new TranscriberKeyListener(s, mp);
        this.add(mp);
        this.addKeyListener(k);
    }
    
    public void setScore(Score s)
    {
        this.s = s;
        k.setScore(s);
    }
}
