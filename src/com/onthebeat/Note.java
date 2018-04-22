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
		System.out.println(size*4);
		this.rest = rest;
		if (size/(double)(beatSize) > .95) {
			type = 'w';
			overflow = size - beatSize;
		} else if (size/((double)beatSize/2) > .95) {
			type = 'h';
			overflow = size - beatSize/2;
		} else if (size/((double)beatSize/4) > .95) {
			type = 'q';
			overflow = size - beatSize/4;
		} else if (size/((double)beatSize/8) > .95) {
			type = 'e';
			overflow = size - beatSize/8;
		} else if (size/((double)beatSize/16) > .95) {
			type = 's';
			overflow = size - beatSize/16;
		}
	}
}
