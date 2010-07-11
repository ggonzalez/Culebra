/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences;

import culebra.arch.ReturnObject;
import culebra.arch.Sentence;
import culebra.arch.variable.BehaviourVariable;
import culebra.arch.variable.ProxyVariable;
import culebra.arch.variable.SimpleVariable;
import culebra.arch.variable.Variable;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.RAMStorage;
import culebra.arch.variable.storage.Storage;
import culebra.semantic.VariableManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Gabriel Gonzalez
 */
public class VariableIterator 
extends Sentence {
    private VarAttr         va = null;
    private Variable        var = null;
    private Variable   newvar = null;
    private VariableManager vm = null;
    private Sentence        stc = null;

    public VariableIterator(VariableManager vm, Variable var, Variable newvar, VarAttr va) {
        this.var = var;
        this.newvar = newvar;
        this.vm = vm;
        this.va = va;
    }

    public void setSentences(Sentence stc) {
        this.stc = stc;
    }

    public VariableManager getVariableManager() {
        return vm;
    }

    public Variable getNewvar() {
        return newvar;
    }
    
    public ReturnObject exec() {
        Variable    tmpvar = null;
        Iterator    iter = null;
        ReturnObject      ret = null;

        if (this.va.isEmpty()) {
            //System.out.println("VariableIterator va.Empty");
            iter = var.iterator();
        } else {
            //System.out.println("VariableIterator NO va.Empty");
            iter = var.iterator(this.va);
        }

        if (var.isBehaviour()) {
            tmpvar = new BehaviourVariable(var.getName());
            ((BehaviourVariable) tmpvar).setVariables(((BehaviourVariable) var.getVariable()).getVariables());
        } else {
            SimpleVariable tmpVar = (SimpleVariable) var.getVariable();
            tmpvar = new SimpleVariable(tmpVar.getVarField());
            Storage sto = new RAMStorage();
            tmpvar.addStorage(sto);
        }
        ((ProxyVariable)this.newvar).setVariable(tmpvar);
        //System.out.println("VarIterator Hello? iter.hasnext() " + iter.hasNext());
        while (iter.hasNext()) {   
            Object tmp = iter.next();
            System.out.println("VarIter TMP" + this.newvar);
            if (tmp != null) {
                if (var.isBehaviour()) {
                    if (tmp instanceof LinkedHashMap) {
                        //((BehaviourVariable) this.newvar.getVariable()).setVariables((Map) tmp);
                        ((BehaviourVariable)tmpvar).setVariables((Map) tmp);
                        System.out.println("BV: " + (Map) tmp);
                    } else {
                        // if tmp == Storage
                        this.newvar.getVariable().addStorage((Storage) tmp);
                    }
                } else {
                    this.newvar.setValue(tmp);
                }

                ret = stc.exec();

                if (ret.isEnd())
                    break;
            }
        }
      
        return ret;
    }

}
