/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch;

/**
 *
 * @author Gabriel Gonzalez
 */
public abstract class Sentence 
implements Executable {

    private boolean isReturn = false;

    public Sentence() {
    }
    
    public boolean isReturn() {
        return this.isReturn;
    }
}
