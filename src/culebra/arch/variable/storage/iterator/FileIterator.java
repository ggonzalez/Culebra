/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage.iterator;

import culebra.arch.variable.BehaviourVariable;
import culebra.arch.variable.Variable;
import culebra.arch.variable.storage.FileStorage;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class FileIterator
implements Iterator {
    private FileStorage fstorage = null;
    private Map         variables = null;

    public FileIterator(FileStorage aThis, Map tmp) {
        fstorage = aThis;
        variables = tmp;
    }

    public boolean hasNext() {
        System.out.println("EOF " + fstorage.isEOF());
        return !fstorage.isEOF();
    }

    public Object next() {
        Map tmpMap = BehaviourVariable.duplicateVariables(this.variables);
        
        Collection tmpValues = tmpMap.values();
        Iterator   iter = tmpValues.iterator();
        
System.out.println("oxtias " + this.fstorage.isEndLine() + " " + iter.hasNext());
        while (!this.fstorage.isEndLine() && iter.hasNext()) {
            String  tmp = this.fstorage.readField();
            Variable    tmpVar = (Variable) iter.next();

            tmpVar.setValue(tmp);
            System.out.println("FIELD READ: " + tmp);
        }
        
        return tmpMap;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
