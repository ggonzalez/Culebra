/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.semantic;

import culebra.arch.variable.SimpleVariable;
import culebra.arch.variable.Variable;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Gabriel
 */
public class VariableManager {
    private static int  name_postfix = 0;
    private Map    varMap = null;
    private String  name = null;

    public VariableManager(String name) {
        this.name = name;
        varMap = new TreeMap();
    }

    public String getName() {
        return name;
    }

    public void addVariable(Variable var) {
        LinkedList    l = new LinkedList();
        l.add(var);
        this.varMap.put(var.getName(), l);
    }

    public boolean hasVariable(String name) {
        return this.varMap.containsKey(name);
    }

    public Variable getVariable(String name) {
        LinkedList    l = (LinkedList) this.varMap.get(name);

        return (Variable) l.getFirst();
    }

    public void addIteratorVariable(Variable var) {
        LinkedList    l = (LinkedList) this.varMap.get(var.getName());
        l.addFirst(var);
    }
    
    public void delIteratorVariable(Variable var) {
        LinkedList    l = (LinkedList) this.varMap.get(var.getName());
        l.removeFirst();
    }

    public static String randomName() {
        String  ret = null;

        ret = "__t" + Integer.toString(VariableManager.name_postfix ++);

        return ret;
    }
}
