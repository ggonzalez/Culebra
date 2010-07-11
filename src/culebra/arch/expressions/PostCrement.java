/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// Have a look to ++/-- when they perform the increment
package culebra.arch.expressions;

import culebra.arch.Expr;
import culebra.arch.variable.SimpleVariable;
import culebra.arch.variable.Variable;

/**
 *
 * @author Gabriel
 */
public class PostCrement
implements Expr {
    private Expr            e = null;
    private IntegerExpr     sum = null;

    public PostCrement(Expr e, int s) {
        this.e = e;
        this.sum = new IntegerExpr(s);
    }
    public boolean getBoolValue() {
        return ((Expr)this.getValue()).getBoolValue();
    }

    public Object getValue() {
        Object  ret = null;

        //if (e instanceof SimpleVariable) {
            ret = ((Expr)e.getValue()).add(sum);
            //System.out.println("ret " + ret);
            ((Variable)e).setValue(ret);
        //} else
        //    ret = ((Expr)e.getValue()).add(sum);
        //System.err.println("=========> " + this.e);
        return ret;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object multiply(Object obj) {
        return ((Expr)this.getValue()).multiply(obj);
    }

    public Object divide(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isVariable() {
        return false;
    }
}
