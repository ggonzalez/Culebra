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
public class For 
extends Sentence {
    private Expr    cond = null;
    private Sentence pre = null;
    private Sentence last = null;
    private SentencesBlock block = null;
    
    public For(Sentence pre, Expr cond, Sentence last) {
        this.pre = pre;
        this.cond = cond;
        this.last = last;
    }

    public void setBlock(SentencesBlock block) {
        this.block = block;
    }
    
    public ReturnObject exec() {
        ReturnObject  ret = null;
        
        if (this.pre != null)
            pre.exec();
        
        while (cond.getBoolValue()) {
            ret = this.block.exec();

            if (ret.isEnd())
                    break;
            
            if (this.last != null)
                this.last.exec();
        }
        
        return ret;
    }

}
