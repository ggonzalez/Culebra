/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage.iterator;

import culebra.arch.variable.BehaviourVariable;
import culebra.arch.variable.ProxyVariable;
import culebra.arch.variable.SimpleVariable;
import culebra.arch.variable.Variable;
import culebra.arch.variable.behaviour.VarField;
import culebra.arch.variable.storage.RAMStorage;
import culebra.arch.variable.storage.Storage;
import culebra.semantic.VariableManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class DBIterator
implements Iterator {
    private Storage sto = null;
    private Map     m   = null;

    public DBIterator(Storage db, Map m) {
        this.sto = db;
        this.m = m;

    }
    public boolean hasNext() {
       return !this.sto.isEOF();
    }

    public Object next() {
        Map ret = BehaviourVariable.duplicateVariables(this.m);
        
        Collection  tmpValues = ret.values();
        Iterator    iter = tmpValues.iterator();
        
        while (iter.hasNext()) {
            ProxyVariable tmp = (ProxyVariable) iter.next();
System.out.println("DBIterator next ");
            Storage st = new RAMStorage();
            Variable var = new SimpleVariable(new VarField(VariableManager.randomName()));
            var.addStorage(st);
            tmp.setVariable(var);
            tmp.setValue(this.sto.getValue(tmp.getName()));
        }
        System.out.println(ret);
        return ret;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
