package main.java;

import java.io.File;

import com.musicg.wave.Wave;
import com.musicg.fingerprint.*;

public class FitnessEvaluator extends Thread {
	
	private String filename;
	public FitnessEvaluator(String fname)
	{
		this.filename = fname;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		double score = new FingerprintSimilarityComputer(new Wave(filename).getFingerprint(),
				new Wave("Trr1.wav").getFingerprint()).getFingerprintsSimilarity().getSimilarity();
				
		System.out.println(score);
				/*FingerprintSimilarityComputer(
				new Wave(filename).getFingerprint(),
				new Wave("Trr1.wav").getFingerprint()).;
			*/
	}
	
	

}
