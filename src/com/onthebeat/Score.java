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
	
	Score (){
	}
	
	Score (String name, int timeTop, int timeBot, int bpm) {
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
				last = last.next;
			} else {
				last.addNote(length, rest);
				length = 0;
			}
			
			while ((double)length/(beatSize*timeBot/16) > .85) {
				last.last.tie = true;
				if (length > last.spaceLeft) {
					holder = length-last.spaceLeft;
					last.addNote(last.spaceLeft, rest);
					length = holder;
					last.next = new Measure(measureMax, beatSize, timeBot);
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
	
}
