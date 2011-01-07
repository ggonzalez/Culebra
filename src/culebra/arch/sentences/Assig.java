/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences;

import culebra.arch.Expr;
import culebra.arch.ReturnObject;
import culebra.arch.Sentence;
import culebra.arch.expressions.IntegerExpr;
import culebra.arch.variable.ProxyVariable;
import culebra.arch.variable.SimpleVariable;
import culebra.arch.variable.Variable;
import culebra.arch.variable.behaviour.VarField;
import culebra.arch.variable.storage.RAMStorage;
import culebra.arch.variable.storage.Storage;
import culebra.semantic.VariableManager;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabriel Gonzalez
 */
public class Assig 
extends Sentence {
    private Expr    expr = null;
    private Variable    variable = null;
    private List    fields = null;

    public Assig() {
        super();
    }
    /**
     * If the right-hand side argument is a variable, just set it to the
     * ProxyVariable.
     * else it is an expression, create a SimpleVariable, evaluate the expr
     * and set it as value.
     *
     * @return ReturnObject
     */
    public ReturnObject exec() {
        ReturnObject    ret = null;

 //       System.out.println("Assic exec " + expr.getValue());
        if (expr != null) {
            this.variable.setValue(this.expr.getValue());
        } else
            System.out.println("ERROR: Assig expr == NULL");

        ret = new ReturnObject(new IntegerExpr(1), true);
        ret.setEnd(false);

        return ret;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }
    public void setVariable(Variable variable , String field) {
        this.fields = new LinkedList();
        this.fields.add(field);
        this.variable = variable;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public List getFields() {
        return fields;
    }

    public void setFields(List fields) {
        this.fields = fields;
    }


}
