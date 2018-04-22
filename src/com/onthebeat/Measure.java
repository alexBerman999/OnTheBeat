package com.onthebeat;

public class Measure {
	int spaceLeft;
	int beatSize;
	int timeBot;

	Note first; 
	Note last;
	Measure next = null;
	
	public Measure (){
	}
	
	public Measure (int measureMax, int beatSize, int timeBot){
		this.spaceLeft = measureMax;
		this.beatSize = beatSize;
		this.timeBot = timeBot;
	}
	
	public void addNote (int length, boolean rest) {
		if (last != null) {
			//if measure is not empty
			//if length is less than
			last.next = new Note (rest, length/timeBot, beatSize);
			last = last.next;
			
			switch (last.type) {
				case 'w': spaceLeft -= beatSize*timeBot;
					break;
				case 'h': spaceLeft -= beatSize*timeBot/2;
					break;
				case 'q': spaceLeft -= beatSize*timeBot/4;
					break;
				case 'e': spaceLeft -= beatSize*timeBot/8;
					break;
				case 's': spaceLeft -= beatSize*timeBot/16;
					break;
			}
			
			while (last.overflow > .85*(double)(beatSize)/16) {
				last.tie = true;
				last.next = new Note (rest, last.overflow, beatSize);
				last = last.next;
				
				switch (last.type) {
					case 'w': spaceLeft -= beatSize*timeBot;
						break;
					case 'h': spaceLeft -= beatSize*timeBot/2;
						break;
					case 'q': spaceLeft -= beatSize*timeBot/4;
						break;
					case 'e': spaceLeft -= beatSize*timeBot/8;
						break;
					case 's': spaceLeft -= beatSize*timeBot/16;
						break;
				}
				
			}
		} else {
			//if measure is empty
			first = new Note (rest, length/timeBot, beatSize);
			last = first;
			
			switch (last.type) {
				case 'w': spaceLeft -= beatSize*timeBot;
					break;
				case 'h': spaceLeft -= beatSize*timeBot/2;
					break;
				case 'q': spaceLeft -= beatSize*timeBot/4;
					break;
				case 'e': spaceLeft -= beatSize*timeBot/8;
					break;
				case 's': spaceLeft -= beatSize*timeBot/16;
					break;
			}
			
			while (last.overflow > .85*(double)(beatSize)/16) {
				last.tie = true;
				last.next = new Note (rest, last.overflow, beatSize);
				last = last.next;
				
				switch (last.type) {
					case 'w': spaceLeft -= beatSize*timeBot;
						break;
					case 'h': spaceLeft -= beatSize*timeBot/2;
						break;
					case 'q': spaceLeft -= beatSize*timeBot/4;
						break;
					case 'e': spaceLeft -= beatSize*timeBot/8;
						break;
					case 's': spaceLeft -= beatSize*timeBot/16;
						break;
				}
			}
			
		}
	}
}
