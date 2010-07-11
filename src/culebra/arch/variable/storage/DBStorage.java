/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage;

import com.mysql.jdbc.Statement;
import culebra.arch.variable.storage.iterator.DBIterator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Gonzalez
 */
public abstract class DBStorage
implements Storage {
    protected Connection    conn = null;
    private String  username = null;
    private String  password = null;
    private String  server = null;
    private String  dataBase = null;
    private String  table = null;
    private ResultSet   res = null;

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
    
    abstract public boolean connect();

    public boolean isEOF() {
            boolean ret = false;
        try {
            ret = this.res.next();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDBStorage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return !ret;
    }

    public Object getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getValue(String val) {
        Object  ret = null;

        try {
            ret = this.res.getObject(val);
        } catch (SQLException ex) {
            Logger.getLogger(DBStorage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public void setValue(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator iterator(Map tmp) {
        Statement   stmt = null;
        String      query = "SELECT * FROM " + this.getTable();
        Iterator    iter = new DBIterator(this, tmp);

        try {
            stmt = (Statement) this.conn.createStatement();
            this.res = stmt.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return iter;
    }

    public Iterator iterator(List args) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
