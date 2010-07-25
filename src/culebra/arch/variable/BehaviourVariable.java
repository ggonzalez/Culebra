/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable;

import culebra.arch.expressions.IntegerExpr;
import culebra.arch.expressions.StringExpr;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.Storage;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Gabriel
 */
public class BehaviourVariable
extends Variable {
    private Map     variables = null;

    public BehaviourVariable(String name) {
        super(name);
        this.behaviour = true;
        /*StorageFactory sf = StorageFactory.getFactory(dB);

        if (dB.isParamListEmpty())
        varStorage = sf.createStorage();
        else
        varStorage = sf.createStorage(dB.getParamList());*/
    }

    public void setVariables(Map m) {
        this.variables = m;
    }
    public Map getVariables() {
        return this.variables;
    }
    public boolean containsVariable(String v) {
        return this.variables.containsKey(v);
    }

    
    public Variable getVariable(String v) {
        return (Variable) this.variables.get(v);
    }

    public void setVariable(Variable var, String name) {
        this.variables.put(name, var);
    }

    public void setField(Variable var) {
        this.variables.put(var.getName(), var);
    }

    @Override
    public Iterator iterator() {
        return ((Storage)this.storageList.get(0)).iterator(this.getVariables());
    }
    @Override
    public Iterator iterator(VarAttr va) {
        return ((Storage)this.storageList.get(0)).iterator(this.getVariables(), va);
    }

    @Override
    public boolean searchValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // XXX: what to do if several invariables and test = k
    // XXX: If test {} is a text one, assign a string using defult delim, or builtin regex
    // XXX: If test {} is a text one, and test = test2; compose string and assign as above
    // XXX: else compare Maps
    @Override
    public void setValue(Object value) {
        System.out.println(this.getName() + " " + value);
        Iterator    iter = this.variables.values().iterator();
        while (iter.hasNext()) {
            ProxyVariable    var = (ProxyVariable) iter.next();
            var.setVariable((Variable) value);
        }
        this.flush();
    }

    @Override
    public Object getValue() {
        //return this.variables;
        return this;
    }

    @Override
    public void flush() {
        Iterator    iter = this.storageList.iterator();
        //System.out.println("BehaviourVariable flush");
        while (iter.hasNext()) {
            Storage st = (Storage) iter.next();
            
            st.setValue(this.variables);
        }
        
        this.variables = BehaviourVariable.duplicateVariables(this.variables);
    }

    static public Map duplicateVariables(Map m) {
        Map ret = new LinkedHashMap();
        
        Set keys = m.keySet();
        Iterator iter = keys.iterator();
        
        while (iter.hasNext()) {
            String  tmp = (String) iter.next();
//            VarField    varTmp = ((SimpleVariable)m.get(tmp)).getVarField();
//            SimpleVariable  var = new SimpleVariable(varTmp);
//            var.addStorage(new RAMStorage());
            ProxyVariable   pv = new ProxyVariable(tmp);
            ret.put(tmp, pv);
        }
        
        return ret;
    }

    public boolean getBoolValue() {
        //XXX Not sure what to return
        return true;
    }

    public int comparesTo(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(Object obj) {
        StringExpr ret = new StringExpr(this.toString());

        return ret.add(obj);
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

    @Override
    public String toString() {
        Iterator    iter = this.variables.values().iterator();
        String      ret = "";

        while (iter.hasNext()) {
            Variable var = (Variable) iter.next();

            ret += var.getValue();

            if (iter.hasNext()) {
                ret += ", ";
            }
        }

        return ret;
    }

    public boolean isVariable() {
        return true;
    }

    /**
     * XXX: Assuming no var nesting
     * @param value
     * @param fields Name of behaviours fields.
     */
    @Override
    public void setValue(Object value, List fields) {
        if (fields != null) {
            Iterator iter = fields.iterator();

            while (iter.hasNext()) {
                String varName = (String) iter.next();
                if (this.containsVariable(varName)) {
//System.out.println("setValue " + varName);
                    this.setVariable((Variable) value,varName);
                } else {
                    System.out.println("ERRORRRRR BV.setValue(,fields): " + varName);
                }
            }
        }
    }
}
