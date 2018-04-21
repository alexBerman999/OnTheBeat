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
		if ((double)length/timeBot/beatSize > .85) {
			//if the length is greater than 85% of a 16th note
			if (last != null && last.spaceLeft != 0) {
				//if there is a last measure and it has space left
				
			} else if (last == null) {
				//if the score is empty
				
			} else {
				//if the score is not empty, but you need a new measure
				
				
			}
		}
	}
	
	
}
