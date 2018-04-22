package com.onthebeat;

public class Note {
	public char type = 'x';
	public boolean dot;
	public boolean rest;
	int overflow = 0;
	
	public boolean tie = false;
	public Note next = null;
	
	public Note (){
	}
	
	public Note (boolean rest, int size, int beatSize){
		this.rest = rest;
		if (size/(double)(beatSize) > .85) {
			type = 'w';
			overflow = size - beatSize;
		} else if (size/((double)beatSize/2) > .85) {
			type = 'h';
			overflow = size - beatSize/2;
		} else if (size/((double)beatSize/4) > .85) {
			type = 'q';
			overflow = size - beatSize/4;
		} else if (size/((double)beatSize/8) > .85) {
			type = 'e';
			overflow = size - beatSize/8;
		} else if (size/((double)beatSize/16) > .85) {
			type = 's';
			overflow = size - beatSize/16;
		}
	}
}
