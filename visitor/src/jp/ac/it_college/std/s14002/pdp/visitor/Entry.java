package jp.ac.it_college.std.s14002.pdp.visitor;

import jp.ac.it_college.std.s14002.pdp.composite.FileTreatmentException;

import java.util.Iterator;

/**
 * Created by s14002 on 15/06/11.
 */
public abstract class Entry implements Element {
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public Iterator<Entry> iterator() throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public String toString() {
        return  getName() + " (" +  getSize() + ")";
    }
}
