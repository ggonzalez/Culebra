/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage;

import culebra.arch.variable.behaviour.VarAttr;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class RAMStorage 
implements Storage {
    private LinkedList  l = null;
    private VarAttr     varAttr = null;

    public RAMStorage() {
        this.l = new LinkedList();
    }

    public Object getValue() {
        Object  ret = null;
        
        if (l.size() > 0)
            ret = this.l.getFirst();
        else
            ret = null;

        return ret;
    }

    public void setValue(Object obj) {
        if (l.size() != 0)
            l.removeFirst();

        this.l.add(obj);
    }

    public Iterator iterator() {
        return this.l.iterator();
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isEOF() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator iterator(Map tmp, VarAttr va) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getValue(String val) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
