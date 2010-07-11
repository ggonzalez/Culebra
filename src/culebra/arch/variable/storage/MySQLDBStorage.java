/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.storage;

import culebra.arch.expressions.IntegerExpr;
import culebra.arch.expressions.StringExpr;
import culebra.arch.variable.Variable;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.iterator.DBIterator;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Gonzalez
 */
public class MySQLDBStorage
extends DBStorage {
    private VarAttr     varAttr;

    public MySQLDBStorage() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception E) {
            System.err.println("Unable to load driver Mysql Driver");
            E.printStackTrace();
        }
    }

    @Override
    public void setValue(Object obj) {
        // Split the query in two part so we can fill the column names and
        // values in the same loop
        String  query1 = "INSERT INTO " + this.getTable() + "(";
        String  query2 = "(";
        if (obj instanceof Map) {
            Map tmp = (Map) obj;
            Set s = tmp.keySet();
            Iterator iter = s.iterator();

            while (iter.hasNext()) {
                String      key = (String) iter.next();
                Variable    var = (Variable) tmp.get(key);
                
                query1 += key + ",";

                // XXX Hack, SimpleVariables only created when bv.var = lkajsfd;
                if (var != null) {
                    Object      o = var.getValue();
                    if (o == null) {
                        query2 += "'NULL'";
                    } else
                        query2 += "'" + o + "'";
                    /*} else if (o instanceof StringExpr) {
                        query2 += ((StringExpr) o).toString();
                    } else if (o instanceof IntegerExpr) {
                        IntegerExpr i = (IntegerExpr) o;
                        query2 += i.toString();
                    }*/
                } else
                    query2 += "NULL";
                //System.out.println(o);
                query2 += ",";
            }
//System.out.println("oxgtiassss");
            query1 = query1.replaceFirst(",$",")");
            query2 = query2.replaceFirst(",$",")");

        }
        try {
            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(query1 + " VALUES " + query2);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        //System.out.println(query1 + " VALUES " + query2);
    }

    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator iterator(List args) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean connect() {
        boolean ret = true;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + this.getServer() + "/" + this.getDataBase() +
                                                "?user=" + this.getUsername() + "&password=" + this.getPassword());
        } catch (SQLException e) {
            System.err.println("MySQLDB Error connecting to the database: " + e.getMessage());
            System.err.println("MySQLDB SQLState: " + e.getSQLState());
            ret = false;
        }
        return ret;
    }

    public void flush() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setVarAttr(VarAttr va) {
        this.varAttr = va;
    }

    public VarAttr getVarAttr() {
        return this.varAttr;
    }


    public Iterator iterator(Map tmp, VarAttr va) {
        return this.iterator(tmp);
    }

}
