package com.onthebeat.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.onthebeat.Measure;
import com.onthebeat.Note;


public class MeasurePanel extends JPanel
{
    Image whole_note, whole_rest, half_note, half_rest, quarter_note, quarter_rest, eigth_note, eigth_rest,
            sixteenth_note, sixteenth_rest, dot;
    Measure m;
    
    public MeasurePanel()
    {
        whole_note = new ImageIcon("assets/whole_note.png").getImage();
        whole_rest = new ImageIcon("assets/whole_rest.png").getImage();
        half_note = new ImageIcon("assets/half_note.png").getImage();
        half_rest = new ImageIcon("assets/half_rest.png").getImage();
        quarter_note = new ImageIcon("assets/quarter_note.png").getImage();
        quarter_rest = new ImageIcon("assets/quarter_rest.png").getImage();
        eigth_note = new ImageIcon("assets/eigth_note.png").getImage();
        eigth_rest = new ImageIcon("assets/eigth_rest.png").getImage();
        sixteenth_note = new ImageIcon("assets/sixteenth_note.png").getImage();
        sixteenth_rest = new ImageIcon("assets/sixteenth_rest.png").getImage();
        dot = new ImageIcon("assets/dot.png").getImage();
        
        this.setPreferredSize(new Dimension(400, 100));
    }
    
    public void setMeasure(Measure m)
    {
        this.m = m;
        this.repaint();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        g2.drawLine(0, 92, 400, 92);
        // Get notes in measure
        if(m != null)
        {
            int notes = 0;
            Note n = m.first;
            while(n != null)
            {
                notes++;
                n = n.next;
            }
            if(notes > 0)
            {
                int increment = 400 / notes;
                int xVal = 0;
                n = m.first;
                while(n != null)
                {
                    Image img = null;
                    switch (n.type)
                    {
                        case 'w':
                            if(n.rest)
                                img = whole_rest;
                            else
                                img = whole_note;
                            break;
                        case 'h':
                            if(n.rest)
                                img = half_rest;
                            else
                                img = half_note;
                            break;
                        case 'q':
                            if(n.rest)
                                img = quarter_rest;
                            else
                                img = quarter_note;
                            break;
                        case 'e':
                            if(n.rest)
                                img = eigth_rest;
                            else
                                img = eigth_note;
                            break;
                        case 's':
                            if(n.rest)
                                img = sixteenth_rest;
                            else
                                img = sixteenth_note;
                            break;
                    }
                    g2.drawImage(img, xVal, 50, 25, 50, this);
                    if(n.dot)
                    {
                        g2.drawImage(dot, xVal + (increment/3), 40, 25, 50, this);
                        System.out.println("Here");
                    }
                    xVal += increment;
                    n = n.next;
                }
            }
        }
    }
}
