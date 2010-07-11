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
public class Plus
implements Expr {   

    Expr e1 = null;
    Expr e2 = null;

    public Plus(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Object getValue() {
        return e1.add(e2);
        /*Object tmp1 = e1.getValue();
        Object tmp2 = e2.getValue();
        Object ret = null;

        if (tmp1 instanceof BigInteger){
        BigInteger  t1 = (BigInteger) tmp1;
        if (tmp2 instanceof BigInteger) {
        BigInteger  t2 = (BigInteger) tmp2;
        return t2.add(t1);
        }
        if (tmp2 instanceof String) {
        String  tmp = (String) tmp2;
        // XXX: This must change to return BigInteger
        return t1 + tmp;
        }
        }
        if (tmp1 instanceof String && tmp2 instanceof String) {
        return ((String) tmp1) + ((String) tmp2);
        }

        if (tmp1 instanceof String) {
        String  tmp = (String) tmp1;
        if (tmp2 instanceof BigInteger)
        return tmp + ((BigInteger)tmp2);
        }
        return ret;*/
    }

    public boolean getBoolValue() {
        return ((Expr)this.getValue()).getBoolValue();
    }

    public int comparesTo(Object obj) {
        return ((Expr)this.getValue()).comparesTo(obj);
    }

    public Object add(Object obj) {
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

    public Object add(StringExpr obj) {
        return ((Expr)this.getValue()).add(obj);
    }

    public Object add(IntegerExpr obj) {
        return ((Expr)this.getValue()).add(obj);
    }

    public boolean isVariable() {
        return false;
    }
}
