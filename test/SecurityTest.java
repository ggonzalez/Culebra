/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import culebra.ModuleParser;
import culebra.security.arch.HookedFunction;
import culebra.semantic.FunctionManager;
import culebra.semantic.ModuleManager;
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
public class SecurityTest {

    public SecurityTest() {
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
    public void testHookedFunction() {
        String file = "source.culebra/security/auth.cu";

        HookedFunction  hf = new HookedFunction("*.is*", false);

        System.out.println("*.is.* caracola.isJodida " + hf.matches("caracola.isJodida"));
        System.out.println("*.is.* caracola.putamdre " + hf.matches("caracola.putamdre"));
        System.out.println("*.is.* caracola.is " + hf.matches("caracola.is"));

        hf = new HookedFunction("cara*la*.is*", false);

        System.out.println("cara*la*.is* caracola.isJodida " + hf.matches("caracola.isJodida"));
        System.out.println("cara*la*.is* caracolacara.putamdre " + hf.matches("caracolacara.putamdre"));
        System.out.println("cara*la*.is* caracolacara.is " + hf.matches("caracolacara.is"));
    }

    @Test
    public void testFunctionHooks() {
        String file = "source.culebra/security/main.cu";

        ModuleManager   mm = null;
        FunctionManager fm = null;

        mm = ModuleParser.parse(file);

        fm = mm.getFunctionManager();
        fm.getFunction("main").exec();
    }
}