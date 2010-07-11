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
public class Or
implements Expr {
    private Expr    e1 = null, e2 = null;

    public Or(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public boolean getBoolValue() {
        return this.e1.getBoolValue() || this.e2.getBoolValue();
    }

    public Object getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int comparesTo(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(StringExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(IntegerExpr obj) {
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

    public boolean isVariable() {
        return false;
    }

}
