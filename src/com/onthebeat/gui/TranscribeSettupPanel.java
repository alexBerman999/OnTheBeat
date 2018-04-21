package com.onthebeat.gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TranscribeSettupPanel extends JPanel
{
    private JLabel timeSigLabel, tempoLabel, tempoTapOutPutLabel;
    private JTextField timeSigTop, timeSigBot, tempoField;
    public TranscribeSettupPanel()
    {
        this.setPreferredSize(new Dimension(400, 400));
    }
}
