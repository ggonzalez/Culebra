/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.behaviour;

import culebra.arch.variable.behaviour.BehaviourParam;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author Gabriel
 */
public class VarAttr {
    private Map attr = null;
    private boolean empty = true;

    public VarAttr() {
        this.empty = true;

        this.attr = new HashMap();

        this.attr.put("re_delim", Pattern.compile("[ \t]+"));
        this.attr.put("re_end", Pattern.compile("[\n\r\f]+"));
        this.attr.put("delim", Pattern.compile(" "));
        this.attr.put("end", Pattern.compile("\n"));
    }

    public VarAttr(List l) {
        this.empty = false;
        attr = new HashMap();
        Iterator iter = l.iterator();

        //XXX Force to specify both delim and re_delim.
        while (iter.hasNext()) {
            BehaviourParam tmp= (BehaviourParam) iter.next();

            if (tmp.getParamName().regionMatches(true, 0, "delim", 0, 5)) {
                this.attr.put("delim", Pattern.compile((String) tmp.getParamValue()));
            } else if (tmp.getParamName().regionMatches(true, 0, "re_delim", 0, 3)) {
                this.attr.put("re_delim", Pattern.compile((String) tmp.getParamValue()));
            }else if (tmp.getParamName().regionMatches(true, 0, "end", 0, 3)) {
                this.attr.put("end", Pattern.compile((String) tmp.getParamValue()));
            }else if (tmp.getParamName().regionMatches(true, 0, "re_end", 0, 3)) {
                this.attr.put("re_end", Pattern.compile((String) tmp.getParamValue()));
            }
            else {
                this.attr.put(tmp.getParamName(), null);
            }
        }

        if (!this.attr.containsKey("delim")) {
            this.attr.put("re_delim", Pattern.compile("[ \t]+"));
            this.attr.put("delim", Pattern.compile(" "));
        }
        if (!this.attr.containsKey("end")) {
            this.attr.put("end", Pattern.compile("\n"));
            this.attr.put("re_end", Pattern.compile("[\n\r\f]+"));
        }
    }

    public Map getAttr() {
        return attr;
    }

    public boolean isEmpty() {
        return empty;
    }

    public Object getParam(String name) {
        Object  ret = null;

        if (this.attr.containsKey(name))
            ret = this.attr.get(name);
        else {
                ret = null;
        }

        return ret;
    }
}