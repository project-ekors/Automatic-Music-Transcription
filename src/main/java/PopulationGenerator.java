package main.java;
import main.java.GenePool;

public class PopulationGenerator extends Thread {

	int popSize;
	
	public PopulationGenerator(int populationSize)
	{
		popSize = populationSize;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		GenePool pool = new GenePool(popSize);
		
	}
	
	
	
	
	

}
