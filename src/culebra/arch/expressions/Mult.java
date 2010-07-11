/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.expressions;

import culebra.arch.Expr;

/**
 *
 * @author Gabriel
 */
public class Mult
implements Expr {
    private Expr    e1 = null, e2 = null;

    public Mult(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public boolean getBoolValue() {
        return ((Expr)this.getValue()).getBoolValue();
    }

    public Object getValue() {
        return e1.multiply(e2);
    }

    public int comparesTo(Object obj) {
        return e1.comparesTo(e2);
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
        return ((Expr)this.getValue()).divide(obj);
    }

    public boolean isVariable() {
        return false;
    }

}
