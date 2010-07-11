/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences;

import culebra.arch.Expr;
import culebra.arch.ReturnObject;
import culebra.arch.Sentence;
import culebra.arch.expressions.IntegerExpr;
import culebra.arch.expressions.StringExpr;
import culebra.arch.variable.ProxyVariable;
import culebra.arch.variable.SimpleVariable;
import culebra.arch.variable.Variable;
import culebra.arch.variable.behaviour.VarField;
import culebra.arch.variable.storage.RAMStorage;
import culebra.arch.variable.storage.Storage;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Gabriel Gonzalez
 */
public class FunctionCall 
extends Sentence
implements Expr {
    Function    function = null;
    List        arguments = null;
    
    public ReturnObject exec() {
        ListIterator    iterVarDest = function.getArguments().listIterator();
        ListIterator    iterArgs = arguments.listIterator();
        
        while (iterArgs.hasNext()) {
            Object o =  iterArgs.next();
            ProxyVariable var = (ProxyVariable) iterVarDest.next();

            if (o instanceof Expr && !(o instanceof Variable)) {
                Variable v = new SimpleVariable(new VarField(var.getName()));
                Storage sto = new RAMStorage();
                v.addStorage(sto);
                v.setValue(((Expr)o).getValue());
                var.setVariable(v);
             } else if (o instanceof Variable) {
                var.setVariable((Variable)o);
            }
        }
        
        return function.exec();
    }

    public List getArguments() {
        return arguments;
    }

    public void setArguments(List arguments) {
        this.arguments = arguments;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public boolean getBoolValue() {
        ReturnObject    ret = this.exec();

        return ret.getBoolValue();
    }

    public Object getValue() {
        ReturnObject    ret = this.exec();

        return ret.getValue();
    }

    public int comparesTo(Object obj) {
        return ((Expr)this.getValue()).comparesTo(obj);
    }

    public Object add(Object obj) {
        return ((Expr)this.getValue()).add(obj);
    }

    public Object add(StringExpr obj) {
        return ((Expr)this.getValue()).add(obj);
    }

    public Object add(IntegerExpr obj) {
        return ((Expr)this.getValue()).add(obj);
    }

    public Object substract(Object obj) {
        return ((Expr)this.getValue()).substract(obj);
    }

    public Object multiply(Object obj) {
        return ((Expr)this.getValue()).multiply(obj);
    }

    public Object divide(Object obj) {
        return ((Expr)this.getValue()).divide(obj);
    }

    // return true; since ReturnObject always return a variable because:
    // 1. The returned object is a variable
    // 2. The Expr returned is wrapped into a variable
    public boolean isVariable() {
        return true;
    }

}
