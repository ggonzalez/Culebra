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
public class GreatEqual
implements Expr {
    private Expr    e1 = null, e2 = null;

    public GreatEqual(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public boolean getBoolValue() {
        boolean ret = false;
        
        if (this.e1.comparesTo(this.e2) >= 0 )
            ret = true;
        else
            ret = false;
        
        return ret;
    }

    public Object getValue() {
        return new IntegerExpr(this.e1.comparesTo(this.e2));
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
