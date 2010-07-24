    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences;

import culebra.arch.ReturnObject;
import culebra.arch.Sentence;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Gabriel Gonzalez
 */
public class SentencesBlock 
extends Sentence {
    private List    sentences = null;
    private int repetitions = 1;

    public ReturnObject exec() {
        ReturnObject ret = null;

        for (int i = 0; i < this.repetitions; i++) {
            ListIterator iter = sentences.listIterator();



            while (iter.hasNext()) {
                Sentence tmp = (Sentence) iter.next();
                if (tmp == null) {
                    // XXX: Check why this returns null
                    break;
                }
                ret = tmp.exec();

                if (ret.isEnd()) {
                    break;
                }
            }
        }

        return ret;
    }

    public void setSentences(List sentences) {
        this.sentences = sentences;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
    
}
