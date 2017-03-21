package edu.uniandes.ecos.CAIS.P4PSP2;

import edu.uniandes.ecos.CAIS.P4PSP2.controller.Program;
import edu.uniandes.ecos.CAIS.P4PSP2.model.Data;
import edu.uniandes.ecos.CAIS.P4PSP2.model.LogRanges;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    private Program program4;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
        this.program4 = new Program();
        String path = System.getProperty("user.dir");
        path += "/src/resources/files";
        this.program4.readFiles(path);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testLOCMethod() {
        Data value = (Data) this.program4.getData().getFirst();
        LogRanges ranges = value.getRanges();

        assertEquals("VS debe ser 4.3953", 4.3953, ranges.getVs(), 0.01);
        assertEquals("S debe ser 8.5081", 8.5081, ranges.getS(), 0.01);
        assertEquals("M debe ser 16.4696", 16.4696, ranges.getM(), 0.01);
        assertEquals("L debe ser 31.8811", 31.8811, ranges.getL(), 0.01);
        assertEquals("VL debe ser 61.7137", 61.7137, ranges.getVl(), 0.01);
    }

    /**
     * Rigourous Test :-)
     */
    public void testPgsChapter() {
        Data value = (Data) this.program4.getData().getLast();
        LogRanges ranges = value.getRanges();

        assertEquals("VS debe ser 6.3375", 6.3375, ranges.getVs(), 0.01);
        assertEquals("S debe ser 8.4393", 8.4393, ranges.getS(), 0.01);
        assertEquals("M debe ser 11.2381", 11.2381, ranges.getM(), 0.01);
        assertEquals("L debe ser 14.9650", 14.9650, ranges.getL(), 0.01);
        assertEquals("VL debe ser 19.9280", 19.9280, ranges.getVl(), 0.01);
    }
}
