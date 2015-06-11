package jp.ac.it_college.std.s14002.pdp.visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by s14002 on 15/06/11.
 */
public class Directory extends Entry {
    private String name;
    private ArrayList<Entry> dir  = new ArrayList<>();
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
        for (Entry entry : dir) {
            size += entry.getSize();
        }
        return size;
    }
    public Entry add(Entry entry) {
        dir.add(entry);
        return this;
    }
    public Iterator<Entry> iterator() {
        return dir.iterator();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
