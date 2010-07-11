/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.expressions;

import culebra.arch.Expr;
import java.math.BigInteger;

/**
 *
 * @author Gabriel Gonzalez
 */
public class Minus 
implements Expr {
    Expr    e1 = null, e2 = null;

    public Minus(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Object getValue() {
        return e1.substract(e2);
    }

    public boolean getBoolValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int comparesTo(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(Object obj) {
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

    public Object add(StringExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(IntegerExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isVariable() {
        return false;
    }
}
