/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class GUI extends JFrame{
    int width;
    int height;

    ArrayList<Node> nodes;
    ArrayList<edge> edges;
    ArrayList<triangle> tri;
    ArrayList<Height> h;

    public GUI() { //Constructor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	nodes = new ArrayList<Node>();
	edges = new ArrayList<edge>();
        tri= new ArrayList<triangle>();
        h= new ArrayList<Height>();
	width = 100;
	height = 100;
        
    }
    
    
    
    class Height {
        int height;

        public Height(int height) {
            this.height = height;
        }
    }
    
    class Node {
	int x, y;
	String name;
	
	public Node(String name, int x, int y) {
	    this.x = x;
	    this.y = y;
	    this.name = name;
	}
    }
    
    class edge {
	int i,j,h;
	
	public edge(int i, int j,int h) {
	    this.i = i;
	    this.j = j;	    
            this.h=h;
	}
    }
    
    class triangle {
        int[] x,y;
        int n;

        public triangle(int[] x, int[] y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    public GUI(String name) {                                         //Construct with label
	this.setTitle(name);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	nodes = new ArrayList<Node>();
	edges = new ArrayList<edge>();
        tri= new ArrayList<triangle>();
        h= new ArrayList<Height>();
	width = 100;
	height = 100;
    }
    
    public void addHeight(int x){
        h.add(new Height(x));
        this.repaint();
    }
    
    
    public void addTriangle(int []x,int[]y,int n){
        tri.add(new triangle(x,y,n));
        this.repaint();
    }
    
    public void addNode(String name, int x, int y) { 
	//add a node at pixel (x,y)
	nodes.add(new Node(name,x,y));
	this.repaint();                                // controls the paint() method. to repaint itself
    } 
    public void addEdge(int i, int j,int h) {
	//add an edge between nodes i and j
	edges.add(new edge(i,j,h));
	this.repaint();
    }
    
    
    public void paint(Graphics g) {   
        // draw the nodes and edges
        g.setFont(new Font("Ink Free",Font.PLAIN,30));
	FontMetrics f = g.getFontMetrics();
	//int nodeHeight = Math.max(height, f.getHeight());                        //compare which one largest
        for (edge e : edges) {
            
//            g.drawString(String.valueOf(e.h), (nodes.get(e.i).x+10 + nodes.get(e.j).x+10)/2
//                                , (nodes.get(e.i).y+10 + nodes.get(e.j).y+10)/2 );
            g.setColor(Color.RED);
	    g.drawLine(nodes.get(e.i).x+10, nodes.get(e.i).y+10,
		     nodes.get(e.j).x+10, nodes.get(e.j).y+10);
            
            
            g.drawLine(nodes.get(e.j).x-20, nodes.get(e.j).y-20, 
                    nodes.get(e.i).x-20, nodes.get(e.i).y-20);
            
//            g.drawString(String.valueOf(e.h), ((nodes.get(e.i).x-20) + (nodes.get(e.j).x-20))/2
//                                , ((nodes.get(e.i).y-20) + (nodes.get(e.j).y-20))/2);
            
	}

	for (Node n : nodes) {
            
	    g.setColor(Color.WHITE);
	    g.fillOval(n.x-width/2, n.y-height/2,                       // fill the oval
		       width, height);
            
	    g.setColor(Color.blue);
            
	    g.drawOval(n.x-width/2, n.y-height/2,                       // draw outline
		       width, height);
	    
	    g.drawString(n.name, n.x-f.stringWidth(n.name)/2,
			 n.y+f.getHeight()/2);
	}
        
        for(triangle t : tri){
            g.setColor(Color.RED);
            g.fillPolygon(t.x, t.y, t.n);
            g.setColor(Color.yellow);
            g.drawPolygon(t.x, t.y, t.n);
            
        }
    }
}
