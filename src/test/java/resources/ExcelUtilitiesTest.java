package resources;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ExcelUtilitiesTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void readExcelFile() {
        ExcelUtilities testExcel = new ExcelUtilities();
        ArrayList<LinkedList<String>> actual = testExcel.readExcelFile("src/test/assets/valid.xlsx");
        assertEquals(actual, testExcel.readExcelFile("src/test/assets/valid.xlsx"));
    }
}