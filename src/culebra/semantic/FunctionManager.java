/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.semantic;

import culebra.arch.sentences.Function;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Gabriel Gonzalez
 */
public class FunctionManager {
    Map    funcList = null;

    public FunctionManager() {
        funcList = new TreeMap();
    }
    
    public void addFunction(Function f) {
        funcList.put(f.toString(), f);
    }
    
    public boolean containsFunction(Function f) {
        return funcList.containsKey(f.toString());
    }
    
    public boolean containsFunction(String fname) {
        return funcList.containsKey(fname);
    }
    
    public Function getFunction(String name) {
        return (Function) funcList.get(name);
    }
}
