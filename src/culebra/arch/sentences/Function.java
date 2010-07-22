/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences;

import culebra.arch.*;
import culebra.arch.expressions.IntegerExpr;
import culebra.arch.expressions.StringExpr;
import culebra.security.arch.HookManager;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Gabriel Gonzalez
 */
public class Function 
extends Sentence 
implements Expr {
    private List    sentences = null;
    private List    args = null;
    private String  name = null;
    private String  moduleName = null;

    public Function(String name) {
        sentences = new LinkedList();
        this.name = name;
    }

    public ReturnObject exec() {
        ListIterator    iter = sentences.listIterator();
        ReturnObject   ret = null;
        
        HookManager.execIfMatches(moduleName + "." + name);

        while (iter.hasNext()) {
            Sentence tmp = (Sentence) iter.next();
            if (tmp == null) {
                // XXX: Check why this returns null
                break;
            }
            ret = tmp.exec();

            if (ret.isEnd())
                break;
        }
        
        return ret;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public void setArguments(List args) {
        this.args = args;
    }

    public List getArguments() {
  
        return args;
    }

    public void addSentence(Sentence s) {
        sentences.add(s);
    }
    
    public void addSentences(List l) {
        sentences.addAll(l);
    }
    
    public Object getValue() {
        return exec();
    }
    
    @Override
    public String toString() {
        return name;
    }

    public boolean getBoolValue() {
        throw new UnsupportedOperationException("Function: Not supported yet.");
    }

    public int comparesTo(Object obj) {
        throw new UnsupportedOperationException("Function: Not supported yet.");
    }

    public Object add(Object obj) {
        throw new UnsupportedOperationException("Function: Not supported yet.");
    }

    public Object substract(Object obj) {
        throw new UnsupportedOperationException("Function: Not supported yet.");
    }

    public Object multiply(Object obj) {
        throw new UnsupportedOperationException("Function: Not supported yet.");
    }

    public Object divide(Object obj) {
        throw new UnsupportedOperationException("Function: Not supported yet.");
    }

    public Object add(StringExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(IntegerExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Same reason as in FunctionCall
    public boolean isVariable() {
        return true;
    }
}
