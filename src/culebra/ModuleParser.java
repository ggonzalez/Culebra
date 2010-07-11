/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package culebra;

import culebra.semantic.ModuleManager;
import culebra.syntax.SyntaxErrorManager;
import culebra.syntax.parser;
import java.io.FileReader;
import culebra.lexical.Scanner;

/**
 *
 * @author Gabriel Gonzalez
 */
public class ModuleParser {

    public static ModuleManager parse(String file) {
        ModuleManager ret = null;

        try {
            SyntaxErrorManager.syntaxInfo("Input File: " + file);
            FileReader fReader = new FileReader(file);
            Scanner scanner = new Scanner(fReader);
            parser aParser = new parser(scanner);
            ret = (ModuleManager) aParser.parse().value;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        
        return ret;
    }
}
