/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.security.arch;

import culebra.arch.sentences.Function;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabriel Gonzalez
 */
public class FunctionHook {
    private List        hooks   = null;
    private List        nohooks = null;
    private Function f = null;

    public FunctionHook() {
        this.hooks = new LinkedList();
        this.nohooks = new LinkedList();
    }

    public void addHookedFunction(HookedFunction fun) {
        this.hooks.add(fun);
    }

    public void addNoHookedFunction(HookedFunction fun) {
        this.nohooks.add(fun);
    }

    public Function getFunction() {
        return f;
    }

    public void setFunction(Function f) {
        this.f = f;
    }

    public boolean matchesNoHooked(String func) {
        Iterator iter = this.nohooks.iterator();
        boolean ret = false;

        while (iter.hasNext()) {
            HookedFunction tmp = (HookedFunction) iter.next();

            if (tmp.matches(func)) {
                ret = true;
                break;
            }
        }

        return ret;
    }

    public boolean matches(String func) {
        Iterator    iter    = this.hooks.iterator();
        boolean     ret     = false;

        while (iter.hasNext()) {
            HookedFunction  tmp = (HookedFunction) iter.next();

            if (tmp.matches(func)) {
                ret = true;
                break;
            }
        }

        return ret;
    }
}
