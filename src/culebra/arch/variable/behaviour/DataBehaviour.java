/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.behaviour;

import java.util.List;

/**
 *
 * @author Gabriel Gonzalez
 */
public class DataBehaviour {
    private String  dataClass = null;
    private String  dataSubClass = null;
    private List    args = null;
    private boolean isEmpty = false;
    private boolean ParamListEmpty = true;

    public DataBehaviour() {
        isEmpty = true;
    }

    public DataBehaviour(String id) {
        this.dataClass = id;
    }

    public DataBehaviour(String id0, String id1) {
        this.dataClass = id0;
        this.dataSubClass = id1;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isParamListEmpty() {
        return ParamListEmpty;
    }

    public List getParamList() {
        return args;
    }

    public void setParamList(List args) {
        this.args = args;
        this.ParamListEmpty = false;
    }

    public String getDataClass() {
        return dataClass;
    }

    public String getDataSubClass() {
        return dataSubClass;
    }
}
