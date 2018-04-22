package com.onthebeat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Score {
    public Measure first = null;
	public Measure last = null;

	String name;
	int timeTop;
	int timeBot;
	int bpm;
	
	int measureMax;
	int beatSize;
	
	public Score (){
	}
	
	public Score (String name, int timeTop, int timeBot, int bpm) {
		this.name = name;
		this.timeTop = timeTop;
		this.timeBot = timeBot;
		this.bpm = bpm;
		beatSize = 60000/bpm;
		measureMax = beatSize*timeTop;
	}
	
	public void addNote (int length, boolean rest) {
		if ((double)length/timeBot/(beatSize/16) > .85) {
			//if the length is greater than 85% of a 16th note
			
			if (last != null && last.spaceLeft < .85*((double)beatSize*timeBot/16)) {
				//if the score is not empty, but you need a new measure
				//(if the measure has less than a sixteenth note of space left)
				last.next = new Measure(measureMax, beatSize, timeBot);
				last = last.next;
			} else if (last == null) {
				//if the score is empty
				first = new Measure(measureMax, beatSize, timeBot);
				last = first;
			}
			
			int holder;
			if (length > last.spaceLeft) {
				holder = length-last.spaceLeft;
				last.addNote(last.spaceLeft, rest);
				length = holder;
				last.next = new Measure(measureMax, beatSize, timeBot);
				if ((double)length/(beatSize*timeBot/16) > .85)
					last.last.tie = true;
				last = last.next;
			} else {
				last.addNote(length, rest);
				length = 0;
			}
			
			while ((double)length/(beatSize*timeBot/16) > .85) {
				if (length > last.spaceLeft) {
					holder = length-last.spaceLeft;
					last.addNote(last.spaceLeft, rest);
					length = holder;
					last.next = new Measure(measureMax, beatSize, timeBot);
					if ((double)length/(beatSize*timeBot/16) > .85)
						last.last.tie = true;
					last = last.next;
				} else {
					last.addNote(length, rest);
					length = 0;
				}
			}
			
		}
	}
	
	
	public void format() {
		if ((double)last.spaceLeft/timeBot/(beatSize/16) > .85) {
			last.addNote(last.spaceLeft, true);
		}
		
		for (Measure ptr1 = first; ptr1 != null; ptr1 = ptr1.next) {
			for (Note ptr2 = ptr1.first; ptr2 != null; ptr2 = ptr2.next) {
				if (ptr2.tie) {
					if (ptr2.next != null) {
						if (ptr2.rest == ptr2.next.rest) {
							switch (ptr2.type) {
								case 'w': if (ptr2.next.type == 'h') {
										ptr2.dot = true;
										ptr2.tie = ptr2.next.tie;
										ptr2.next = ptr2.next.next;
									}
									break;
								case 'h': if (ptr2.next.type == 'q') {
										ptr2.dot = true;
										ptr2.tie = ptr2.next.tie;
										ptr2.next = ptr2.next.next;
									}
									break;
								case 'q': if (ptr2.next.type == 'e') {
										ptr2.dot = true;
										ptr2.tie = ptr2.next.tie;
										ptr2.next = ptr2.next.next;
									}
									break;
								case 'e': if (ptr2.next.type == 's') {
										ptr2.dot = true;
										ptr2.tie = ptr2.next.tie;
										ptr2.next = ptr2.next.next;
									}
									break;
							}
						}
					}
				}
			}
		}
	}
	
	public void saveAs(String fileName) throws FileNotFoundException {
        File f = new File("scores/" + fileName + ".otb");
        System.out.println(f.getAbsolutePath());
        PrintWriter out = new PrintWriter(f);
        out.print(timeTop + " " + timeBot + " " + bpm + " ");
        
        Measure m = first;
        while (m != null) {
            Note n = m.first;
            while (n != null) {
                out.print(n.type +" ");
                if (n.dot)
                    out.print("d ");
                else
                    out.print("n ");
                if (n.rest)
                    out.print("r ");
                else
                    out.print("n ");
                if (n.tie)
                    out.print("t ");
                else
                    out.print("n ");
                n = n.next;
            }
            m = m.next;
        }
        out.flush();
    }
    
    public static Score read (String filename) throws FileNotFoundException {
        File f = new File ("scores/" + filename);
        Scanner scan = new Scanner (f);
        int top = scan.nextInt();
        int bot = scan.nextInt();
        int bpm = scan.nextInt();
        Score s = new Score (filename, top, bot, bpm);
        int noteLength = s.beatSize * bot;
        while (scan.hasNext()) {
            String notetype = scan.next();
            switch (notetype) {
            case "w":
                s.addNote(noteLength, false);
                break;
            case "h":
                s.addNote(noteLength / 2, false);
                break;
            case "q":
                s.addNote(noteLength / 4, false);
                break;
            case "e":
                s.addNote(noteLength / 8, false);
                break;
            case "s":
                s.addNote(noteLength / 16, false);
                break;
            }
            if(scan.next().equals("d"))
                s.last.last.dot = true;
            if(scan.next().equals("r"))
                s.last.last.rest = true;
            if(scan.next().equals("t"))
                s.last.last.tie = true;
        }
            return s;
        
    }
	
}
