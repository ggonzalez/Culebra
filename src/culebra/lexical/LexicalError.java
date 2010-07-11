/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.lexical;

/**
 *
 * @author Gabriel Gonzalez
 */
public class LexicalError {
    private int     line = 0;
    private int     column = 0;
    private String  text = null;

    public LexicalError() {
    }

    public int getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }

    public String getText() {
        return text;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
