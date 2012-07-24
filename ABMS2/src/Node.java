public class Node {

	private int idNode;// Identifier of the node
	private int []agents; 

	Agent agent[];
	
	// COnstructor
	public Node(int idNode) {
		this.idNode = idNode;
	}
	
	public void setContentNode () {
		for (int i = 1; i <= Parameters.getTotalNbAgents(); i++) {
			if (agent[i-1].getIdActualNode() == this.idNode) {
				agents[i-1] = 1;
			} else {
				agents[i-1] = 0;
			}
		}
	}

	// Getters and setters
	public int getIdNode() {
		return idNode;
	}
	
	public int getAgentPlacement(int idAgent) {
		return agents[idAgent];
	}

	public void setIdNode(int idNode) {
		this.idNode = idNode;
	}
	
	public void setAgentPlacement (int idAgent, int flag) {
		agents[idAgent] = flag;
	}
}