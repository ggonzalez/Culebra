/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage;

import culebra.arch.variable.behaviour.VarAttr;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class ProxyStorage
implements Storage, TextStorage {
    private Iterator    iter = null;
    private Storage     storage = null;

    public ProxyStorage(Storage st, Iterator iter) {
        this.iter = iter;
        this.storage = st;
    }

    public Object getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setValue(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setVarAttr(VarAttr va) {
        this.storage.setVarAttr(va);
    }

    public VarAttr getVarAttr() {
        return this.storage.getVarAttr();
    }

    public void flush() {
        this.storage.flush();
    }

    public boolean isEOF() {
        return this.storage.isEOF();
    }

    public Iterator iterator() {
        return  this.iter;
    }

    public Iterator iterator(Map tmp) {
        return  this.iter;
    }

    public Iterator iterator(Map tmp, VarAttr va) {
        return  this.iter;
    }

    //XXX: Check if instance TextStorage
    public boolean isEOL() {
        return ((TextStorage)this.storage).isEOL();
    }

    public String readField() {
        return ((TextStorage)this.storage).readField();
    }

    public String readLine() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String[] readFields() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getValue(String val) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
