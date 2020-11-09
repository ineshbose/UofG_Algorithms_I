public class AdjListNode {

	private int vertexIndex;
	private int vertexDist;


	public AdjListNode(int vertexIndex, int vertexDist){
		this.vertexIndex = vertexIndex;
		this.vertexDist = vertexDist;
	}

	public int getVertexIndex(){
		return this.vertexIndex;
	}

	public void setVertexIndex(int n){
		this.vertexIndex = n;
	}

	public int getVertexDist(){
		return this.vertexDist;
	}

	public void setDist(int n){
		this.vertexDist = n;
	}

}
