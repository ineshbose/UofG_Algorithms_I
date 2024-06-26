import java.util.LinkedList;


public class Vertex {

    private LinkedList<AdjListNode> adjList;
    private int index;

	boolean visited;
    Vertex predecessor;


    public Vertex(int index){
    	this.adjList = new LinkedList<AdjListNode>();
    	this.index = index;
    	this.visited = false;
    }

    public Vertex(Vertex v){
    	this.adjList = v.getAdjList();
    	this.index = v.getIndex();
    	this.visited = v.getVisited();
    }

    public LinkedList<AdjListNode> getAdjList(){
        return this.adjList;
    }

    public int getIndex(){
    	return this.index;
    }

    public void setIndex(int n){
    	this.index = n;
    }

    public boolean getVisited(){
    	return this.visited;
    }

    public void setVisited(boolean b){
    	this.visited = b;
    }

    public Vertex getPredecessor(){
    	return this.predecessor;
    }

    public void setPredecessor(Vertex v){
    	this.predecessor = v;
    }

    public void addToAdjList(int n){
        this.adjList.addLast(new AdjListNode(n));
    }

    public int vertexDegree(){
        return this.adjList.size();
    }
}
