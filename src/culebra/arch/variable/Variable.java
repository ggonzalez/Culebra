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
    private     String      name        = null;
    protected   List        l           = null;
    protected   List        storageList = null;
    protected   boolean     behaviour   = false;

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

    public void addStorage(Storage st) {
        storageList.add(st);
    }

    public void addAllStorage(List l) {
        storageList.addAll(l);
    }

    public Variable getVariable() {
        return this;
    }

    abstract public Iterator    iterator(VarAttr va);

    abstract public Iterator    iterator();
        
    abstract public void        setValue(Object value);

    abstract public Object      getValue();

    abstract public void        flush();
    
    abstract public Variable    getVariable(String name);

    abstract public boolean     containsVariable(String name);

    abstract public boolean     hasVariable(List idList);

    abstract public Variable    getVariable(List ids);
        
    public boolean equals(Variable var) {
        return this.name.equals(var.getName());
    }
    
    public boolean equals(String var) {
        return this.name.equals(var);
    }
}
