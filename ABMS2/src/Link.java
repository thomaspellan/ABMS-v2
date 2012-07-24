public class Link {

	private int idNodeSource;
	private int idNodeDest;



	public Link(int idNodeSource, int idNodeDest) {
		this.idNodeSource = idNodeSource;
		this.idNodeDest = idNodeDest;
	}

	// Getters and setters
	public int getIdNodeSource() {
		return idNodeSource;
	}

	public void setIdNodeSource(int idNodeSource) {
		this.idNodeSource = idNodeSource;
	}

	public int getIdNodeDest() {
		return idNodeDest;
	}

	public void setIdNodeDest(int idNodeDest) {
		this.idNodeDest = idNodeDest;
	}


}