public class Node {

	private int idNode;// Identifier of the node
	private int []agentsPresence; 

	Agent agent[];
	
	// COnstructor
	public Node(int idNode) {
		this.idNode = idNode;
	}
	
	public void setContentNode () {
		for (int i = 0; i < Parameters.getTotalNbAgents(); i++) {
			if (agent[i].getIdActualNode() == this.getIdNode()) {
				agentsPresence[i] = 1;
			} else {
				agentsPresence[i] = 0;
			}
		}
	}

	// Getters and setters
	public int getIdNode() {
		return idNode;
	}
	
	public int getAgentPlacement(int idAgent) {
		return agentsPresence[idAgent];
	}

	public void setIdNode(int idNode) {
		this.idNode = idNode;
	}
	
	public void setAgentPlacement (int idAgent, int flag) {
		agentsPresence[idAgent] = flag;
	}
}