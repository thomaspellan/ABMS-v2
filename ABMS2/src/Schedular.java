
public class Schedular extends Node{
	
	private int []actions;
	private int []actionTime;
	private int []actionCommander;

	public Schedular(int idNode){
		super(idNode);
		for(int i = 0; i < 50; i++) {
			actions[i] = 0;
			actionTime[i] = 0;
			actionCommander[i] = 0;
		}
	}

}