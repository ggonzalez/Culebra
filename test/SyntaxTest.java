/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import culebra.lexical.Scanner;
import culebra.syntax.SyntaxErrorManager;
import culebra.syntax.parser;
import java.io.FileReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel Gonzalez
 */
public class SyntaxTest {

    public SyntaxTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testSyntax() {
        String file = "source.culebra/test01.cu";
        
        try {
            SyntaxErrorManager.syntaxInfo("Input File: " + file);
            FileReader fReader = new FileReader(file);
            Scanner scanner = new Scanner(fReader);
            parser aParser = new parser(scanner);
            aParser.parse();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}