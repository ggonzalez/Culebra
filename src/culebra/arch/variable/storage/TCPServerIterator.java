/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage;

import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.iterator.TextStreamIterator;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class TCPServerIterator 
implements Iterator {
    private TCPStorage storage = null;
    private VarAttr va = null;
    private Map map = null;

    public TCPServerIterator(Storage st, VarAttr va, Map map) {
        this.storage = (TCPStorage) st;
        this.va = va;
        this.map = map;
    }

    public boolean hasNext() {
        System.out.println("Server closed? " + this.storage.getServer().isClosed());
        return !this.storage.getServer().isClosed();
    }

    public Object next() {
        Storage ret = null, tmp = null;
        Socket cnn = null;
        try {
            cnn = this.storage.getServer().accept();
        } catch (IOException ex) {
            Logger.getLogger(TCPServerIterator.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }

        //XXX Use dummy values for this version
        tmp = new TCPStorage("localhost", 1);
        tmp.setVarAttr(this.storage.getVarAttr());
        ((TCPStorage)tmp).setSocket(cnn);
        ret = new ProxyStorage(tmp, new TextStreamIterator(tmp, this.map));

        return ret;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
