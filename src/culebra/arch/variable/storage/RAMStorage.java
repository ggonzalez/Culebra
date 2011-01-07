package culebra.arch.variable.storage;

import culebra.arch.variable.behaviour.VarAttr;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Stores an object in local memory.
 * 
 * @author Gabriel Gonzalez
 *
 */
public class RAMStorage 
implements Storage {
    private Object  obj = null;
    private VarAttr varAttr = null;

    public RAMStorage() {
    }

    public Object getValue() {
        return obj;
    }

    public void setValue(Object obj) {
        this.obj = obj;
    }

    public Iterator iterator() {
        throw new UnsupportedOperationException("Iterator no supported for RAM Storage");
    }

    public Iterator iterator(List args) {
        throw new UnsupportedOperationException("Iterator no supported for RAM Storage");
    }

    public void flush() {
                throw new UnsupportedOperationException("Can't flush RAM Storage yet");

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
