    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import culebra.ModuleParser;
import culebra.lexical.Scanner;
import culebra.semantic.FunctionManager;
import culebra.semantic.ModuleManager;
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
 * @author Gabriel
 */
public class BasicFeatTest {

    public BasicFeatTest() {
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


    @Test
    public void testPrintln() {
        String file = "source.culebra/test-println.cu";

       /* try {
            SyntaxErrorManager.syntaxInfo("Input File: " + file);
            FileReader fReader = new FileReader(file);
            Scanner scanner = new Scanner(fReader);
            parser aParser = new parser(scanner);
            aParser.parse();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        */
    }
    
    @Test
    public void testFunctionArgs() {
        String file = "source.culebra/test-func.cu";
        ModuleManager   mm = null;
        FunctionManager fm = null;

        try {
            SyntaxErrorManager.syntaxInfo("Input File: " + file);
            FileReader fReader = new FileReader(file);
            Scanner scanner = new Scanner(fReader);
            parser aParser = new parser(scanner);
            mm = (ModuleManager) aParser.parse().value;
            fm = mm.getFunctionManager();
            fm.getFunction("main").exec();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    
    @Test
    public void testBigNum() {
        String file = "source.culebra/test-bignum.cu";
        
        ModuleManager   mm = null;
        FunctionManager fm = null;
        
        mm = ModuleParser.parse(file);

        fm = mm.getFunctionManager();
        fm.getFunction("main").exec();
    }
    
    /*@Test
    public void testExpr() {
    String file = "source.culebra/test-expr.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }*/
    @Test
    public void testWhile() {
    String file = "source.culebra/test-while.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }

    @Test
    public void testForLoop() {
    String file = "source.culebra/test-for.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }
    @Test
    public void testModuleFunctions() {
    String file = "source.culebra/test-modules.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }

    @Test
    public void testIOSentences() {
    String file = "source.culebra/test-io.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }

    @Test
    public void testListVariables() {
    String file = "source.culebra/test-listVariable.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }

    @Test
    public void testIterator() {
    String file = "source.culebra/test-iterator.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }

    @Test
    public void testBehaviourVars() {
    String file = "source.culebra/test-behaviourVars.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }
/*
    @Test
    public void testFileVars() {
    String file = "source.culebra/test-fileVar.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }
    /*
    @Test
    public void testSocketTCP() {
    String file = "source.culebra/test-socket-tcp.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }

    @Test
    public void testSocketTCPServer() {
    String file = "source.culebra/test-socket-tcp-server.cu";

    ModuleManager   mm = null;
    FunctionManager fm = null;

    mm = ModuleParser.parse(file);

    fm = mm.getFunctionManager();
    fm.getFunction("main").exec();
    }

*/
    @Test
    public void testMySQLRead() {
        String file = "source.culebra/test-mysql-read.cu";

        ModuleManager mm = null;
        FunctionManager fm = null;

        mm = ModuleParser.parse(file);

        fm = mm.getFunctionManager();
        fm.getFunction("main").exec();
    } 
}