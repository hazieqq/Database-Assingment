/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


/**
 *
 * @IzzatFC
 */
public class GraphNode<V>  {
    V vertice;
    GraphNode verticeLink;
    Edge edgeLink;
    boolean mark;
    Kangaroo kangaroolink;
    Point pointLink;
    Colony colonyLink;

    public GraphNode(V vertice, GraphNode verticeLink) {
        this.vertice = vertice;
        this.verticeLink = verticeLink;
        edgeLink=null;
        mark=false;
        kangaroolink=null;
    }

    public V getVertice() {
        return vertice;
    }

    public void setVertice(V vertice) {
        this.vertice = vertice;
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

    public boolean getMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public Kangaroo getKangaroolink() {
        return kangaroolink;
    }

    public void setKangaroolink(Kangaroo kangaroolink) {
        this.kangaroolink = kangaroolink;
    }

    public Point getPointLink() {
        return pointLink;
    }

    public void setPointLink(Point pointLink) {
        this.pointLink = pointLink;
    }

    public Colony getColonyLink() {
        return colonyLink;
    }

    public void setColonyLink(Colony colonyLink) {
        this.colonyLink = colonyLink;
    }
    
    public String toString(){
        return "Node  "+vertice ;
    }
}
