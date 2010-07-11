/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra.arch.variable.factories;

import culebra.arch.variable.Variable;
import culebra.arch.variable.behaviour.BehaviourParam;
import culebra.arch.variable.behaviour.VarAttr;
import culebra.arch.variable.storage.MySQLDBStorage;
import culebra.arch.variable.storage.Storage;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author Gabriel Gonzalez
 */
public class MySQLFactory 
extends StorageFactory {
    private Variable    var = null;

    public MySQLFactory(Variable var) {
        super();
        this.var = var;
    }

    @Override
    public Storage createStorage(VarAttr va) {
        throw new UnsupportedOperationException("Not enough Arguments for MySQL Behaviour");
    }

    @Override
    public Storage createStorage(VarAttr va, List l) {
        Storage ret = null;
        MySQLDBStorage msql = new MySQLDBStorage();
        String[]    data = null;

        Iterator iter = l.iterator();
        while (iter.hasNext()) {
            BehaviourParam  tmp = (BehaviourParam) iter.next();
            if (tmp.getParamName().regionMatches(true, 0, "user", 0, 4)) {
                msql.setUsername((String) tmp.getParamValue());
            } else if (tmp.getParamName().regionMatches(true, 0, "pass", 0, 4)) {
                msql.setPassword((String) tmp.getParamValue());
            } else if (tmp.getParamName().regionMatches(true, 0, "server", 0, 6)) {
                msql.setServer((String) tmp.getParamValue());
            } else if (tmp.getParamName().regionMatches(true, 0, "db", 0, 2)) {
                msql.setDataBase((String) tmp.getParamValue());
            } else if (tmp.getParamName().regionMatches(true, 0, "data", 0, 4)) {
                msql.setDataBase((String) tmp.getParamValue());
            } else {
                    System.err.println("createStorage(): Argument " + tmp.getParamName() + " not found.");
            }
            /*String tmp = (String) iter.next();

            data = tmp.split("=", 2);
            if (data.length == 2) {
                if (data[0].equalsIgnoreCase("user") ||
                    data[0].equalsIgnoreCase("username")) {
                    msql.setUsername(data[1].trim());
                } else if (data[0].equalsIgnoreCase("passwd")) {
                    msql.setPassword(data[1].trim());
                } else if (data[0].equalsIgnoreCase("server")) {
                    msql.setServer(data[1].trim());
                } else if (data[0].equalsIgnoreCase("db") ||
                           data[0].equalsIgnoreCase("database")) {
                    msql.setDataBase(data[1].trim());
                } else {
                    System.err.println("createStorage(): Argument " + data[0] + " not found.");
                }
            } else {
                System.err.println("createStorage(): Argument " + data[0] + " not well formed.");
            }*/
        }

        msql.setTable(this.var.getName());
        if (!msql.connect())
            System.err.println("MySQLFactory::createStorage(): Couldn't connect to the specified DB Server\n"
                    + msql.getServer() + "/" + msql.getDataBase() + " " + msql.getUsername() + "/" + msql.getPassword());

        msql.setVarAttr(va);
        ret = (Storage) msql;
        return ret;
    }
}