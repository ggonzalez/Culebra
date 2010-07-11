/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences;

import culebra.arch.Expr;
import culebra.arch.ReturnObject;
import culebra.arch.Sentence;
import java.math.BigInteger;

/**
 *
 * @author Gabriel Gonzalez
 */
public class While 
extends Sentence {
    private Expr    condition = null;
    private SentencesBlock block = null;

    public ReturnObject exec() {
        ReturnObject ret = null;
        if (condition == null) {
            System.out.println("NULL 1");
        } else {
            while (condition.getBoolValue()) {
                ret = block.exec();

                if (ret.isEnd())
                    break;
            }
        }

        return ret;
    }

    public void setBlock(SentencesBlock block) {
        this.block = block;
    }

    public Expr getCondition() {
        return condition;
    }

    public void setCondition(Expr condition) {
        this.condition = condition;
    }
    
    

}
