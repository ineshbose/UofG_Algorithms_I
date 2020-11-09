import java.util.LinkedList;


public class Vertex {

    private LinkedList<AdjListNode> adjList;
    private int index;
    private int dist;

    Vertex predecessor;


    public Vertex(int index){
    	this.adjList = new LinkedList<AdjListNode>();
    	this.index = index;
        this.dist = Integer.MAX_VALUE;
    }

    public Vertex(Vertex v){
    	this.adjList = v.getAdjList();
    	this.index = v.getIndex();
        this.dist = v.getDist();
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

    public int getDist(){
        return this.dist;
    }

    public void setDist(int d){
        this.dist = d;
    }

    public Vertex getPredecessor(){
        return this.predecessor;
    }

    public void setPredecessor(Vertex v){
        this.predecessor = v;
    }

    public void addToAdjList(int n, int d){
        this.adjList.addLast(new AdjListNode(n, d));
    }

    public int vertexDegree(){
        return this.adjList.size();
    }
}
