
package main;

import java.util.ArrayList;


public class Colony {
    ArrayList list;
    Colony link;

    public Colony(ArrayList list, Colony link) {
        this.list = list;
        this.link = link;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public Colony getLink() {
        return link;
    }

    public void setLink(Colony link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return list + " | ";
    }
    
}
