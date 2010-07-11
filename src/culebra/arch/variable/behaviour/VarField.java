/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.behaviour;

import java.util.regex.Pattern;

/**
 *
 * @author Gabriel
 */
public class VarField {
    private String  token = null;
    private String  regexString = null;
    private Pattern rePattern = null;
    private boolean regex = false;
    private String  delim = null;
    private boolean split = false;

    public VarField(String tk) {
        this.token = tk;
    }

    public boolean isSplit() {
        return split;
    }

    public boolean isRegex() {
        return regex;
    }

    public String getToken() {
        return token;
    }

    public String getRegex() {
        return regexString;
    }

    public Pattern getRePattern() {
        return rePattern;
    }

    public String getDelim() {
        return delim;
    }

    public void setRegex(String regex) {
        this.regexString = regex;
        this.rePattern = Pattern.compile(regex);
        this.regex = true;
    }

    public void setDelim(String delim) {
        this.delim = delim;
        this.split = true;
    }
}
