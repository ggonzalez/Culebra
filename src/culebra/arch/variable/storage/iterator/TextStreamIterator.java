/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage.iterator;

import culebra.arch.variable.BehaviourVariable;
import culebra.arch.variable.Variable;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.FileStorage;
import culebra.arch.variable.storage.Storage;
import culebra.arch.variable.storage.TextStorage;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author Gabriel
 */
public class TextStreamIterator 
implements Iterator {
    private TextStorage store = null;
    private Map         variables = null;

    public TextStreamIterator (Storage aThis, Map tmp) {
        this.store = (TextStorage) aThis;
        this.variables = tmp;
        System.out.println("HELLOO TextSTreamIterator constructor??");
        System.out.flush();
    }
    public boolean hasNext() {
        System.out.println("EOF " + store.isEOF());
        return !store.isEOF();
    }

    public Object next() {
        Map tmpMap = BehaviourVariable.duplicateVariables(this.variables);

        Collection tmpValues = tmpMap.values();
        Iterator   iter = tmpValues.iterator();

        System.out.println("TextStreamIterator next store " + this.store);
        //XXX wait to see what happens with this new version
        //if (this.store instanceof FileStorage) {
        if (true) {
            String[]  flds = null;
            TextStorage fsto = (TextStorage) this.store;

            flds = fsto.readFields();

            if (flds != null) {
                // Specify Regex and get va.getPattern() or whatever
                int i = 0;
                while (iter.hasNext() && (i < flds.length)) {
                    Variable    tmpVar = (Variable) iter.next();

                    tmpVar.setValue(flds[i]);
                    System.out.println(tmpVar.getName() + " Split read " + flds[i]);
                    i ++;
                }
            } else
                tmpMap = null;
        } else {

            System.out.println("oxtias " + this.store.isEOL() + " " + iter.hasNext());
            while (!this.store.isEOL() && iter.hasNext()) {
                String tmp = this.store.readField();
                Variable tmpVar = (Variable) iter.next();

                tmpVar.setValue(tmp);
                System.out.println(tmpVar.getName() + " FIELD READ: " + tmp);
            }

        }

        System.out.println("DEBUG TextStreamIterator end next()");
        return tmpMap;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
