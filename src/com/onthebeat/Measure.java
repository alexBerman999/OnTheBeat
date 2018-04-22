package com.onthebeat;

public class Measure {
	double spaceLeft;
	int beatSize;
	int timeBot;

	public Note first; 
	public Note last;
	public Measure next = null;
	
	public Measure (){
	}
	
	public Measure (double measureMax, int beatSize, int timeBot){
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
				case 'w': spaceLeft -= 1;
					break;
				case 'h': spaceLeft -= .5;
					break;
				case 'q': spaceLeft -= .25;
					break;
				case 'e': spaceLeft -= .125;
					break;
				case 's': spaceLeft -= .0625;
					break;
			}
			
			while (last.overflow > .85*(double)(beatSize)/16) {
				last.tie = true;
				last.next = new Note (rest, last.overflow, beatSize);
				last = last.next;
				
				switch (last.type) {
					case 'w': spaceLeft -= 1;
						break;
					case 'h': spaceLeft -= .5;
						break;
					case 'q': spaceLeft -= .25;
						break;
					case 'e': spaceLeft -= .125;
						break;
					case 's': spaceLeft -= .0625;
						break;
				}
			
				
			}
		} else {
			//if measure is empty
			first = new Note (rest, length/timeBot, beatSize);
			last = first;
			
			switch (last.type) {
				case 'w': spaceLeft -= 1;
					break;
				case 'h': spaceLeft -= .5;
					break;
				case 'q': spaceLeft -= .25;
					break;
				case 'e': spaceLeft -= .125;
					break;
				case 's': spaceLeft -= .0625;
					break;
			}
		
			
			while (last.overflow > .85*(double)(beatSize)/16) {
				last.tie = true;
				last.next = new Note (rest, last.overflow, beatSize);
				last = last.next;
				
				switch (last.type) {
					case 'w': spaceLeft -= 1;
						break;
					case 'h': spaceLeft -= .5;
						break;
					case 'q': spaceLeft -= .25;
						break;
					case 'e': spaceLeft -= .125;
						break;
					case 's': spaceLeft -= .0625;
						break;
				}
			
			}
			
		}
	}
}
