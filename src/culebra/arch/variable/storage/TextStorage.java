/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage;

/**
 *
 * @author Gabriel
 */
public interface TextStorage
extends Storage {

    public boolean  isEOL();

    public String   readField();

    public String   readLine();

    public String[] readFields();
}
