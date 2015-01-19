package main.java;

import main.java.Genome;

public class GenePool {
	
	private int PopSize;
	private Genome[] GenomeArr;

	public GenePool(int PopulationSize)
	{
		this.PopSize = PopulationSize;
		this.GenomeArr = new Genome[PopSize];
		CreatePopulation();
		
	}
	
	public void CreatePopulation()
	{
		for(int i=0; i< PopSize ; i++)
		{
			GenomeArr[i] = new Genome();
		}
	}
}
