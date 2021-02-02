package assignment4Graph;

public class Graph {
	
	boolean[][] adjacency;
	int nbNodes;
	
	public Graph (int nb){
		this.nbNodes = nb;
		this.adjacency = new boolean [nb][nb];
		for (int i = 0; i < nb; i++){
			for (int j = 0; j < nb; j++){
				this.adjacency[i][j] = false;
			}
		}
	}
	
	public void addEdge (int i, int j){
		// ADD YOUR CODE HERE
	}
	
	public void removeEdge (int i, int j){
		// ADD YOUR CODE HERE
	}
	
	public int nbEdges(){
		// ADD YOUR CODE HERE
		return 0; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public boolean cycle(int start){
		// ADD YOUR CODE HERE
		return false; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public int shortestPath(int start, int end){
		// ADD YOUR CODE HERE
		return 0; // DON'T FORGET TO CHANGE THE RETURN
	}
	
}
