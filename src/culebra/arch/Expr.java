/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch;

import culebra.arch.expressions.IntegerExpr;
import culebra.arch.expressions.StringExpr;

/**
 *
 * @author Gabriel
 */
public interface Expr {

    public boolean  isVariable();
    
    public boolean getBoolValue();

    public Object getValue();

    public int comparesTo(Object obj);

    // Arithmetic operations

    public Object add(Object obj);

    public Object add(StringExpr obj);

    public Object add(IntegerExpr obj);

    public Object substract(Object obj);

    public Object multiply(Object obj);

    public Object divide(Object obj);
}
