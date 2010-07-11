/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.semantic;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Gabriel
 */
public class ModuleManager {
    FunctionManager fm = null;
    Map            vm = null;
    Map             mms = null;

    String          moduleName = null;

    public ModuleManager() {
        vm = new TreeMap();
        mms = new TreeMap();
    }

    public String getName() {
        return moduleName;
    }

    public void setName(String moduleName) {
        this.moduleName = moduleName;
    }

    public FunctionManager getFunctionManager() {
        return fm;
    }

    public void setFunctionManager(FunctionManager fm) {
        this.fm = fm;
    }

    public void addVariableManager(VariableManager vm) {
        this.vm.put(vm.getName(), vm);
    }
    
    public boolean containsVariableManager(String name) {
        return this.vm.containsKey(name);
    }
    
    public VariableManager getVariableManager(String name) {
        return (VariableManager) this.vm.get(name);
    }
    
    public void addImportedModuleManager(ModuleManager mm) {
        //System.out.println("IMPROTADO : " + mm.getName());
        this.mms.put(mm.getName(), mm);
    }
    
    public boolean containsImportedModuleManager(String name) {
        //System.out.println("buscando : " + name);
        return this.mms.containsKey(name);
    }
    
    public ModuleManager getImportedModuleManager(String name) {
        return (ModuleManager) this.mms.get(name);
    }
}
