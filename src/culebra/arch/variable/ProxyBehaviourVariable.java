/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable;

/**
 *
 * @author Gabriel
 */
public class ProxyBehaviourVariable
extends ProxyVariable {
    private Variable   bv = null;
    private String  variableName = null;

    public ProxyBehaviourVariable(Variable bv, String name) {
        super(name);
        this.variableName = name;
        this.bv = bv;
    }


    @Override
    public void setValue(Object value) {
        this.pVariable.setValue(value);
        //var.setValue(value);
        //System.out.println("Oxtias variable " + value + " " + var);
    }

    @Override
    public Object getValue() {
       Variable var = this.bv.getVariable(this.variableName);
        System.out.println("Looking for " + this.variableName + " " + var);
        return var.getValue();
    }

    @Override
    public Variable getVariable(String name) {
        return this.bv.getVariable(name);
    }

    @Override
    public boolean containsVariable(String name) {
        return this.bv.containsVariable(name);
    }

    @Override
    public boolean isVariable() {
        return this.bv.isVariable();
    }

}
