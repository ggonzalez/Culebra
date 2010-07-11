/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import culebra.lexical.LexicalErrorManager;
import culebra.lexical.Token;
import java.io.FileReader;
import culebra.lexical.Scanner;
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
public class LexicalTest {

    public LexicalTest() {
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
    public void lexicalTest() {
        String file = "source.culebra/test01.cu";
        try {
            LexicalErrorManager.lexicalInfo("Input File: " + file);

            FileReader fReader = new FileReader(file);

            Scanner scanner = new Scanner(fReader);
            Object obj = scanner.next_token();

            while (obj instanceof Token) {
                Token token = (Token) obj;

                LexicalErrorManager.lexicalInfo(token);
                obj = scanner.next_token();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
