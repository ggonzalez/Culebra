/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch;

/**
 *
 * @author Gabriel Gonzalez
 */
public class ReturnObject {
    Object  value = null;
    boolean end = false;
    boolean ret = false;

    public ReturnObject(Object ret, boolean bool) {
        this.value = ret;
        this.ret = bool;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
   
    public Object getValue() {
        return this.value;
    }

    public boolean getBoolValue() {
        return this.ret;
    }
        
}
