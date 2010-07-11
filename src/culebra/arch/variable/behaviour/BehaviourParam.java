/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.behaviour;

/**
 *
 * @author Gabriel Gonzalez
 */
public class BehaviourParam {
    private String  paramName = null;
    private Object  paramValue = null;
    
    public BehaviourParam(String name, Object obj) {
        this.paramName = name;
        this.paramValue = obj;
    }

    public String getParamName() {
        return paramName;
    }

    public Object getParamValue() {
        return paramValue;
    }
}
