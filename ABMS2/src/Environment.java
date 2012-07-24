import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Environment extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private Pannel pan= new Pannel();
	int sizeNode= 50;
	
	public static Node[] node= new Node[100]; //Table of nodes
	public static Agent[] agent= new Agent[100]; // Table of agents
	public static Link[] link= new Link[100];
	public static int time = 0;
	
	Timer timer;

	public Environment(){

		// We are setting variables from configuration file
		confVar();
		// We are setting up the environment
		setEnv();
		//Title
		this.setTitle("Environment ABMS");	
		//Size
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Modification of the size of the window not allowed
		this.setResizable(false);
		//Place the window in the middle of the screen
		this.setLocationRelativeTo(null);

		container.setLayout(new BorderLayout());

		container.add(pan, BorderLayout.CENTER);

		this.setContentPane(container);

		this.setVisible(true);

		timer = new Timer();
	}


	public void graphicMove() {
			pan.repaint();	
	}



	// Method used to configure all the parameters of the environment
	private void confVar(){
		  try
	       {
			  BufferedReader fluxEntree=
	          new BufferedReader(new FileReader("parameters.txt"));

			  // Configure total number of nodes
	       		String ligne = fluxEntree.readLine( );
	           String str[]= ligne.split(":");
	           int val=Integer.parseInt(str[1]);
	           Parameters.setTotalNbNodes(val);

	           // Configure total number of agents
	           ligne = fluxEntree.readLine( );
	           str=ligne.split(":");
	           val=Integer.parseInt(str[1]);
	           Parameters.setTotalNbAgents(val);

	           // Configure total number of links
	           ligne = fluxEntree.readLine( );
	           str=ligne.split(":");
	           val=Integer.parseInt(str[1]);
	           Parameters.setTotalNbLinks(val);

	           for (int i=0; i<Parameters.getTotalNbLinks();i++){
	        	   ligne = fluxEntree.readLine( );
		           str=ligne.split(":");
		           val=Integer.parseInt(str[1]);
		           int val2=Integer.parseInt(str[2]);
		           Parameters.setTabLink(i,val);
		           Parameters.setTabLink2(i,val2);
	           }


	           fluxEntree.close( );


	       }

	       catch(FileNotFoundException e)
	       {   
	    	   System.out.println(" File does not exist");
	           System.out.println("or error opening file");}
	       catch(IOException e)
	       {   
	    	   System.out.println("Error reading file.");
	       }

	}


	// Method used to set all the elements of the environment (nodes , agents, links ) 

	private void setEnv(){

		// Nodes
		for (int i=1;i<=Parameters.getTotalNbNodes();i++){ // We create the nodes by assigning them ID
			node[i-1]= new Node(i-1);
			System.out.println("Node id " + node[i-1].getIdNode()+ " created");
		}

		// Agents
		for (int i=0;i<Parameters.getTotalNbAgents();i++){ // We create the agents by assigning them ID and putting them randomly in the nodes
			agent[i]= new Agent(i,(int)(Math.random() * (Parameters.getTotalNbNodes())) + 1);
			int posXNode=0;
			int posYNode=0;

			if (agent[i].getIdActualNode()%2==0){
				posXNode=300;
				posYNode=100*(agent[i].getIdActualNode()/2);
			}

			else{
					posXNode=100;
					posYNode=100*((agent[i].getIdActualNode()/2)+1);
				}

			agent[i].setPosX((int)(Math.random()*(sizeNode-10)+posXNode)); //Attribute a random place for the agent in the node
			agent[i].setPosY((int)(Math.random()*(sizeNode-10)+posYNode)); //Attribute a random place for the agent in the node
			System.out.println("Agent id " +agent[i].getIdAgent()+ " in node:" +agent[i].getIdActualNode());
		}

		for(int i=0;i<Parameters.getTotalNbLinks();i++){
			link[i]=new Link(Parameters.getTabLink(i),Parameters.getTabLink2(i));
		}
		for(int j = 1; j <= Parameters.getTotalNbNodes(); j++) {
			node[j-1].setContentNode();
		}
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int nb) {
		time = nb;
	}
}
