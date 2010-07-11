/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.expressions;

import culebra.arch.Expr;
import java.math.BigInteger;

/**
 *
 * @author Gabriel
 */
public class StringExpr
implements Expr {
    String  data = null;

    public StringExpr(String data) {
        this.data = data;
    }

    public Object getValue() {
        return this;
    }

    public int comparesTo(Object obj) {
        int ret = 0;
        String  tmp = ((Expr)obj).getValue().toString();


        if (tmp.compareTo(tmp) != 0) {
            if (obj instanceof IntegerExpr) {
                BigInteger  int1 = new BigInteger(this.data);
                BigInteger  int2 = (BigInteger) ((IntegerExpr)obj).getValue();

                ret = int1.compareTo(int2);
            } else if (obj instanceof StringExpr) {
                String  t1 = this.data;
                String  t2 = (String) ((StringExpr)obj).getValue();
                t1.compareTo(t2);
            } else {
                ret =  (this.getBoolValue() == ((Expr)obj).getBoolValue()) ? 0 : 1;
            }

        }
        return ret;
    }

    @Override
    public String toString() {
        return this.data;
    }

    public boolean getBoolValue() {
        boolean ret = false;
        
        if (Integer.parseInt(this.data) == 0)
            ret = false;
        else
            ret = true;

        return ret;
    }

    public Object add(Object obj) {
        String  tmp = ((Expr)obj).getValue().toString();

        return new StringExpr(this.data + tmp);
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