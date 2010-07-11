/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage;

import culebra.arch.variable.Variable;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.iterator.FileIterator;
import culebra.arch.variable.storage.iterator.TextStreamIterator;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Gabriel
 */
public class FileStorage
implements Storage, TextStorage {
    private String  filename = null;
    private String  attr = null;
    private File    file = null;
    private FileWriter fwr = null;
    private BufferedWriter bwr = null;
    private BufferedReader brd = null;
    private FileOutputStream    fout = null;
    private FileInputStream     fin = null;
    private DataInputStream     din = null;
    private ObjectInputStream   oin = null;
    private ObjectOutputStream  oout = null;
    private List                fmt = null;
    private VarAttr             varAttr = null;
    private boolean             endLine = false;
    private boolean             EOF = false;

    public FileStorage(String filename, String attr, List format) {
        this.filename = filename;
        this.fmt = format;
        /*
        try {
            //fout = new FileOutputStream(filename);
            //oout = new ObjectOutputStream(fout);
           // fin = new FileInputStream(filename);
            //oin = new ObjectInputStream(fin);
        } catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }

    public boolean isEOF() {
        return this.EOF;
    }

    //XXX This ugly hack needs to be shorted out SOOOOOOOOOOOOOOON
    public boolean isEndLine() {
        boolean ret = endLine;

        endLine = false;

        return ret;
    }

    public Object getValue() {
        try {
            return oin.readObject();
        } catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setValue(Object obj) {

        String delim = ((Pattern) this.varAttr.getParam("delim")).toString();
        String end = ((Pattern) this.varAttr.getParam("end")). toString();
        System.out.println("FileStorage setValue " + filename);
        try {
            if (fout == null) {
                fout = new FileOutputStream(filename);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj instanceof Map) {
            Map tmp = (Map) obj;
            Set s = tmp.keySet();
            Iterator iter = s.iterator();
            boolean firstField = true;
            int count = 0;

            while (iter.hasNext()) {
                if (firstField == false) {
                    this.writeString(delim);
                    System.err.println("Written delim " + delim);
                } else
                    firstField = false;
                String tmpKey = (String) iter.next();
                Variable var = (Variable) tmp.get(tmpKey);
                //this.writeObject(var.getValue());
                this.writeString((String) var.getValue());
                System.err.println("Written " + var.getValue());
                //this.writeObject(delim);

            }
        } else {
            this.writeObject(obj);
            System.err.println("Else Written " + obj);
        }
        this.writeString(end);

    }

    public Iterator iterator(Map tmp) {
        return this.iterator(tmp, new VarAttr());
    }

    public Iterator iterator(Map tmp, VarAttr va) {
        Iterator    ret = null;

        try {
            /*
            if (fin != null) {
                din.close();
                //fin.close();
            }*/

            fin = new FileInputStream(filename);
            this.brd = new BufferedReader(new FileReader(this.filename));
            //this.brd.
            din = new DataInputStream(new BufferedInputStream(fin));
            
        } catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        } 
        
        if (va.isEmpty()) {
           System.out.println("Creating iterator FileStorage");
           //ret = new FileIterator(this, tmp);
           ret = new TextStreamIterator(this, tmp);
        }

        System.out.println("Creating iterator BYE??");

        return ret;
    }

    public void flush() {
        try {
            fout.flush();
        } catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeObject(Object obj) {
        try {
            //oout.writeUTF((String) obj);
            oout.writeUTF("joderrrrr");
            //oout.writeChars((String)obj);
        } catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeString(String obj) {
        try {
            //oout.writeObject ((obj));
            byte[] b = obj.getBytes();
            fout.write(b);

        } catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//XXX: Doesn't work with multichar varAttr.
    
    public String readField() {
        String  ret = "";
        String  t = "";
        byte     tmp;

        try {
            while (din.available() != 0) {
                tmp = din.readByte();
                t = String.valueOf((char) (tmp));
                //System.out.println(tmp + " T: " + t);
                ret += t;
                System.out.println("read: " + ret);
                this.EOF = this.endLine = false;
                if (ret.endsWith((String) this.varAttr.getParam("delim")) == true) {
                    t = ret.split((String)this.varAttr.getParam("delim"))[0];
                    break;
                }
                if (ret.endsWith((String) this.varAttr.getParam("end")) == true) {
                    t = ret.split((String)this.varAttr.getParam("end"))[0];
                    this.endLine = true;
                    System.out.println("ENDLINE!!!");
                    break;
                }

                /*if (ret.equals(this.varAttr.getParam("delim")) ||
                    ret.equals(this.varAttr.getParam("end"))) {
                    break;
                }*/
            }
            if (din.available() == 0)
                this.EOF = true;

        } catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

    public String readLine() {
        String  ret = null;

        try {
            ret = this.brd.readLine();
            System.out.println("FileStorage readLine " + ret);
        } catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public void setVarAttr(VarAttr va) {
        this.varAttr = va;
    }

    public VarAttr getVarAttr() {
        return this.varAttr;
    }

    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isEOL() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String[] readFields() {
        Pattern     p = (Pattern) this.varAttr.getParam("re_delim");
        String      line = null;
        String[]    ret = null;

        line = this.readLine();

        if (line != null)
            ret = p.split(line);
        else
            this.EOF = true;

        return ret;
    }

    public Object getValue(String val) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
