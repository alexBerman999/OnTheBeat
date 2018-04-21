package com.onthebeat.gui;

import javax.swing.JFrame;

import com.onthebeat.input.NoteButtonListener;

public class Frame extends JFrame
{
    String title = "On The Beat";
    public Frame()
    {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        NoteInputPanel p = new NoteInputPanel();
        p.addKeyListener(new NoteButtonListener());
        p.setFocusable(true);
        p.grabFocus();
        
        this.add(p);
        
        this.pack();
        this.setVisible(true);
    }
}
