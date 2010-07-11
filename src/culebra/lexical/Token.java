/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.lexical;
import  java_cup.runtime.Symbol;
/**
 *
 * @author Gabriel Gonzalez
 */
public class Token extends Symbol {
    private String  lexeme = null;
    private int     line = 0;
    private int     column = 0;
    
    Token(int id) {
        super(id);
        this.value = this;
    }

    public int getColumn() {
        return column;
    }

    public String getLexeme() {
        return lexeme;
    }

    public int getLine() {
        return line;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public void setLine(int line) {
        this.line = line;
    }
}
