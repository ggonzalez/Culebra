/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage;

import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.iterator.TextStreamIterator;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Gabriel
 */
public class TCPStorage
implements TextStorage {
    private InputStream         in = null;
    private BufferedInputStream bin = null;
    private DataInputStream     din = null;
    private OutputStreamWriter  out = null;
    private Socket              sock = null;
    private ServerSocket        server = null;
    private String              host = null;
    private boolean             EOF = false;
    private boolean             EOL = false;
    private int                 port = 0;
    private VarAttr             varAttr = null;
    private InputStream         instream = null;

    public TCPStorage(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void setSocket(Socket sock) {
        this.sock = sock;
        BufferedInputStream test = null;
        try {
            this.instream = this.sock.getInputStream();
            this.din = new DataInputStream(new BufferedInputStream(this.sock.getInputStream()));
            this.out = new OutputStreamWriter(this.sock.getOutputStream(), "8859_1");
        } catch (IOException ex) {
            Logger.getLogger(TCPStorage.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("setSocket()");
            System.exit(-1);
        }
    }
    public ServerSocket getServer() {
        return server;
    }
    
    public Object getValue() {
        Object  ret = null;
        int     c = -1;
        
        try {
            while ((c = din.read()) != -1) {

            }
        } catch (IOException ex) {
            Logger.getLogger(TCPStorage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public void setValue(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void flush() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator iterator(Map tmp) {
        VarAttr tmpVa = new VarAttr();
        return this.iterator(tmp, tmpVa);
    }

    public Iterator iterator(Map tmp, VarAttr va) {
        Iterator    ret = null;

        if (va.getAttr().containsKey("server")) {
            try {
                server = new ServerSocket(port);
            } catch (IOException ex) {
                Logger.getLogger(TCPStorage.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
            ret = new TCPServerIterator(this, va, tmp);
        } else {
            try {
                sock = new Socket(host, port);
            } catch (UnknownHostException ex) {
                Logger.getLogger(TCPStorage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TCPStorage.class.getName()).log(Level.SEVERE, null, ex);
            }
            ret = new TextStreamIterator(this, tmp);
        }

        return ret;
    }

    public boolean isEOF() {
        return this.EOF;
    }

    public boolean isEOL() {
        return this.EOL;
    }

    public String readField() {
        String  ret = "";
        String  t = "";
        byte     tmp;

        try {
            System.out.println("WOOOOP");
            //while (din.available() != 0) {
            while (true) {
                tmp = din.readByte();
                t = String.valueOf((char) (tmp));
                System.out.println(tmp + " T: " + t);

                ret += t;
                if (ret.equals((String) this.varAttr.getParam("delim")) == true) {
                    while (din.available() != 0) {
                        tmp = din.readByte();
                        t = String.valueOf((char) tmp);
                        if (t.equals((String) this.varAttr.getParam("delim")) != true) {
                            ret = t;
                            break;
                        }
                    }
                }
                System.out.println("read: " + ret);
                this.EOF = this.EOL = false;
                if (ret.endsWith((String) this.varAttr.getParam("delim")) == true) {
                    t = ret.split((String)this.varAttr.getParam("delim"))[0];
                    break;
                }
                if (ret.endsWith((String) this.varAttr.getParam("end")) == true) {
                    t = ret.split((String)this.varAttr.getParam("end"))[0];
                    this.EOL = true;
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
            System.out.println("WOOOP BYEE");
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

    public String readLine() {
        String  ret = "";
        String  t = "";
        byte tmp = 0;
        
        try {
            /*while (din.available() != 0) {
                tmp = din.readByte();
                t = String.valueOf((char) tmp);
                if (t.equals((String) this.varAttr.getParam("end").toString()) == true) {
                    break;
                }
            ret += t;
            }*/
            if (this.server.isClosed()) {

            }
            while (true) {
                tmp = (byte) this.instream.read();
                t = String.valueOf((char) tmp);
                if (t.equals((String) this.varAttr.getParam("end").toString()) == true) {
                    break;
                }
                ret += t;
            }
        } catch (EOFException ex) {
            this.EOF = true;
        } catch (IOException ex) {
            Logger.getLogger(TCPStorage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public String[] readFields() {
        Pattern p = (Pattern) this.varAttr.getParam("re_delim");
        String line = null;
        String[] ret = null;

        line = this.readLine();

        if (line != null) {
            System.out.println("DEBUG: TCPStorage readFields " + line);
            ret = p.split(line);
        } else {
            this.EOF = true;
        }

        return ret;
    }

    public Object getValue(String val) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
