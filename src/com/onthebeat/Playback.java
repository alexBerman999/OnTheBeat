package com.onthebeat;

import java.util.Random;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;


public class Playback
{
    static Random generator = new Random();
    static boolean tie;
    
    public enum Scale
    {
        CPentatonic, Blues;
    }
    
    static int[] pent =
    { 72, 74, 76, 79, 81, 84 }, blues =
    { 72, 75, 77, 78, 79, 82, 84 };
    
    public static void play(Score s, Scale g)
    {
        tie = false;
        /*
         * Create a new Sythesizer and open it. Most of the methods you will
         * want to use to expand on this example can be found in the Java
         * documentation here:
         * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/
         * Synthesizer.html
         */
        try
        {
            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();
            // get and load default instrument and channel lists
            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            MidiChannel[] mChannels = midiSynth.getChannels();
            
            midiSynth.loadInstrument(instr[0]);// load an instrument
            
            Measure m = s.first;
            while(m != null)
            {
                Note n = m.first;
                while(n != null)
                {
                    int h = randFreq(g);
                    if(!n.rest)
                        System.out.println(h);
                    if(!tie)
                    mChannels[0].noteOn(h, 100);
                    try
                    {
                        int waitDuration = m.beatSize * m.timeBot;
                        switch (n.type)
                        {
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
                        if(n.dot)
                            waitDuration *= 1.5;
                        Thread.sleep(waitDuration); // wait time in milliseconds
                                                    // to control duration
                    }
                    catch(InterruptedException e)
                    {}
                    if(!n.tie)
                    {
                        mChannels[0].noteOff(h);// turn of the note
                        tie = false;
                    }
                    else tie = true;
                    n = n.next;
                }
                m = m.next;
            }
            
        }
        catch(MidiUnavailableException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }
    
    public static int randFreq(Scale g)
    {
        int[] scale = null;
        if(g == Scale.CPentatonic)
            scale = pent;
        else if(g == Scale.Blues)
            scale = blues;
        int randomIndex = generator.nextInt(scale.length);
        return scale[randomIndex];
    }
}