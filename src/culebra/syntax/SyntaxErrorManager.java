/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package culebra.syntax;

import culebra.lexical.Token;

/**
 *
 * @author Gabriel Gonzalez
 */
public class SyntaxErrorManager {

    public static void syntaxError(Token err) {
        System.out.println("[ERROR - LEXICAL] (" + err.getLine() + ", " + err.getColumn() + ") - " + err.getLexeme());
    }

    public static void syntaxError(String error) {
        System.out.println(error);
    }

    public static void syntaxError(String error, Token tok) {
        if (tok != null)
            System.out.println(error + " [ " + tok.getLexeme() + " ](" + tok.getLine() + ", " + tok.getLine() + ")");
        else
            syntaxError(error);
    }

    public static void syntaxFatalError(Token err) {
        syntaxError(err);
        System.exit(-1);
    }

    public static void syntaxFatalError(String error) {
        syntaxError(error);
        System.exit(-1);
    }

    public static void syntaxFatalError(String error, Token tok) {
        syntaxError(error, tok);
        System.exit(-1);
    }

    public static void syntaxInfo(String info) {
        System.out.println("[INFO - SYNTAX] " + info);
    }

    public static void syntaxInfo(Token tok) {
        System.out.println("[INFO - SYNTAX] " + tok.getLexeme() + "(" + tok.getLine() + ", " + tok.getColumn() + ")");
    }

    public static void syntaxInfo(String info, Token tok) {
        System.out.println("[INFO - SYNTAX] " + info + " - " + tok.getLexeme() + "(" + tok.getLine() + ", " + tok.getColumn() + ")");
    }
}
