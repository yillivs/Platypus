package resources;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.*;

import java.io.File;

/**
 * Excel reader class for single sheet workbook.
 */
public class ExcelUtilities {
    /**
     * Reads a single sheet as row and columns.
     * @param path filepath to target file
     * @return Arraylist storing rows of linked list storing columns in String form
     */
    public ArrayList<LinkedList<String>> readExcelFile(String path){

        ArrayList<LinkedList<String>> retVal = new ArrayList<>();

        File fp = new File(path);
        try(InputStream inp = new FileInputStream(fp)){
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);

            int firstRow = sheet.getFirstRowNum();
            int lastRow  = sheet.getLastRowNum();

            for(int i = firstRow; i <= lastRow; i++){
                Row row = sheet.getRow(i);
                LinkedList<String> columnString = new LinkedList<>();

                for(int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++){
                    Cell cell = row.getCell(j);


                    switch(cell.getCellType()){

                        case STRING:
                            columnString.add(cell.getStringCellValue());
                            break;

                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.println(cell.getDateCellValue());
                            } else {
                                columnString.add(Double.toString(cell.getNumericCellValue()));
                            }
                            break;
                    }
                }
                retVal.add(columnString);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return retVal;
    }
}
