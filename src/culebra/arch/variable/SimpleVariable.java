/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable;

import culebra.arch.Expr;
import culebra.arch.expressions.IntegerExpr;
import culebra.arch.expressions.StringExpr;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.behaviour.VarField;
import culebra.arch.variable.storage.Storage;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gabriel Gonzalez
 */
public class SimpleVariable
extends Variable {
    private Object  value = null;
    private VarField field = null;

    public SimpleVariable(String attr) {
        super(attr);
    }
    public SimpleVariable(VarField attr) {
        super(attr.getToken());
        this.field = attr;
    }

    public VarField getVarField() {
        return field;
    }
    
    @Override
    public void setValue(Object value) {
        Iterator    iter = this.storageList.iterator();
        
        while (iter.hasNext()) {
            Storage tmp = (Storage) iter.next();
            Object  val = value;

            /*if (this.field.isRegex() && (value instanceof String)) {
            String  ret = null;
            Matcher m = null;
            Pattern p = this.field.getRePattern();

            m = p.matcher((String) value);
            if (m.find()) {
            val = m.group();
            m.replaceFirst("");
            //System.out.println("DEBUG: SetValue " + (String)val + " remaining " + (String)value);
            } else {
            //System.out.println("DEBUG: NO SetValue " + (String)val);
            //XXX Do not break other casts, null doesn't make sense in texts
            val = "";
            }
            }*/
            
            tmp.setValue(val);
        }
    }

    @Override
    public Object getValue() {
        Storage tmp = (Storage) this.storageList.get(0);

        return tmp.getValue();
    }

    @Override
    public void flush() {
    }

    @Override
    public Variable getVariable(String name) {
        return  this;
    }

    @Override
    public boolean containsVariable(String name) {
        return this.equals(name);
    }

    @Override
    public Iterator iterator() {
        Storage tmp = (Storage) this.storageList.get(0);
        
        return tmp.iterator();
    }

    @Override
    public Iterator iterator(VarAttr va) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getBoolValue() {
        return ((Expr)this.getValue()).getBoolValue();
    }

    public int compareTo(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(Object obj) {
        return  ((Expr)this.getValue()).add(obj);
    }

    public Object substract(Object obj) {
        return  ((Expr)this.getValue()).substract(obj);
    }

    public Object multiply(Object obj) {
        return ((Expr)this.getValue()).multiply(obj);
    }

    public Object divide(Object obj) {
        return ((Expr)this.getValue()).divide(obj);
    }

    public Object add(StringExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int comparesTo(Object obj) {
        return ((Expr)this.getValue()).comparesTo(obj);
    }

    public Object add(IntegerExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isVariable() {
        return false;
    }

    @Override
    public boolean hasVariable(List idList) {
        if (idList.size() != 0)
            return false;
        else
            return true;
    }

    @Override
    public Variable getVariable(List ids) {
        if (ids.size() != 0)
            return null;
        else
            return this;
    }
}
