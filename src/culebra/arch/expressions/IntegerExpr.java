/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.expressions;

import culebra.arch.Expr;
import culebra.arch.variable.Variable;
import java.math.BigInteger;

/**
 *
 * @author Gabriel Gonzalez
 */
public class IntegerExpr // extends BigInteger
implements Expr {
    BigInteger integer = null;

    public IntegerExpr(String i) {
        //super(i);
        this.integer = new BigInteger(i);
    }

    public IntegerExpr(int i) {
        //super(BigInteger.valueOf(i).toString());
        this.integer = new BigInteger(BigInteger.valueOf(i).toString());
    }

    public Object getValue() {
        return this;
    }

    public boolean getBoolValue() {
        return !this.integer.equals(BigInteger.ZERO);
    }

    public int comparesTo(Object obj) {
        int     ret = 0;
        String  tmp1 = this.toString();
        String  tmp2 = ((Expr)obj).getValue().toString();

        if (tmp1.compareTo(tmp2) != 0) {
            if (obj instanceof IntegerExpr) {
                //System.out.print("comparesTo: " + this.integer + " to " + tmp2);
                ret = this.integer.compareTo(new BigInteger(tmp2));
            } else
                if (obj instanceof StringExpr) {
                ret = tmp1.compareTo(tmp2);
            } else {
                ret = this.comparesTo(((Expr)obj).getValue());
                //ret = (this.getBoolValue() == ((Expr)obj).getBoolValue()) ? 1 : 0;
            }
        }
        return ret;
    }

    public Object add(StringExpr obj) {
        Object  ret = null;

        /*if (obj instanceof IntegerExpr) {
            BigInteger  tmp = (BigInteger) ((IntegerExpr)obj).getValue();

            ret = this.integer.add(tmp);
        } else */
         //if (obj instanceof StringExpr) {
            BigInteger  tmp = new BigInteger((obj).toString());

            ret = new IntegerExpr(this.integer.add(tmp).toString());
        //}

        return ret;
    }

    public Object substract(Object obj) {
        Object  ret = null;
        
        if (obj instanceof IntegerExpr) {
            ret = new IntegerExpr(this.integer.subtract(new BigInteger(((IntegerExpr)obj).toString())).toString());
        } else
            throw new UnsupportedOperationException("IntegerExpr substract(object)");

        
        return ret;
    }

    public Object multiply(Object obj) {
            return new IntegerExpr(this.integer.multiply(new BigInteger (obj.toString())).toString());
    }

    public Object divide(Object obj) {
            return new IntegerExpr(this.integer.divide(new BigInteger (obj.toString())).toString());
    }
    public Object add(IntegerExpr obj) {
        return this.add(new StringExpr(obj.toString()));
    }


    public Object add(Object obj) {
        Object  o = ((Expr)obj).getValue();
        if (o instanceof IntegerExpr)
            return this.add((IntegerExpr)o);
        else if (o instanceof StringExpr) {
            return this.add((StringExpr)o);
        } else if (o instanceof Variable)
            return this.add(((Variable)obj).getValue());
        else
            throw new UnsupportedOperationException("IntegerExpr add(object) " + obj);
    }

    @Override
    public String toString() {
        return this.integer.toString();
    }

    public boolean isVariable() {
        return false;
    }

}
