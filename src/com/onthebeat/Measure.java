package com.onthebeat;

public class Measure {
	int spaceLeft;
	int beatSize;
	int timeBot;
	
	int overflow;
	Note first; 
	Note last;
	Measure next = null;
	 
	Measure (int measureMax, int beatSize, int timeBot){
		this.spaceLeft = measureMax;
		this.beatSize = beatSize;
		this.timeBot = timeBot;
	}
	
	public void addNote (int length, boolean rest) {
		if (last != null ) {
			//if measure is not empty
			if (length < beatSize/timeBot) {
				last.next = new Note (rest, length/timeBot, beatSize);
				last = last.next;
				while (last.overflow > length/(double)(beatSize)) {
					
				}
			}
			
		} else {
			//if measure is empty
			
		}
	}
}
