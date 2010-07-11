/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.factories;

import culebra.arch.variable.behaviour.BehaviourParam;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.FileStorage;
import culebra.arch.variable.storage.Storage;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class FileFactory
extends StorageFactory{

    public FileFactory() {
    }

    @Override
    public Storage createStorage(VarAttr va) {
        throw new UnsupportedOperationException("No arguments provided for File() operation.");
    }

    @Override
    public Storage createStorage(VarAttr var, List l) {
        FileStorage ret = null;
        Iterator    iter = l.iterator();
        String      filename = null;
        String      attr = null;

        while (iter.hasNext()) {
            /*String tmp1 = (String) iter.next();
            String[] tmp = tmp1.split("=");
            if (tmp.length == 2) {
            if (tmp[0].equalsIgnoreCase("file") ||
            tmp[0].equalsIgnoreCase("filename")) {
            filename = tmp[1];
            } else if (tmp[0].equalsIgnoreCase("attr") ||
            tmp[0].equalsIgnoreCase("attributes")) {
            attr = tmp[1];
            } else
            System.err.println("File argument " + tmp[0] + " not implemented");
            } if (tmp[0].equalsIgnoreCase("append")) {
            attr += "a";
            } else {
            System.err.append("Bad argument");
            }*/
            BehaviourParam  tmp = (BehaviourParam) iter.next();
            if (tmp.getParamName().regionMatches(true, 0, "file", 0, 4)) {
                filename = (String) tmp.getParamValue();
            } else if (tmp.getParamName().regionMatches(true, 0, "attr", 0, 4)) {
                attr = (String) tmp.getParamValue();
            } else if (tmp.getParamName().regionMatches(true, 0, "append", 0, 6)) {
                attr += "a";
            } else {
                System.err.append(tmp.getParamName() + ": Bad argument");
            }

        }
        
        if (filename == null)
            System.err.append("FileName Missing");

        ret = new FileStorage(filename, attr, null);

        ret.setVarAttr(var);
        return  ret;
    }
}
