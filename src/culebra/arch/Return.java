/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch;

/**
 *
 * @author Gabriel Gonzalez
 */
public class Return {
    Object  value = null;

    public Return(Object ret) {
        this.value = ret;
    }

    public Object getValue() {
        return value;
    }
        
}
