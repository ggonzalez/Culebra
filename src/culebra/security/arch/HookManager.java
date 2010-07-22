/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.security.arch;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabriel Gonzalez
 */
public class HookManager {
    private static List    hookers = new LinkedList();

    public HookManager() {
    }

    public static void addHook(FunctionHook fh) {
        HookManager.hookers.add(fh);
    }

    public static void execIfMatches(String funcName) {
        Iterator    iter    = HookManager.hookers.iterator();

        while (iter.hasNext()) {
            FunctionHook tmp = (FunctionHook) iter.next();

            if (tmp.matches(funcName)) {
                if (!tmp.matchesNoHooked(funcName))
                    tmp.getFunction().exec();
            }
        }
    }
}
