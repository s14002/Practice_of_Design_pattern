package jp.ac.it_college.std.s14002.pdp.composite;

/**
 * Created by s14002 on 15/06/11.
 */
public class File extends Entry {
    private  String name;
    private  int size;
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);

    }
}
