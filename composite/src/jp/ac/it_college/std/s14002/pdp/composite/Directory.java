package jp.ac.it_college.std.s14002.pdp.composite;

import java.util.ArrayList;

/**
 * Created by s14002 on 15/06/11.
 */
public class Directory extends Entry {
    private String name;
    private ArrayList<Entry> directory = new ArrayList<>();
    public Directory(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }
    public Entry add(Entry entry) {
        directory.add(entry);
        return  this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }
}
