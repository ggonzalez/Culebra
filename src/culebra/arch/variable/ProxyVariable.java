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
 * @author Gabriel
 */
public class ProxyVariable
extends Variable {
    protected Variable pVariable = null;

    public ProxyVariable(String name) {
        super(name);
    }
    
    public void setVariable(Variable var) {
        this.pVariable = var;
    }

    @Override
    public Variable getVariable() {
        return this.pVariable.getVariable();
    }

    @Override
    public boolean isBehaviour() {
        return this.pVariable.isBehaviour();
    }


    @Override
    public void setValue(Object value) {
        this.pVariable.setValue(value);
    }

    @Override
    public Object getValue() {
        if (this.pVariable != null)
            return this.pVariable.getValue();
        else
            return null;

    }

    @Override
    public void flush() {
        this.pVariable.flush();
    }

    @Override
    public Variable getVariable(String name) {
        return this.pVariable.getVariable(name);
    }

    @Override
    public boolean containsVariable(String name) {
        return this.pVariable.containsVariable(name);
    }

    @Override
    public Iterator iterator() {
        return this.pVariable.iterator();
    }

    @Override
    public Iterator iterator(VarAttr va) {
        return this.pVariable.iterator(va);
    }

    public boolean getBoolValue() {
        return this.pVariable.getBoolValue();
    }

    public int comparesTo(Object obj) {
        return this.pVariable.comparesTo(obj);
    }

    public Object add(Object obj) {
        return this.pVariable.add(obj);
    }

    public Object substract(Object obj) {
        return this.pVariable.substract(obj);
    }

    public Object multiply(Object obj) {
        return this.pVariable.multiply(obj);
    }

    public Object divide(Object obj) {
        return this.pVariable.divide(obj);
    }

    public Object add(StringExpr obj) {
        return this.pVariable.add(obj);
    }

    public Object add(IntegerExpr obj) {
        return this.pVariable.add(obj);
    }

    public boolean isVariable() {
        return this.pVariable.isVariable();
    }


    @Override
    public boolean hasVariable(List idList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Variable getVariable(List ids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
