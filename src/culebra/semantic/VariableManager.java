/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.semantic;

import culebra.arch.variable.SimpleVariable;
import culebra.arch.variable.Variable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
        if (this.varMap.containsKey(var.getName())) {
            LinkedList    l = (LinkedList) this.varMap.get(var.getName());
            l.addFirst(var);
        } else {
            LinkedList    l = new LinkedList();
            l.add(var);
            this.varMap.put(var.getName(), l);
        }
    }

    public void delVariable(Variable var) {
        if (this.varMap.containsKey(var.getName())) {
            LinkedList    l = (LinkedList) this.varMap.get(var.getName());
            l.removeFirst();
        }
    }

    public boolean hasVariable(List id) {
        boolean ret = false;

        /*
         * Maybe not the best OO implementation, but we want some more speed
         */
        if (this.varMap.containsKey(id.get(0)) == true) {
           Variable tmp = (Variable) this.varMap.get(id.get(0));
           List     newIdList = null;

           newIdList = id.subList(1, id.size());
           System.out.println(newIdList);
           ret = tmp.hasVariable(newIdList);
        }

        return ret;
    }

    public Variable getVariable(List ids) {
        Variable    ret = null, tmp = null;
        LinkedList  l = (LinkedList) this.varMap.get(ids.get(0));

        tmp = (Variable) l.getFirst();
        
        if (ids.size() > 1) {
            ret = tmp.getVariable(ids.subList(1, ids.size()));
        }

        return ret;
    }


    public static String randomName() {
        String  ret = null;

        ret = "__t" + Integer.toString(VariableManager.name_postfix ++);

        return ret;
    }
}
