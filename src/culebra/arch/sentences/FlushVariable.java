/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences;

import culebra.arch.ReturnObject;
import culebra.arch.Sentence;
import culebra.arch.expressions.IntegerExpr;
import culebra.arch.variable.Variable;

/**
 *
 * @author Gabriel Gonzalez
 */
public class FlushVariable 
extends Sentence {
    private Variable    var = null;
    
    public FlushVariable(Variable var) {
        this.var = var;
    }

    public ReturnObject exec() {
        ReturnObject    ret = new ReturnObject(new IntegerExpr(1), true);
        ret.setEnd(false);

        var.flush();
        
        return ret;
    }

}
