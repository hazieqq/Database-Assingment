/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;


/**
 *
 * @IzzatFC
 */
public class Graph<V extends Comparable<V>,E> {
    GraphNode head;
    

    public Graph() {
        head=null;
    }
    
    
    public boolean isEmpty(){
        return head==null;
    }
    
    public void clear(){
        head=null;
    }
    
    public void addVertice(V a){
        GraphNode newNode=new GraphNode(a,null);
        GraphNode currentNode=head;
        GraphNode previousNode=head;
        boolean check=false;
        if(head==null){
            head=newNode;
        }
        else{
            while(currentNode.getVerticeLink()!=null){
                previousNode=currentNode;
                currentNode=currentNode.getVerticeLink();
                if(a.compareTo((V) currentNode.getVertice())<0){
                    GraphNode newNode2=new GraphNode(a,currentNode);
                    previousNode.setVerticeLink(newNode2);
                    check=true;
                    break;
                }
            }
            if(!check){
                GraphNode newNode1=new GraphNode(a,null);
                currentNode.setVerticeLink(newNode1);
            }
        }
    } 
    
    public GraphNode hasVertice(V a){
        if(!isEmpty()){
            GraphNode currentNode=head;
            while(currentNode!=null){
                if(a.compareTo((V) currentNode.getVertice())==0){
                    return currentNode;
                }
                else
                    currentNode=currentNode.getVerticeLink();
            }
        }
            return null;
    }
    
    
    public void markVertice(V a){
        if(hasVertice(a)!=null){
            GraphNode currentNode=head;
            while(currentNode!=null){
                if(a.compareTo((V)currentNode.getVertice())==0){
                    currentNode.setMark(true);
                    return;
                }
                else
                    currentNode=currentNode.getVerticeLink();
            }
        }
    }
    
    public boolean isMarked(V a){
        if(hasVertice(a)!=null){
            GraphNode currentNode=head;
            while(currentNode!=null){
                if(a.compareTo((V)currentNode.getVertice())==0){
                    return currentNode.getMark();
                }
                else
                    currentNode=currentNode.getVerticeLink();
            }
        }
        return false;
    }
    
    public boolean addEdge(V from,V to,int weight){
        if(hasVertice(from)==null || hasVertice(to)==null){
            return false;
        }
        else{
            GraphNode currentNode=head;
            while(currentNode!=null){
                if(from.compareTo((V)currentNode.getVertice())==0){
                    GraphNode temp=hasVertice(to);
                    Edge edge=currentNode.getEdgeLink();
                    Edge newEdge=new Edge(temp,null,weight);
                    if(edge==null){
                       currentNode.setEdgeLink(newEdge);
                    }
                    else{
                        while(edge.getEdgeLink()!=null){
                            edge=edge.getEdgeLink();
                        }
                        edge.setEdgeLink(newEdge);
                    }
                    return true;
                }
                currentNode=currentNode.getVerticeLink();
            }
        }
        return false;
    }
    
    public boolean isEdge(V from,V to){
        if(hasVertice(from)==null || hasVertice(to)==null){
            return false;
        }
        else{
            GraphNode currentNode=head;
            while(currentNode!=null){
                if(from.compareTo((V)currentNode.getVertice())==0){
                    GraphNode temp=hasVertice(to);
                    Edge edge=(Edge) currentNode.getEdgeLink();
                    if(edge==null){
                        return false;
                    }
                    else
                        while(edge!=null){
                            if(edge.getVerticeLink()==temp){
                                return true;
                            }
                            edge=edge.getEdgeLink();
                        }
                }
                currentNode=currentNode.getVerticeLink();
            }
        }
        return false;
    }
    
    public boolean deleteEdge(V from,V to){
        if(!isEdge(from,to)){
            return false;
        }
        else{
            GraphNode currentNode=head;
            while(currentNode!=null){
                if(from.compareTo((V)currentNode.getVertice())==0){
                    GraphNode temp=hasVertice(to);
                    Edge edge=(Edge) currentNode.getEdgeLink();
                    Edge previousNode=null;
                    while(edge!=null){
                        if(edge.getVerticeLink()==temp){
                            if(previousNode==null){
                                currentNode.setEdgeLink(edge.getEdgeLink());
                            }
                            else{
                                previousNode.setEdgeLink(edge.getEdgeLink());
                            }
                            return true;
                        }else{
                            previousNode=edge;
                            edge=edge.getEdgeLink();
                        }
                    }
                }else
                    currentNode=currentNode.getVerticeLink();
            }
        }
        return false;
    }
    
    public int getWeight(V from,V to){
        if(isEdge(from,to)){
            GraphNode currentNode=head;
            while(currentNode!=null){
                if(from.compareTo((V)currentNode.getVertice())==0){
                    GraphNode temp=hasVertice(to);
                    Edge edge=(Edge) currentNode.getEdgeLink();
                    while(edge!=null){
                        if(edge.getVerticeLink()==temp){
                            return  edge.getWeight();
                        }
                        edge=edge.getEdgeLink();
                    }
                }
                currentNode=currentNode.getVerticeLink();
            }
        }
        return 0;
    }
    
    public ArrayList getNode(){
        ArrayList<String> Node=new ArrayList();
        GraphNode currentNode=head;
        while(currentNode!=null){
            Node.add((String) currentNode.getVertice());
            currentNode=currentNode.getVerticeLink();
        }
        return Node;
    }
    
    public ArrayList getEdge(GraphNode currentNode){
       ArrayList<String> Node=new ArrayList();
       Edge edgeNode=currentNode.getEdgeLink();
       if(edgeNode==null){
           return null;
       }
       while(edgeNode!=null){
           Node.add((String) edgeNode.getVerticeLink().getVertice());
           edgeNode=edgeNode.getEdgeLink();
       }
       return Node;
    }
    
    
    public ArrayList getAdjacent(V a){
        ArrayList<V> array=new ArrayList();
        if(hasVertice(a)!=null){
            GraphNode currentNode=head;
            while(currentNode!=null){
                if(a.compareTo((V) currentNode.getVertice())==0){
                    Edge edgeNode=(Edge) currentNode.getEdgeLink();
                    while(edgeNode!=null){
                        array.add((V) edgeNode.getVerticeLink().getVertice());
                        edgeNode=edgeNode.getEdgeLink();
                    }
                    break;
                }
                else
                    currentNode=currentNode.getVerticeLink();
            }
        }
        return array;
    }
    
    public void showGraph(){
        GraphNode currentNode=head;
        while(currentNode!=null){
            System.out.print(currentNode);
            Point detailNode=currentNode.getPointLink();
            System.out.print(detailNode);
            System.out.println();
            System.out.print("Kangaroo at node "+currentNode.getVertice()+" : ");
            Kangaroo kangarooNode=currentNode.getKangaroolink();
            while(kangarooNode!=null){
                System.out.print(kangarooNode);
                kangarooNode=kangarooNode.getLink();
            }
            System.out.println();
            System.out.print("Path connected at node "+currentNode.getVertice()+" : ");
            Edge edge=currentNode.getEdgeLink();
            while(edge!=null){
                System.out.print(edge);
                edge=edge.getEdgeLink();
            }
            System.out.println();
            System.out.print("Colony at node "+currentNode.getVertice()+" : ");
            Colony colonyNode=currentNode.getColonyLink();
            while(colonyNode!=null){
                System.out.println(colonyNode);
                colonyNode=colonyNode.getLink();
            }
            System.out.println();
            currentNode=currentNode.getVerticeLink();
        }
    }
    
    public void addKangaroo(String a,String gender,int porch){
        int store=0;
        GraphNode currentNode=head;
        while(currentNode!=null){
            if(a.compareTo((String) currentNode.getVertice())==0){
                    Kangaroo newKangaroo=new Kangaroo(a,gender,store,porch,null);
                    Kangaroo kangarooNode=currentNode.getKangaroolink();
                    if(kangarooNode==null){
                        currentNode.setKangaroolink(newKangaroo);
                    }
                    else{
                        while(kangarooNode.getLink()!=null){
                            kangarooNode=kangarooNode.getLink();
                        }
                        kangarooNode.setLink(newKangaroo);
                    }   
            }
            currentNode=currentNode.getVerticeLink();
        }
    }
    
    public void addPointDetails(String a,int f,int i){
        GraphNode currentNode=head;
        while(currentNode!=null){
            if(a.compareTo((String) currentNode.getVertice())==0){
                Point newDetail=new Point(f,i);
                currentNode.setPointLink(newDetail);
            }
            currentNode=currentNode.getVerticeLink();
        }
    }
    
    public int totalVertice(){
        int count=0;
        GraphNode currentNode=head;
        while(currentNode!=null){
            currentNode=currentNode.getVerticeLink();
            count++;
        }
        return count;
    }
    
    public void collectFood(){
        GraphNode currentNode=head;
        int totalFood,porch,balance,newStore;
        while(currentNode!=null){
            Point pointNode=currentNode.getPointLink();
            Kangaroo kangarooNode=currentNode.getKangaroolink();
            while(kangarooNode!=null){
                totalFood=pointNode.getNumFood();
                porch=kangarooNode.getPorch();
                if(totalFood!=0){
                    if(kangarooNode.getStore()==0){
                        if(totalFood<porch){
                            kangarooNode.setStore(totalFood);
                            pointNode.setNumFood(0);
                        }else{
                            kangarooNode.setStore(porch);
                            pointNode.setNumFood(totalFood-porch);
                        }
                    }else{
                        balance=porch-kangarooNode.getStore();
                        if(totalFood<balance){
                            kangarooNode.setStore(kangarooNode.getStore()+totalFood);
                            pointNode.setNumFood(0);
                        }
                        else{
                            kangarooNode.setStore(porch);
                            pointNode.setNumFood(totalFood-balance);
                        }
                    }
                }
                kangarooNode=kangarooNode.getLink();
            }
            currentNode=currentNode.getVerticeLink();
        }
    }
    
    public void storeFoodAfterMigrate(Kangaroo kangarooNode,GraphNode migrateNode){
        int totalFood,porch,balance;
        Point pointNode=migrateNode.getPointLink();
        totalFood=pointNode.getNumFood();
        porch=kangarooNode.getPorch();
        if(totalFood!=0){
            if(kangarooNode.getStore()==0){
                if(totalFood<porch){
                    kangarooNode.setStore(totalFood);
                    pointNode.setNumFood(0);
                }else{
                    kangarooNode.setStore(porch);
                    pointNode.setNumFood(totalFood-porch);
                }
            }else{
                    balance=porch-kangarooNode.getStore();
                    if(totalFood<balance){
                        kangarooNode.setStore(kangarooNode.getStore()+totalFood);
                        pointNode.setNumFood(0);
                    }
                    else{
                        kangarooNode.setStore(porch);
                        pointNode.setNumFood(totalFood-balance);
                    }
                }
        }
    }
    
    public GraphNode highestFood(Edge edgeNode){
        int maxFood=0;
        int food;
        GraphNode currentNode=head;
        GraphNode Node=null;
        while(currentNode!=null){
            if(edgeNode!=null){
                if(edgeNode.getVerticeLink()==currentNode){
                    Point pointNode=currentNode.getPointLink();
                    food=pointNode.getNumFood();
                    if(food>maxFood){
                        maxFood=food;
                        Node=currentNode;
                    }
                    edgeNode=edgeNode.getEdgeLink();
                }
            }
              currentNode=currentNode.getVerticeLink();
        }
        return Node;
    }
    
    public GraphNode highestFemale(Edge edgeNode){
        int total;
        int maxFemale=0;
        GraphNode currentNode=head;
        GraphNode Node=null;
        while(currentNode!=null){
            if(edgeNode!=null){
                if(edgeNode.getVerticeLink()==currentNode){
                    Kangaroo kangarooNode=currentNode.getKangaroolink();
                    total=0;
                    while(kangarooNode!=null){
                        if(kangarooNode.getGender().equalsIgnoreCase("F")){
                            total++;
                        }
                        kangarooNode=kangarooNode.getLink();
                    }
                    if(total>maxFemale){
                        maxFemale=total;
                        Node=currentNode;
                    }
                    edgeNode=edgeNode.getEdgeLink();
                }
            }
            currentNode=currentNode.getVerticeLink();
        }
        return Node;
    }
    
    public int foodNeeded(Kangaroo kangarooNode,GraphNode currentNode,GraphNode migrateNode){
        int height=0;
        Edge edgeNode=currentNode.getEdgeLink();
        while(edgeNode!=null){
            if(edgeNode.getVerticeLink()==migrateNode){
               height=edgeNode.getWeight();
            }
            edgeNode=edgeNode.getEdgeLink();
        }
        int food=(int) (height + (0.5 * kangarooNode.getStore()));
        return food;
    }
    
    public int totalKangaroo(Kangaroo kangarooNode){
        int count=0;
        while(kangarooNode!=null){
            count++;
            kangarooNode=kangarooNode.getLink();
        }
        return count;
    }
    
    public int totalColony(Colony colonyNode){
        int count=0;
        while(colonyNode!=null){
            count++;
            colonyNode=colonyNode.getLink();
        }
        return count;
    }
    
    
    public void deleteKangaroo(Kangaroo kangaroo,GraphNode currentNode){
        //GraphNode currentNode=head;
        Kangaroo kangarooNode=currentNode.getKangaroolink();
        Kangaroo previousKangaroo=currentNode.getKangaroolink();
        while(kangarooNode!=null){
            if(kangarooNode==kangaroo){
                if(currentNode.getKangaroolink()==kangaroo){                                  // situation 1
                    if(kangarooNode.getLink()!=null){
                        currentNode.setKangaroolink(kangarooNode.getLink());
                        System.out.println("           masukkkk              ");
                        return ;
                    }
                    else
                        currentNode.setKangaroolink(null);
                
                }else{
                        if(kangarooNode.getLink()!=null){                                       // situtation 2
                            previousKangaroo.setLink(kangarooNode.getLink());
                            return;
                        }
                        else{
                            previousKangaroo.setLink(null);
                            return ;
                        }
                }
            }
            else{
                previousKangaroo=kangarooNode;
                kangarooNode=kangarooNode.getLink();
            }
        }
    }
}
