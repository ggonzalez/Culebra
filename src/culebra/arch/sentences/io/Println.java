/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences.io;

import culebra.arch.Expr;
import culebra.arch.ReturnObject;
import culebra.arch.Sentence;
import culebra.arch.expressions.IntegerExpr;
import culebra.arch.variable.Variable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Gabriel Gonzalez
 */
public class Println 
extends Sentence {
    private Expr arg = null;
    
    public Println(Expr e) {
        super();
        this.arg = e;
    }
    
    public ReturnObject exec() {
        Object  tmp = arg.getValue();
        ReturnObject    ret = null;

        /*if (tmp instanceof Map) {
            Map         mapTmp = (Map) tmp;
            Collection  co = mapTmp.values();
            Iterator    iter = co.iterator();

            System.out.print("{ ");
            
            while (iter.hasNext()) {
                Variable    var = (Variable) iter.next();

                if (var.getValue() == null)
                    System.out.print("NULL");
                else
                    System.out.print(var.getValue());

                if (iter.hasNext())
                    System.out.print(", ");
            }

            System.out.println(" }");
        } else*/
            System.out.println(tmp);

        ret = new ReturnObject(new IntegerExpr(1), true);
        ret.setEnd(false);
        
        return ret;
    }

}
