import java.util.LinkedList;


public class Graph {

	private Vertex[] vertices;
	private int numVertices = 0;


	public Graph(int numVertices){
		this.numVertices = numVertices;
		this.vertices = new Vertex[numVertices];
		for (int i = 0; i < numVertices; i++)
			this.vertices[i] = new Vertex(i);
	}

	public int size(){
		return this.numVertices;
	}

	public Vertex getVertex(int i){
		return this.vertices[i];
	}

	public void setVertex(int i){
		this.vertices[i] = new Vertex(i);
	}

	public LinkedList<Vertex> getPath(int n1, int n2){
		Vertex v1 = getVertex(n1);
		Vertex v2 = getVertex(n2);

		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		v1.setDist(0);
		queue.add(v1);
		while(!queue.isEmpty()){
			Vertex u = queue.remove();
			for(AdjListNode node : u.getAdjList()){
				Vertex w = getVertex(node.getVertexIndex());
				int temp_dist = node.getVertexDist() + u.getDist();
				if(temp_dist < w.getDist()){
					w.setPredecessor(u);
					w.setDist(temp_dist);
					queue.add(w);
				}
			}
		}

		LinkedList<Vertex> path = new LinkedList<Vertex>();
		for(Vertex v = v2; path.size() != this.numVertices; v = v.getPredecessor()){
			path.add(v);
			if(v.getIndex() == n1) break;
		}

		int path_size = path.size();
		for(int i = 0; i < path_size / 2; i++){
            Vertex temp = path.get(i);
            path.set(i, path.get(path_size - i - 1));
            path.set(path_size - i - 1, temp);
        }

		if(path.getFirst().getIndex() == n1){
			return path;
		}
		else{
			path.clear();
		}
		return path;
	}

}
