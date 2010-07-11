/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.expressions;

import culebra.arch.Expr;

/**
 *
 * @author Gabriel Gonzalez
 */
public class FloatExpr 
implements Expr {
    Float   flt = null;
    
    public FloatExpr(String f) {
        flt = Float.valueOf(f);
    }
    
    public Object getValue() {
        return flt;
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
