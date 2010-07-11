/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences;

import culebra.arch.Expr;
import culebra.arch.Sentence;
import culebra.arch.ReturnObject;
import culebra.arch.expressions.IntegerExpr;
import java.math.BigInteger;

/**
 *
 * @author Gabriel
 */
public class IfSentence
extends Sentence {
    private Expr        expr = null;
    private Sentence    s1 = null;
    private Sentence    s2 = null;

    public IfSentence() {
        super();
    }

    public ReturnObject exec() {
        ReturnObject    ret = null;

        if (expr.getBoolValue())
                ret = s1.exec();
        else {
                if (s2 != null)
                    ret = s2.exec();
        }

        if (ret == null) {
            ret = new ReturnObject(new IntegerExpr(1), true);
            ret.setEnd(false);
        }

        return ret;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public Sentence getSentence1() {
        return s1;
    }

    public void setSentence1(Sentence s1) {
        this.s1 = s1;
    }

    public Sentence getSentence2() {
        return s2;
    }

    public void setSentence2(Sentence s2) {
        this.s2 = s2;
    }


}
