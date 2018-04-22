package com.onthebeat.gui;

import javax.swing.JPanel;

import com.onthebeat.Measure;
import com.onthebeat.Score;
import com.onthebeat.input.ReviewKeyListener;

public class ReviewPanel extends JPanel
{
    private Score s;
    private Measure curMeasure;
    private int measureNum;
    private MeasurePanel mp;
    
    public ReviewPanel(Score s)
    {
        this.s = s;
        ReviewKeyListener r = new ReviewKeyListener(s, this);
        this.addKeyListener(r);
        curMeasure = s.first;
        measureNum = 0;
        mp = new MeasurePanel();
        mp.setMeasure(curMeasure);
        this.add(mp);
    }
    
    public void moveLeft()
    {
        if(measureNum != 0)
        {
            measureNum--;
            Measure nextTarget = curMeasure;
            Measure m = s.first;
            while(m.next != nextTarget)
                m = m.next;
            curMeasure = m;
            mp.setMeasure(m);
        }
    }
    
    public void moveRight()
    {
        if(curMeasure.next != null)
        {
            measureNum++;
            curMeasure = curMeasure.next;
            mp.setMeasure(curMeasure);
        }
    }
}
