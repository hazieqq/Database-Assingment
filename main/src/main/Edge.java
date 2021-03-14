
package main;



public class Edge {
    GraphNode verticeLink;
    Edge edgeLink;
    int weight;

    public Edge(GraphNode verticeLink, Edge edgeLink, int weight) {
        this.verticeLink = verticeLink;
        this.edgeLink = edgeLink;
        this.weight = weight;
    }

    public GraphNode getVerticeLink() {
        return verticeLink;
    }

    public void setVerticeLink(GraphNode verticeLink) {
        this.verticeLink = verticeLink;
    }

    public Edge getEdgeLink() {
        return edgeLink;
    }

    public void setEdgeLink(Edge edgeLink) {
        this.edgeLink = edgeLink;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    
    public String toString(){
        return  " --> "  + verticeLink + " : "+weight;
    }
    
}
