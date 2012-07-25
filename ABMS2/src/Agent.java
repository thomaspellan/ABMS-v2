
public class Agent {

	private int idAgent; // id assigned to the agent
	private int idActualNode; // Identifier of his current node
	private int posX; // X position in the environment
	private int posY; // Y position in the environment
	private int[] MessagesReceived = new int[500];
	private int[] MessagesSender = new int[500];
	private int[] MessageTime = new int[500];
	
	Schedular schedular[];
	Node node[];
	Agent agent[];
	Environment env;

	
	//Constructors
	public Agent(int idAgent, int idActualnode) {
		this.idAgent = idAgent;
		this.idActualNode = idActualnode;
		for (int i=0;i<MessagesReceived.length;i++){
			MessagesReceived[i]=0;
			MessagesSender[i]=0;
		}
	}

	public Agent(int idAgent, int idActualnode,int posX,int posY) {
		this.idAgent = idAgent;
		this.idActualNode = idActualnode;
		this.posX= posX;
		this.posY=posY;
		for (int i=0;i<MessagesReceived.length;i++){
			MessagesReceived[i]=0;
			MessagesSender[i]=0;
		}
	}
	
	//Behaviour of the Agent
	public void Step() {
		int tmp;
		for(int i = 0; i < Parameters.getTotalNbAgents(); i++) {
			tmp = countAgentsIntoNode(i);
			for(int j = 0; j < Parameters.getTotalNbNodes(); j++) {
				if (linkExist(agent[i].getIdActualNode(), node[j].getIdNode()) && tmp < countAgentsIntoNode(j)) {
					tmp = j;
				}
			}
			if (tmp != countAgentsIntoNode(i)) {
				agent[i].scheduleAction(tmp, 1, 0, env.getTime()+1);
			}
		}
	}
	
	//Method to schedule the actions
	public void scheduleAction (int idTarget, int action, int content, int time) {
		int i = 0;
		int tmp = this.getIdActualNode();
		while (schedular[tmp].getActions(i) != 0) {
			i++;
		}
		schedular[tmp].setActions(i, action);
		schedular[tmp].setActionCommander(i, this.getIdAgent());
		schedular[tmp].setActionTarget(i, idTarget);
		schedular[tmp].setActionContent(i, content);
		schedular[tmp].setActionTime(i, time);
	}
	
	
	//Method to check if there is a link between two nodes
	public boolean linkExist(int nodeSource, int nodeDest){
			boolean flag = false;
			for(int i =0; i < Parameters.getTotalNbLinks(); i++) {
				if((Parameters.getTabLink(i) == nodeSource && Parameters.getTabLink2(i) == nodeDest) || ( Parameters.getTabLink2(i) == nodeSource && Parameters.getTabLink(i) == nodeDest)) {
					flag = true;
				}
			}
			return flag;
		}
		
	// Move from one node to another one
	public void move(int idNodeDest){
			if (linkExist(this.getIdActualNode(),idNodeDest)) {
				unregisterIntoNode(idActualNode);
				setIdActualNode(idNodeDest);
				registerIntoNode(idNodeDest);
				int sizeNode= 50;
				int posXNode=0;
				int posYNode=0;
					
				if (this.getIdActualNode()%2==0){
					posXNode=300;
					posYNode=100*(this.getIdActualNode()/2);
				}
				else{
					posXNode=100;
					posYNode=100*((this.getIdActualNode()/2)+1);
				}
				this.setPosX((int)(Math.random()*(sizeNode-10)+posXNode)); //Attribute a random place for the agent in the node
				this.setPosY((int)(Math.random()*(sizeNode-10)+posYNode)); //Attribute a random place for the agent in the node
			}
			env.graphicMove();
		}

		// Send a message to an other agent
	public void sendMessage(int msg, int idAgentDest){
			int i = 0;
			while (agent[idAgentDest].getMessagesReceived(i) != 0 && agent[idAgentDest].getMessagesSender(i) !=0 ) {
				i++;
			}
			agent[idAgentDest].setMessageReceived(i, msg);
			agent[idAgentDest].setMessageSender(i, this.getIdAgent());
			agent[idAgentDest].setMessageTime(i);
			System.out.println("message successfully sent between "+this.getIdAgent()+" and "+idAgentDest+" : "+msg);
		}

		//register the agent into a node when moving
	public void registerIntoNode (int idNode) {
		node[idNode].setAgentPlacement(idNode, 1);
		/*for (int i = 0; i < Parameters.getTotalNbAgents(); i++) {
			if ( node[idNode].getAgentPlacement(i) != 0) {
				this.sendMessage(1, i);
			}
		}*/
	}
	
		//returns the number of agents in a defined node
	public int countAgentsIntoNode (int idNode) {
		int nb = 0;
		for (int i = 1; i <= Parameters.getTotalNbAgents(); i++) {
			if (node[idNode].getAgentPlacement(i) != 0) {
				nb++;
			}
		}
		return nb;
	}
	
		//unregister the agent into a node when leaving
	public void unregisterIntoNode (int idNode) {
		/*for(int i = 0; i < Parameters.getTotalNbAgents(); i++) {
			if (node[this.getIdActualNode()].getAgentPlacement(i) != 0) {
				this.sendMessage(2, i);
			}
		}*/
		node[idNode].setAgentPlacement(idNode, 0);
	}
		

	//Getters and setters
	public int getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}

	public int getIdActualNode() {
		return idActualNode;
	}

	public void setIdActualNode(int idActualNode) {
		this.idActualNode = idActualNode;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getMessagesReceived(int i) {
		return this.MessagesReceived[i];
	}

	public int getMessagesSender(int i) {
		return this.MessagesSender[i];
	}
	
	public void setMessageReceived (int i, int nb) {
		this.MessagesReceived[i] = nb;
	}
	
	public void setMessageSender (int i, int id) {
		this.MessagesSender[i] = id;
	}
	
	public void setMessageTime (int i) {
		this.MessageTime[i] = env.getTime();
	}
	
	
}