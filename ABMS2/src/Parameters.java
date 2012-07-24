public class Parameters {

	private static int TotalNbNodes; // Total number of nodes in the environment
	private static int TotalNbAgents; // Total number of agents in the environment
	private static int TotalNbLinks; // Total number of links in the environment
	private static int[] tabLink= new int[100]; // Table of links 1
	private static int[] tabLink2= new int[100]; // Table of links 2


	//Getters and setters
	public static int getTotalNbNodes() {
		return TotalNbNodes;
	}

	public static void setTotalNbNodes(int totalNbNodes) {
		TotalNbNodes = totalNbNodes;
	}

	public static int getTotalNbAgents() {
		return TotalNbAgents;
	}

	public static void setTotalNbAgents(int totalNbAgents) {
		TotalNbAgents = totalNbAgents;
	}

	public static int getTotalNbLinks() {
		return TotalNbLinks;
	}

	public static void setTotalNbLinks(int totalNbLinks) {
		TotalNbLinks = totalNbLinks;
	}

	public static int getTabLink(int i) {
		return tabLink[i];
	}

	public static void setTabLink(int i,int tabLink) {
		Parameters.tabLink[i] = tabLink;
	}

	public static int getTabLink2(int i) {
		return tabLink2[i];
	}

	public static void setTabLink2(int i,int tabLink2) {
		Parameters.tabLink2[i] = tabLink2;
	}

}