/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @IzzatFC
 */
public class Main {

    /**
     * 
     */
    public static GUI frame = new GUI("Kangaroo");
    public static Scanner input=new Scanner(System.in);
    public static Graph<String,Integer> graph=new Graph<>();
    public static int colony;
    public static Random rand=new Random();
    public static String isp[];
    public static String afim[];
    
    public static void main(String[] args) {
        System.out.println("  /     /\\     /\\    /  ----    /\\     __     ___      ____\n"
                +         " / /   /--\\   /  \\  /  |___ |  /--\\   / _|  |     |   |     |\n"
                +        "/  \\  /    \\ /    \\/    ___ | /    \\ /  \\   | ___ |   | ___ |");
        System.out.println("Press enter to continue....");
        String s;
        do {
            s = input.nextLine();
        } while (!s.equals(""));
        System.out.println("Enter  number of points/nodes/vertices");
        int point=input.nextInt();                                                       // number of point in the graph
        afim=new String[point];                                                         //a=represent ID at the point,f=number of food available at that point,
                                                                                       //i=how many kangaroo the point can fit,m=number of path connected
        String ah,userInput;                                                          //a=represent ID at the point,h=height of the obstacle
        int c=0,index1=0;
        input.nextLine();
        // User Input //
        System.out.println("Enter ID of the point, number of food available at that point,"
                + " how many kangaroo the point can fit, number of path connected to that point");
        while(true){
            
            userInput=input.nextLine();
            if(userInput.equalsIgnoreCase(" ")){
                index1++;
                c++;
                if(c!=point){
                    System.out.println("Enter ID of the point, number of food available at that point,"
                    + " how many kangaroo the point can fit, number of path connected to that point");
                }
            }
            else
            {
                afim[index1]=userInput;
                String split1[]=afim[index1].split(" ");
                if(Integer.parseInt(split1[3])==0){
                    addVertice(" ",split1[0]);
                    System.out.println("Press space and enter");
                }else{
                    System.out.println("Enter ID of path connected and height of the wall");
                    for(int i=0;i<Integer.parseInt(split1[3]);i++){
                        ah=input.nextLine();
                        addVertice(ah,split1[0]); 
                        addEdge(ah,split1[0]);
                    }
                    System.out.println("Press space and enter");
                }
            }
            if(c==point){
                break;
            }
        }
        
        //kangaroo part declaration :-
        
        System.out.println("Enter number of Kangaroo");
        int numKangaroo;
        numKangaroo=input.nextInt();
        input.nextLine();
        isp=new String[numKangaroo];         
        
        // i=point where kangaroo start,s=gender,p=porch size
        
        System.out.println("Enter details of the kangaroo: ID of the point where kangaroo started,gender, porch size");
        for(int i=0;i<isp.length;i++){
            isp[i]=input.nextLine();
        }
        
        //addkangaroo details to graph
        
        for(int i=0;i<isp.length;i++){
            String str[]=isp[i].split(" ");
            graph.addKangaroo(str[0],str[1], Integer.parseInt(str[2]));
        }
        
        //add point details to graph
        
        for(int i=0;i<afim.length;i++){
            String str[]=afim[i].split(" ");
            graph.addPointDetails(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
        }
        // kangaroo in total to form colony
        
        System.out.println("Enter thresHold colony ");
        colony=input.nextInt();
        
        // set the size of frame 
        
        frame.setSize(3000,2800);
        frame.setBackground(Color.BLACK);
	frame.setVisible(true);
        
        GraphNode currentNode=graph.head;
        ArrayList<String> Node=graph.getNode();
        int sum;
        for(int i=0;i<Node.size();i++){
            Kangaroo kangarooNode=currentNode.getKangaroolink();
            System.out.println("Range of x  200<= x <=1800  &&   Range of y  200<= y <=800");
            System.out.println("Input value x to plot graph");
            int x=input.nextInt();
            System.out.println("Input value y to plot graph");
            int y=input.nextInt();
            frame.addNode(Node.get(i), x, y);
            int value1=50;
            int value2=100;
            if(kangarooNode!=null){
                sum=graph.totalKangaroo(kangarooNode);
                for(int j=0;j<sum;j++){
                    
                    if(j<8){
                    int z[]={x-50,x-100,x-70};
                    int w[]={y-value1,y-value2,y-value2};
                    frame.addTriangle(z, w, 3);
                    value1=value1-20;
                    value2=value2-20;
                    }
                    
                    if(j>=8){
                        if(j==8){
                            value1=50;
                            value2=100;
                        }
                        int zz[]={x+30,x+80,x+50};
                        int ww[]={y-value1,y-value2,y-value2};
                        frame.addTriangle(zz, ww, 3);
                        value1=value1-20;
                        value2=value2-20;
                    }
                }
            }
            currentNode=currentNode.getVerticeLink();
        }
        currentNode=graph.head;
        ArrayList<String> edge;
        while(currentNode!=null){
            Edge edgeNode=currentNode.getEdgeLink();
            edge=graph.getEdge(currentNode);
            if(edge!=null){
                for(int i=0;i<edge.size();i++){
                    frame.addEdge(Integer.parseInt((String) currentNode.getVertice())-1, Integer.parseInt(edge.get(i))-1,edgeNode.getWeight());
                    edgeNode=edgeNode.getEdgeLink();
                }
                for(int i=0;i<edge.size();i++){
                    edge.remove(i);
                }
            }
            currentNode=currentNode.getVerticeLink();
        }
        System.out.println();
        System.out.println("Initial");
        graph.showGraph();
        graph.collectFood();
        System.out.println("-------------------------------");
        System.out.println("After collect Food");
        graph.showGraph();
        
        kangaroo();
    }
    
    public static void addVertice(String ah, String vertice) {
        if(!ah.equalsIgnoreCase(" ")){
            String split[]=ah.split(" ");
            if(!graph.isMarked(vertice)){
                graph.addVertice(vertice);
                graph.markVertice(vertice);
            }
            if(!graph.isMarked(split[0])){
                graph.addVertice(split[0]);
                graph.markVertice(split[0]);
            }
        }else{
            if(!graph.isMarked(vertice)){
                graph.addVertice(vertice);
                graph.markVertice(vertice);
            }
        }
    }

    public static void addEdge(String ah, String vertice) {
        String split[]=ah.split(" ");
        int height=Integer.parseInt(split[1]);
        graph.addEdge(vertice, split[0], height);     
                        //from   //to
        graph.addEdge(split[0], vertice, height+2);//+new Random().nextInt(3)+1);
                      //to   //from
    }
    
    public static void kangaroo() {
        GraphNode currentNode=graph.head;
        GraphNode migrateNode;
        Kangaroo kangarooNode;
        kangarooNode=currentNode.getKangaroolink();
        Edge edgeNode;
        int c=0;
        while(true){
            c++;
            edgeNode=currentNode.getEdgeLink();
            if(kangarooNode!=null && kangarooNode.getGender().equalsIgnoreCase("M")){
                if(edgeNode!=null){
                    migrateNode=graph.highestFood(edgeNode);                                                 // check highest food
                    if(migrateNode==null){
                        migrateNode=graph.highestFemale(edgeNode);                                        // check highest female
                        if(migrateNode!=null){
                            checkMigrateNode(currentNode,kangarooNode,migrateNode,edgeNode);
                        }
                    }
                    else{
                        if(migrateNode.getPointLink().getNumFood()>=currentNode.getPointLink().getNumFood()){
                            checkMigrateNode(currentNode,kangarooNode,migrateNode,edgeNode);
                        }
                    }
                }
            }
            System.out.println("---------------------------------------------");
            System.out.println("                Graph                        ");
            System.out.println("---------------------------------------------");
            graph.showGraph();
            if(kangarooNode!=null){
                kangarooNode=kangarooNode.getLink();
            }
            else{
                if(currentNode.getVerticeLink()!=null){
                    currentNode=currentNode.getVerticeLink();
                    kangarooNode=currentNode.getKangaroolink();
                }
                else{
                    currentNode=graph.head;
                    kangarooNode=currentNode.getKangaroolink();
                }
            }
            if(c==100){
                break;
            }
        }
        
        currentNode=graph.head;
        int total=0,index=0;
        System.out.println("---------------------------------------------");
        System.out.print("Number of Colonies : ");
        ArrayList<Kangaroo> list;
        int numKangarooInColony[]=new int[100];
        for(int i=0;i<numKangarooInColony.length;i++){
            numKangarooInColony[i]=0;
        }
        while(currentNode!=null){
            Colony colonyNode=currentNode.getColonyLink();
            if(colonyNode!=null){
                total+=graph.totalColony(colonyNode);
            }
            while(colonyNode!=null){
                list=colonyNode.getList();
                numKangarooInColony[index]=list.size();
                colonyNode=colonyNode.getLink();
                index++;
            }
            currentNode=currentNode.getVerticeLink();
        }
        System.out.println(total);
        for(int i=0;i<numKangarooInColony.length;i++){
            if(numKangarooInColony[i]!=0){
                System.out.println(numKangarooInColony[i]+" ");
            }
        }
        System.out.println();
        System.out.println();
        currentNode=graph.head;
        int sum=0;
        System.out.print("Number of remaining kangaroo: ");
        while(currentNode!=null){
            kangarooNode=currentNode.getKangaroolink();
            if(kangarooNode!=null){
                sum+=graph.totalKangaroo(kangarooNode);
            }
            currentNode=currentNode.getVerticeLink();
        }
        System.out.println(sum);
        currentNode=graph.head;
        while(currentNode!=null){
            kangarooNode=currentNode.getKangaroolink();
            while(kangarooNode!=null){
                System.out.println(kangarooNode.getID() +" "+ kangarooNode.getGender() +" "+ kangarooNode.getStore());
                kangarooNode=kangarooNode.getLink();
            }
            currentNode=currentNode.getVerticeLink();
        }
        
    }

    public static void checkMigrateNode(GraphNode currentNode, Kangaroo kangarooNode, GraphNode migrateNode,Edge edgeNode) {
        int foodNeeded=graph.foodNeeded(kangarooNode, currentNode,migrateNode);
        int foodAtMigratePoint=migrateNode.getPointLink().getNumFood();
        if(foodNeeded<=foodAtMigratePoint){                                                  //check food>energy needed
            migration(migrateNode,kangarooNode,currentNode,foodNeeded);                   
        }else
            if(foodAtMigratePoint+kangarooNode.getStore()>=foodNeeded){
                migration1(migrateNode,kangarooNode,currentNode,foodNeeded);
            }
        else{
                migrateNode=graph.highestFemale(edgeNode);
                foodNeeded=graph.foodNeeded(kangarooNode, currentNode,migrateNode);
                if(foodNeeded<=kangarooNode.getStore()){
                    migrationBecauseOfFemale(migrateNode,kangarooNode,currentNode);
                }
        }
            
    }
    
    public static void migration1(GraphNode migrateNode, Kangaroo kangarooNode,GraphNode currentNode,int food){
        Colony colonyNode=migrateNode.getColonyLink();
        Kangaroo node,Node;
        int balanced,size,balancedPorch;
        ArrayList<Kangaroo> List;
        Kangaroo otherKangarooNode=migrateNode.getKangaroolink();
        int totalKangarooAtMigrateNode=graph.totalKangaroo(otherKangarooNode);
        int maxTotalKangarooAtMigrateNode=migrateNode.getPointLink().getTotalKangarooCanFit();
        if(colonyNode==null){
             if(totalKangarooAtMigrateNode<maxTotalKangarooAtMigrateNode && graph.totalKangaroo(migrateNode.getKangaroolink())!=colony){
                 kangarooNode.setID((String) migrateNode.getVertice());
                 balancedPorch=(kangarooNode.getStore())-(food-migrateNode.getPointLink().getNumFood());
                 kangarooNode.setStore(balancedPorch);
                 node=new Kangaroo(kangarooNode.getID(),kangarooNode.getGender(),kangarooNode.getStore(),kangarooNode.getPorch(),null);
                 balanced=food-migrateNode.getPointLink().getNumFood();
                 migrateNode.getPointLink().setNumFood(balanced);
                 if(kangarooNode.getStore()!=kangarooNode.getPorch()){                          //store food after migrate
                    graph.storeFoodAfterMigrate(kangarooNode,migrateNode);
                }
                if(otherKangarooNode!=null){
                    graph.deleteKangaroo(kangarooNode, currentNode);
                    while(otherKangarooNode.getLink()!=null){
                        otherKangarooNode=otherKangarooNode.getLink();
                    }
                    otherKangarooNode.setLink(node);
                }
                else{
                    graph.deleteKangaroo(kangarooNode, currentNode);
                    migrateNode.setKangaroolink(node);
                }
            }
            if(graph.totalKangaroo(migrateNode.getKangaroolink())==colony){
                ArrayList<Kangaroo> list=new ArrayList<>();
                Node=migrateNode.getKangaroolink();
                while(Node!=null){
                    list.add(Node);
                    Node=Node.getLink();
                }
                otherKangarooNode=migrateNode.getKangaroolink();
                while(otherKangarooNode!=null){
                    otherKangarooNode.setStore(0);
                    graph.deleteKangaroo(otherKangarooNode, migrateNode);                                           //delete
                    otherKangarooNode=otherKangarooNode.getLink();
                }
                Colony newcolonyNode=new Colony(list,null);
                migrateNode.setColonyLink(newcolonyNode);
                
            }
        }else{
            while(colonyNode!=null){
                List=colonyNode.getList();
                size=List.size();
                int store=kangarooNode.getStore();
                if(store>=size){
                    graph.deleteKangaroo(kangarooNode, currentNode);
                    kangarooNode.setStore(store-size);
                    List.add(kangarooNode);
                    break;
                }
                else
                    colonyNode=colonyNode.getLink();
            }
        }
        
    }
                                               
    public static void migration(GraphNode migrateNode, Kangaroo kangarooNode,GraphNode currentNode,int food) {
        Colony colonyNode=migrateNode.getColonyLink();
        Kangaroo node,Node;
        int balanced,size;
        ArrayList<Kangaroo> List;
        Kangaroo otherKangarooNode=migrateNode.getKangaroolink();
        int totalKangarooAtMigrateNode=graph.totalKangaroo(otherKangarooNode);
        int maxTotalKangarooAtMigrateNode=migrateNode.getPointLink().getTotalKangarooCanFit();
        if(colonyNode==null){
            if(totalKangarooAtMigrateNode<maxTotalKangarooAtMigrateNode && graph.totalKangaroo(migrateNode.getKangaroolink())!=colony){
                kangarooNode.setID((String) migrateNode.getVertice());
                balanced=migrateNode.getPointLink().getNumFood()-food;
                node=new Kangaroo(kangarooNode.getID(),kangarooNode.getGender(),kangarooNode.getStore(),kangarooNode.getPorch(),null);
                
                migrateNode.getPointLink().setNumFood(balanced);
                
                if(kangarooNode.getStore()!=kangarooNode.getPorch()){                                           //store food after migrate
                    graph.storeFoodAfterMigrate(kangarooNode,migrateNode);
                }
                if(otherKangarooNode!=null){
                    graph.deleteKangaroo(kangarooNode, currentNode);
                    while(otherKangarooNode.getLink()!=null){
                        otherKangarooNode=otherKangarooNode.getLink();
                    }
                    otherKangarooNode.setLink(node);
                }
                else{
                    graph.deleteKangaroo(kangarooNode, currentNode);
                    migrateNode.setKangaroolink(node);
                }
            }
            if(graph.totalKangaroo(migrateNode.getKangaroolink())==colony){
                ArrayList<Kangaroo> list=new ArrayList<>();
                Node=migrateNode.getKangaroolink();
                while(Node!=null){
                    list.add(Node);
                    Node=Node.getLink();
                }
                otherKangarooNode=migrateNode.getKangaroolink();
                while(otherKangarooNode!=null){
                    otherKangarooNode.setStore(0);
                    graph.deleteKangaroo(otherKangarooNode, migrateNode);                                           //delete
                    otherKangarooNode=otherKangarooNode.getLink();
                }
                Colony newcolonyNode=new Colony(list,null);
                migrateNode.setColonyLink(newcolonyNode);
                
            }
        }//colony !=null
        else{
            int check=0;
            while(colonyNode!=null){
                List=colonyNode.getList();
                size=List.size();
                int store=kangarooNode.getStore();
                if(store>=size){
                    graph.deleteKangaroo(kangarooNode, currentNode);
                    kangarooNode.setStore(store-size);
                    List.add(kangarooNode);
                    break;
                }
                else
                    colonyNode=colonyNode.getLink();
            }
        }
    }
    
    public static void migrationBecauseOfFemale(GraphNode migrateNode, Kangaroo kangarooNode,GraphNode currentNode){
        if(migrateNode==null){
            return;
        }
        int foodNeeded=graph.foodNeeded(kangarooNode, currentNode,migrateNode);
        int size,balancedPorch;
        ArrayList<Kangaroo> List;
        Colony colonyNode=migrateNode.getColonyLink();
        Kangaroo node,Node;
        Kangaroo otherKangarooNode=migrateNode.getKangaroolink();
        int totalKangarooAtMigrateNode=graph.totalKangaroo(otherKangarooNode);
        int maxTotalKangarooAtMigrateNode=migrateNode.getPointLink().getTotalKangarooCanFit();
        if(colonyNode==null){
            if(totalKangarooAtMigrateNode<maxTotalKangarooAtMigrateNode && graph.totalKangaroo(migrateNode.getKangaroolink())!=colony){
                balancedPorch=kangarooNode.getStore()-foodNeeded;
                if(otherKangarooNode!=null){
                    graph.deleteKangaroo(kangarooNode, currentNode);
                    while(otherKangarooNode.getLink()!=null){
                        otherKangarooNode=otherKangarooNode.getLink();
                    }
                    kangarooNode.setID((String) migrateNode.getVertice());
                    kangarooNode.setStore(balancedPorch);
                    node=new Kangaroo(kangarooNode.getID(),kangarooNode.getGender(),kangarooNode.getStore(),kangarooNode.getPorch(),null);
                    otherKangarooNode.setLink(node);
                }else{
                    graph.deleteKangaroo(kangarooNode, currentNode);
                    kangarooNode.setID((String) migrateNode.getVertice());
                    kangarooNode.setStore(balancedPorch);
                    node=new Kangaroo(kangarooNode.getID(),kangarooNode.getGender(),kangarooNode.getStore(),kangarooNode.getPorch(),null);
                    migrateNode.setKangaroolink(node);
                }
            }
            if(graph.totalKangaroo(migrateNode.getKangaroolink())==colony){
                ArrayList<Kangaroo> list=new ArrayList<>();
                Node=migrateNode.getKangaroolink();
                while(Node!=null){
                    list.add(Node);
                    Node=Node.getLink();
                }
                otherKangarooNode=migrateNode.getKangaroolink();
                while(otherKangarooNode!=null){
                    otherKangarooNode.setStore(0);
                    graph.deleteKangaroo(otherKangarooNode, migrateNode);
                    otherKangarooNode=otherKangarooNode.getLink();
                }
                Colony newcolonyNode=new Colony(list,null);
                migrateNode.setColonyLink(newcolonyNode);
            }
        }else{
            while(colonyNode!=null){
                List=colonyNode.getList();
                size=List.size();
                int store=kangarooNode.getStore();
                if(store>=size){
                    graph.deleteKangaroo(kangarooNode, currentNode);
                    kangarooNode.setStore(store-size);
                    List.add(kangarooNode);
                    break;
                }
                else
                    colonyNode=colonyNode.getLink();
            }
        }
    }
}
