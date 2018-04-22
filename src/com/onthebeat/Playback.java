package com.onthebeat;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Playback {

	public static void play(Score s) {
		/*
		 * Create a new Sythesizer and open it. Most of the methods you will want to use
		 * to expand on this example can be found in the Java documentation here:
		 * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
		 */

		try {
			Synthesizer midiSynth = MidiSystem.getSynthesizer();
			midiSynth.open();
			// get and load default instrument and channel lists
			Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
			MidiChannel[] mChannels = midiSynth.getChannels();

			midiSynth.loadInstrument(instr[0]);// load an instrument

			Measure m = s.first;
			while (m != null) {
				Note n = m.first;
				while (n != null) {
					if (!n.rest)
						mChannels[0].noteOn(60, 100);// On channel 0, play note number 60 with velocity 100
					try {
						int waitDuration = m.beatSize * m.timeBot;
						switch (n.type) {
						case 'h':
							waitDuration /= 2;
							break;
						case 'q':
							waitDuration /= 4;
							break;
						case 'e':
							waitDuration /= 8;
							break;
						case 's':
							waitDuration /= 16;
							break;
						}
						Thread.sleep(waitDuration); // wait time in milliseconds to control duration
					} catch (InterruptedException e) {
					}
					mChannels[0].noteOff(60);// turn of the note
					n = n.next;
				}
				m = m.next;
			}

		} catch (MidiUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}