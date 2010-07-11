/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch;

/**
 *
 * @author Gabriel Gonzalez
 */
public class ModuleFunction {
    String  moduleName = null;
    String  functionName = null;
    boolean localModule = true;

    public ModuleFunction() {
        localModule = true;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
        this.localModule = false;
    }

    public boolean isLocalModule() {
        return localModule;
    }

}
