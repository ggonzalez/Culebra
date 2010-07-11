/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage;

import culebra.arch.variable.behaviour.VarAttr;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gabriel Gonzalez
 */
public interface Storage {

    public Object getValue();

    public Object getValue(String val);
    
    public void setValue(Object obj);

    public void setVarAttr(VarAttr va);

    public VarAttr getVarAttr();

    public void flush();

    public boolean isEOF();

    public Iterator iterator();
    public Iterator iterator(Map tmp);
    public Iterator iterator(Map tmp, VarAttr va);
    
}
