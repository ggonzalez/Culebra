/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage.iterator;

import culebra.arch.variable.storage.ListStorage;
import java.util.Iterator;

/**
 *
 * @author Gabriel Gonzalez
 */
public class ListIterator 
implements Iterator {
    private Iterator iter = null;

    public ListIterator(ListStorage sto) {
        this.iter = sto.getIterator();
    }
    
    public boolean hasNext() {
        return this.iter.hasNext();
    }

    public Object next() {
        return this.iter.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
