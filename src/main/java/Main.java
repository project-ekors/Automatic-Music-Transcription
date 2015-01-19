package main.java;

import java.awt.image.renderable.RenderableImage;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import main.java.GenePool;


public class Main {

	public static void main(String[] args )
	{
		
		final int populationSize = 102;
		
		
		final int maxGenerations = 20;
		PopulationGenerator genthread = new PopulationGenerator(populationSize);
		
		
		genthread.start();
		//GenePool pool = new GenePool(populationSize);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Midi2WavRenderer render = new Midi2WavRenderer();
			render.start();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
				
	}
	
	
	
	
}
