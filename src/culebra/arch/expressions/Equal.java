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
public class Equal 
implements Expr {
    private Expr    e1 = null, e2 = null;

    public Equal(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    public Object getValue() {
        return new IntegerExpr(e1.comparesTo(e2));
    }

    public boolean getBoolValue() {
        boolean ret = false;

        if (e1.comparesTo(e2) == 0)
            ret = true;
        else
            ret = false;

        return ret;
    }

    public int comparesTo(Object obj) {
        boolean t1 = false, t2 = false;
        int ret = 0;

        t1 = this.getBoolValue();
        t2 = ((Expr)obj).getBoolValue();

        if (t1 == t2)
            ret = 0;
        else if (t1 == true)
            ret = 1;
        else if (t1 = false)
            ret = -1;
        
        return ret;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object divide(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isVariable() {
        return false;
    }
}
