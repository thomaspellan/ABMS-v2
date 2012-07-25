
public class Schedular{
	
	private int idNode;
	private int []actions = new int[500];
	private int []actionTime = new int[500];
	private int []actionCommander = new int[500];
	private int []actionTarget = new int[500];
	private int []actionContent = new int[500];
	
	Environment env;
	Agent [] agent;

	public Schedular(int id){
		idNode = id;
		for(int i = 0; i < 500; i++) {
			actions[i] = 0;
			actionTime[i] = 0;
			actionCommander[i] = 0;
			actionTarget[i] = 0;
			actionContent[i] = 0;
		}
		System.out.println("schedular of node "+idNode+" created");
	}

	//Executes the actions scheduled by the agent
	public void Step () {
		for(int i = 0; i < 500; i ++) {
			if (actionTime[i] == env.getTime()) {
				if(actions[i] == 1) {
					agent[actionCommander[i]].move(actionTarget[i]);
				}
				else if(actions[i] == 2) {
					agent[actionCommander[i]].sendMessage(actionContent[i], actionTarget[i]);
				}
			}
		}
		int time = env.getTime();
		env.setTime(time+1);
	}
	
	//getters and setters
	public int getActions (int i) {
		return actions[i];
	}
	
	public int getActionTime (int i) {
		return actionTime[i];
	}
	
	public int getActionCommander(int i) {
		return actionCommander[i];
	}
	
	public void setActions (int i, int nb) {
		this.actions[i] = nb;
	}
	
	public void setActionTime (int i, int nb) {
		this.actionTime[i] = nb;
	}
	
	public void setActionCommander ( int i, int nb) {
		this.actionCommander[i] = nb;
	}
	
	public int getActionTarget(int i) {
		return actionTarget[i];
	}
	
	public void setActionTarget( int i, int nb) {
		this.actionTarget[i] = nb;
	}
	
	public void setActionContent ( int i, int nb) {
		this.actionContent[i] = nb;
	}
	
	public int getActionContent(int i) {
		return actionContent[i];
	}
}