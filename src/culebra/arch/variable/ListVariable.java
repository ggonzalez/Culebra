/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable;

import culebra.arch.expressions.IntegerExpr;
import culebra.arch.expressions.StringExpr;
import culebra.arch.variable.behaviour.VarAttr;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gabriel Gonzalez
 */
public class ListVariable 
extends Variable {
    private Object  last = null;
    
    public ListVariable(String name) {
        super(name);
    }
    
    @Override
    public Iterator iterator() {
        return l.iterator();
    }
    
    @Override
    public boolean searchValue(Object value) {
        return l.contains(value);
    }

    @Override
    public void setValue(Object value) {
        l.add(value);
        this.last = value;
    }

    @Override
    public Object getValue() {
        return this.last;
    }

    @Override
    public void flush() {
    }

    @Override
    public Variable getVariable(String name) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean containsVariable(String name) {
        return false;
    }

    @Override
    public Iterator iterator(VarAttr va) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getBoolValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int comparesTo(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object substract(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object multiply(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object divide(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(StringExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(IntegerExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isVariable() {
        return true;
    }

    @Override
    public void setValue(Object value, List fields) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
