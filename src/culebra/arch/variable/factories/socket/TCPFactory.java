/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.factories.socket;

import culebra.arch.variable.behaviour.BehaviourParam;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.factories.StorageFactory;
import culebra.arch.variable.storage.Storage;
import culebra.arch.variable.storage.TCPStorage;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class TCPFactory
extends StorageFactory {

    public TCPFactory() {
    }

    @Override
    public Storage createStorage(VarAttr var) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Storage createStorage(VarAttr var, List l) {
        Storage     ret = null;
        Iterator    iter = l.iterator();
        String      host = null;
        int         port = 0;

        while (iter.hasNext()) {
            BehaviourParam  tmp = (BehaviourParam) iter.next();
            if (tmp.getParamName().regionMatches(true, 0, "host", 0, 4)) {
                host = (String) tmp.getParamValue();
            } if (tmp.getParamName().regionMatches(true, 0, "port", 0, 4)) {
                port = Integer.parseInt((String) tmp.getParamValue());
            }
        }

        if (host == null)
            System.err.println("Hostname not provided");
        if (port == 0)
            System.err.println("Port not provided");

        ret = new TCPStorage(host, port);

        ret.setVarAttr(var);

        return ret;
    }

}
