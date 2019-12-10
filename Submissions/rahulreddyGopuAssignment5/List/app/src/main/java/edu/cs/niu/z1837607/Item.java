
package edu.cs.niu.z1837607;

public class Item {
    private int id,flag;
    private String name;
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
        this.flag = 0;
    }
    public Item(int id, String name, int flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString()
    {
        return id + " " + name ;
    }
}
