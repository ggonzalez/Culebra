/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable;

import culebra.arch.Expr;
import culebra.arch.Type;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.Storage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
abstract public class Variable
implements Expr {
    protected List      l = null;
    protected List      storageList = null;
    private Type        type = null;
    private String      name = null;
    private Object      value = null;
    private boolean     tmp = false;
    protected boolean     behaviour = false;

    public Variable(String name) {
        this.name = name;
        l = new LinkedList();
        storageList = new LinkedList();
    }

    public boolean isBehaviour() {
        return behaviour;
    }

    public String getName() {
        return this.name;
    }

    public boolean isTmp() {
        return tmp;
    }

    public void setTmp(boolean tmp) {
        this.tmp = tmp;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void addStorage(Storage st) {
        storageList.add(st);
    }

    public void addAllStorage(List l) {
        storageList.addAll(l);
    }

    public Variable getVariable() {
        return this;
    }
    abstract public Iterator iterator(VarAttr va);

    abstract public Iterator iterator();
    
    abstract public boolean searchValue(Object value);
    
    abstract public void setValue(Object value);// {
//        System.out.println("Variable " + name + " setValue " + value);
//        this.value = value;
//    }
    abstract public void setValue(Object value, List fields);

    abstract public Object getValue();// {
//        System.out.println("Variable " + name + " " + this.value);
//        return this.value;
//    }
    abstract public void flush();

    
    abstract public Variable getVariable(String name);

    abstract public boolean containsVariable(String name);
}
