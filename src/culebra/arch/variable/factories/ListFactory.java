/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.factories;

import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.ListStorage;
import culebra.arch.variable.storage.Storage;
import java.util.List;

/**
 *
 * @author Gabriel
 */
class ListFactory
extends StorageFactory {

    public ListFactory() {
    }

    @Override
    public Storage createStorage(VarAttr va) {
        Storage ret = null;

        ret = new ListStorage();

        ret.setVarAttr(va);

        return ret;
    }

    @Override
    public Storage createStorage(VarAttr va, List l) {
        throw new UnsupportedOperationException("No parameters allowed.");
    }

}
