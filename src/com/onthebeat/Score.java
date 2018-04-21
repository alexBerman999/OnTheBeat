package com.onthebeat;

public class Score {
	Measure first = null;
	Measure last = null;

	String name;
	int timeTop;
	int timeBot;
	int bpm;
	
	int measureMax;
	int beatSize;
	
	Score (String name, int timeTop, int timeBot, int bpm) {
		this.name = name;
		this.timeTop = timeTop;
		this.timeBot = timeBot;
		this.bpm = bpm;
		beatSize = 60000/bpm;
		measureMax = beatSize*timeTop;
	}
	
	public void addNote (int length, boolean rest) {
		if ((double)length/timeBot/beatSize/16 > .85) {
			//if the length is greater than 85% of a 16th note
			
			if (last != null && last.spaceLeft < (double)length/timeBot/beatSize ) {
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
			} else {
				last.addNote(length, rest);
				length = 0;
			}
			
			while ((double)length/timeBot/beatSize/16 > .85) {
				last.last.tie = true;
				if (length > last.spaceLeft) {
					holder = length-last.spaceLeft;
					last.addNote(last.spaceLeft, rest);
					length = holder;
				} else {
					last.addNote(length, rest);
					length = 0;
				}
			}
			
		}
	}
	
	
}
