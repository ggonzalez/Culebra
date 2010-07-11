/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences.io;

import culebra.arch.Expr;
import culebra.arch.Sentence;
import culebra.arch.ReturnObject;
import culebra.arch.expressions.IntegerExpr;

/**
 *
 * @author Gabriel Gonzalez
 */
public class Print 
extends Sentence {
    private Expr    arg = null;
    
    public Print(Expr arg) {
        super();
        this.arg = arg;
    }

    public ReturnObject exec() {
        Object  tmp = arg.getValue();
        ReturnObject    ret = null;
        
        System.out.print(tmp);
        
        ret = new ReturnObject(new IntegerExpr(1), true);
        ret.setEnd(false);
        return ret;
    }
}
