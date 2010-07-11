/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences;

import culebra.arch.Expr;
import culebra.arch.ReturnObject;
import culebra.arch.Sentence;

/**
 *
 * @author Gabriel
 */
public class Return
extends Sentence {
    private Expr    e = null;

    public Return(Expr  expr) {
        super();
        this.e = expr;
    }

    public ReturnObject exec() {
        ReturnObject    ret = null;

        ret = new ReturnObject(this.e.getValue(), this.e.getBoolValue());
        ret.setEnd(true);

        return ret;
    }

}
