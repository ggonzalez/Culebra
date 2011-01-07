/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage;

import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.iterator.ListIterator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class ListStorage 
implements Storage {
    private LinkedList  l = null;
    private VarAttr     varAttr = null;
    
    public ListStorage() {
        this.l = new LinkedList();
    }

    public Object getValue() {
        return this.l.getLast();
    }

    public void setValue(Object obj) {
        this.l.add(obj);
    }

    public Iterator getIterator() {
        return this.l.iterator();
    }

    public Iterator iterator() {
        return new ListIterator(this);
    }

    public Iterator iterator(List args) {
        return this.iterator();
    }

    public void flush() {
    }

    public void setVarAttr(VarAttr va) {
        this.varAttr = va;
    }

    public VarAttr getVarAttr() {
        return this.varAttr;
    }

    public Iterator iterator(Map tmp) {
        return this.iterator();
    }

    public boolean isEOF() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator iterator(Map tmp, VarAttr va) {
        return this.iterator();
    }

    public Object getValue(String val) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
