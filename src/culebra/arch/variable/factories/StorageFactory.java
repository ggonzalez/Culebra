/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.factories;

import culebra.arch.variable.Variable;
import culebra.arch.variable.behaviour.DataBehaviour;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.factories.socket.TCPFactory;
import culebra.arch.variable.storage.Storage;
import java.util.List;

/**
 *
 * @author Gabriel Gonzalez
 */
public abstract class StorageFactory {
    public StorageFactory() {
    }
    
    public static StorageFactory getFactory(DataBehaviour dB, Variable var) {
        StorageFactory ret = null;

        if (dB.isEmpty()) {
            ret = new ListFactory();
        } else {
            if (dB.getDataClass().equalsIgnoreCase("DB")) {
                if (dB.getDataSubClass().equalsIgnoreCase("MySQL")) {
                    ret = new MySQLFactory(var);
                }
            } else if (dB.getDataClass().equalsIgnoreCase("socket")) {
                if (dB.getDataSubClass().equalsIgnoreCase("tcp")) {
                    ret = new TCPFactory();
                }
                if (dB.getDataSubClass().equalsIgnoreCase("tel")) {
                    ret = new TCPFactory();
                }
            } else if (dB.getDataClass().equalsIgnoreCase("list")) {
                ret = new ListFactory();
            } else if (dB.getDataClass().equalsIgnoreCase("file")) {
                ret = new FileFactory();
            } else {
                System.err.println("StorageFactory(): Behaviour " + dB.getDataClass() + " not implemented");
            }
        }
        return ret;
    }

    abstract public Storage createStorage(VarAttr var);
    
    abstract public Storage createStorage(VarAttr var, List l);

}