package main.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Genome {
	
	private int fitnessRatio;
	public static long count = 0;
	private long trid;
	private static final int VELOCITY = 100;
	private static final Random rand = new Random(System.currentTimeMillis());
	private static final Random rand1 = new Random(System.currentTimeMillis());
	String filename;
	
	public HashMap<Long, myWrapper> map = new HashMap<Long, Genome.myWrapper>();
	


	public Genome()
	{
		count++;
		trid = count;
		filename = "Tr"+trid+".midi";
		File outputFile = new File(filename);
		
		try {
			if(outputFile.createNewFile()){
				System.out.println("File created");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sequence sequence = null;
		
		try
		{
			sequence = new Sequence(Sequence.PPQ, 1);
		}
		catch (InvalidMidiDataException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		Track	track = sequence.createTrack();
		int i =0, note,duration;
		while(i<200)
		{
			note = rand.nextInt(127);
			duration = rand1.nextInt(3)+1;
			//duration = 1;
			track.add(createNoteOnEvent(note, i));
			track.add(createNoteOffEvent(note, i+duration));
			i = i + duration;
		}
		
		try
		{
			MidiSystem.write(sequence, 0, outputFile);
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("File Tr"+trid+".midi completed");
		myWrapper arg = new myWrapper();
		arg.fname = filename;
		arg.priority = (float)0;
		map.put(trid, arg);
		//System.out.println(map.toString());
	}
	
	private static MidiEvent createNoteOnEvent(int nKey, long lTick)
	{
		return createNoteEvent(ShortMessage.NOTE_ON,
							   nKey,
							   VELOCITY,
							   lTick);
	}



	private static MidiEvent createNoteOffEvent(int nKey, long lTick)
	{
		return createNoteEvent(ShortMessage.NOTE_OFF,
							   nKey,
							   0,
							   lTick);
	}



	private static MidiEvent createNoteEvent(int nCommand,
											 int nKey,
											 int nVelocity,
											 long lTick)
	{
		ShortMessage	message = new ShortMessage();
		try
		{
			message.setMessage(nCommand,
							   0,	// always on channel 1
							   nKey,
							   nVelocity);
		}
		catch (InvalidMidiDataException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		MidiEvent	event = new MidiEvent(message,
										  lTick);
		return event;
	}
	
	public class myWrapper
	{
	public String fname;
	public Float priority;
	}
}



