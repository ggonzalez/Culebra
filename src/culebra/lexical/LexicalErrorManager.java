/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.lexical;

/**
 *
 * @author Gabriel Gonzalez
 */
public class LexicalErrorManager {
    
    public static void lexicalError(LexicalError err) {
        System.out.println("[ERROR - LEXICAL] (" + err.getLine() + ", " + err.getColumn() + ") - " + err.getText());
    }
    
    public static void lexicalError(String error) {
        System.out.println(error);
    }
    
    public static void lexicalFatalError(LexicalError err) {
        lexicalError(err);
        System.exit(-1);
    }
    
    public static void lexicalFatalError(String error) {
        lexicalError(error);
        System.exit(-1);
    }
    
    public static void lexicalInfo(String info) {
        System.out.println("[INFO - LEXICAL] " + info);
    }

    public static void lexicalInfo(Token tok) {
        System.out.println("[INFO - LEXICAL] " + tok.getLexeme() + "(" + tok.getLine() + ", " + tok.getColumn() + ")");
    }

}
