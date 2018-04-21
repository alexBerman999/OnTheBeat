package com.onthebeat;

public class Note {
	char type = 'x';
	boolean dot;
	boolean rest;
	int overflow = 0;
	
	boolean tie = false;
	Note next = null;
	
	Note (boolean rest, int size, int beatSize){
		this.rest = rest;
		if (size/(double)(beatSize) > .85) {
			type = 'w';
			overflow = beatSize - size;
		} else if (size/((double)beatSize/2) > .85) {
			type = 'h';
			overflow = beatSize/2 - size;
		} else if (size/((double)beatSize/4) > .85) {
			type = 'q';
			overflow = beatSize/4 - size;
		} else if (size/((double)beatSize/8) > .85) {
			type = 'e';
			overflow = beatSize/8 - size;
		} else if (size/((double)beatSize/16) > .85) {
			type = 's';
			overflow = beatSize/16 - size;
		}
	}
}
