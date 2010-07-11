/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.sentences.io;

import culebra.arch.Expr;
import culebra.arch.Sentence;
import culebra.arch.expressions.IntegerExpr;
import culebra.arch.expressions.StringExpr;
import culebra.arch.ReturnObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Gabriel Gonzalez
 */
public class Read
extends Sentence  
implements Expr {
    private Expr    arg = null;
    
    public Read()
    {
        super();
    }
    
    public ReturnObject exec() {
        String  read = null;
        ReturnObject  ret = null;
        Object  r = null;
        
        BufferedReader  stdin = new BufferedReader(new InputStreamReader(System.in));
        Scanner kbd = new Scanner(System.in);
          
        try {
            //read = stdin.readLine();
            read = String.valueOf(stdin.readLine());
            r = (Object) new IntegerExpr(read);
            ret = new ReturnObject(r, true);
        } catch (IOException ex) {
            r = null;
            ret = new ReturnObject(r, false);
        } catch (NumberFormatException e) {
            r = (Object) new StringExpr(read);
            ret = new ReturnObject(r, true);
        }
       
        ret.setEnd(false);
        return ret;
    }

    public Object getValue() {
        return this.exec().getValue();
    }

    public boolean getBoolValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int comparesTo(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object substract(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object multiply(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object divide(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(StringExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object add(IntegerExpr obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isVariable() {
        return false;
    }

}
