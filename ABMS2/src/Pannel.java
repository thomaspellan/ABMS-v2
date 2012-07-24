import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Pannel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sizeNode=50; 
	private int sizeAgent=10; 
	private int nbNodes=1; // Count number of nodes


	public void paintComponent(Graphics g){

		nbNodes=1;
		//White background color
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        // Adding the nodes and their agents in the environment
		for (int i=0;i<Parameters.getTotalNbNodes(); i++)
			addNode(g);

		// Adding the paths between nodes
		for(int i=0;i<Parameters.getTotalNbLinks();i++){
			addPath(g,Parameters.getTabLink(i),Parameters.getTabLink2(i));
		}


	}


	// Add a specific node to the interface by using a specific position setting

	public void addNode(Graphics g){

		int posXNode=0;
		int posYNode=0;

		if (getNbNodes()%2==0){
			posXNode=300;
			posYNode=100*(getNbNodes()/2);
		}

		else{
				posXNode=100;
				posYNode=100*((getNbNodes()/2)+1);
			}

		g.setColor(Color.blue);

		g.drawRect(posXNode,posYNode,sizeNode,sizeNode);


		for (int i=0; i<Parameters.getTotalNbAgents();i++){
			if (Environment.agent[i].getIdActualNode()==nbNodes)
			{

				g.setColor(Color.red);
				g.fillOval(Environment.agent[i].getPosX(),Environment.agent[i].getPosY(),sizeAgent,sizeAgent);

			}
		}
		nbNodes++;
	}

	// create a line to show the link between two nodes
	public void addPath(Graphics g,int numNode1, int numNode2){

		int posXLine1=0;
		int posYLine1=0;
		int posXLine2=0;
		int posYLine2=0;

		if (numNode1%2==0){
			posXLine1=325;
			posYLine1=100*(numNode1/2)+25;
		}

		else{
			posXLine1=125;
			posYLine1=100*(numNode1/2+1)+25;
			}

		if (numNode2%2==0){
			posXLine2=325;
			posYLine2=100*(numNode2/2)+25;
		}

		else{
			posXLine2=125;
			posYLine2=100*(numNode2/2+1)+25;
			}

		g.setColor(Color.black);

		g.drawLine(posXLine1,posYLine1,posXLine2,posYLine2);
	}

	public int getSizeNode() {
		return sizeNode;
	}

	public void setSizeNode(int sizeNode) {
		this.sizeNode = sizeNode;
	}

	public int getSizeAgent() {
		return sizeAgent;
	}

	public void setSizeAgent(int sizeAgent) {
		this.sizeAgent = sizeAgent;
	}

	public int getNbNodes() {
		return nbNodes;
	}

	public void setNbNodes(int nbNodes) {
		this.nbNodes = nbNodes;
	}
}