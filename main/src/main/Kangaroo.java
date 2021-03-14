
package main;


public class Kangaroo  {
    private String ID,gender;
    private int porch;
    private Kangaroo link;
    private boolean check;
    private int store;

    public Kangaroo(String ID, String gender,int store ,int porch,Kangaroo link ){//String age) {
        this.ID = ID;
        this.gender = gender;
        this.porch = porch;
        this.store=store;
        this.link=link;
        check=false;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPorch() {
        return porch;
    }

    public void setPorch(int porch) {
        this.porch = porch;
    }

    public Kangaroo getLink() {
        return link;
    }

    public void setLink(Kangaroo link) {
        this.link = link;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }
    
    
    public String toString(){
        return "Kangaroo : "+" ( "+ID + " " + gender + " " +store +" "+porch+" ) "+" -> ";
    }
}
