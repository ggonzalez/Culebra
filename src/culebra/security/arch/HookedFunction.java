/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.security.arch;

/**
 *
 * @author Gabriel Gonzalez
 */
public class HookedFunction {
    private String  regex       = null;
    private boolean nohooked    = false;

    public HookedFunction(String hook, boolean nohook) {
        this.regex      = this.parseRegex(hook);
        this.nohooked   = nohook;
    }

    public boolean isNoHooked() {
        return this.nohooked;
    }

    public boolean matches(String func) {
        return func.matches(this.regex);
    }

    private String parseRegex(String hook) {
        return hook.replace("*", "\\w*").replace(".", "\\.");
    }
}
