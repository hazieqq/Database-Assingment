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
public class Point {
    private int numFood,totalKangarooCanFit;
    Point Link;

    public Point(int numFood, int totalKangarooCanFit) {
        this.numFood = numFood;
        this.totalKangarooCanFit = totalKangarooCanFit;
        Link=null;
    }

    public int getNumFood() {
        return numFood;
    }

    public void setNumFood(int numFood) {
        this.numFood = numFood;
    }

    public int getTotalKangarooCanFit() {
        return totalKangarooCanFit;
    }

    public void setTotalKangarooCanFit(int totalKangarooCanFit) {
        this.totalKangarooCanFit = totalKangarooCanFit;
    }

    public Point getLink() {
        return Link;
    }

    public void setLink(Point Link) {
        this.Link = Link;
    }
    
    public String toString(){
        return " : "+" f :"+numFood +  " i :"+totalKangarooCanFit;
    }
}
