package resources;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.*;

import java.io.File;

public class ExcelUtilities {

    public ArrayList<LinkedList<String>> readExcelFile(String path){

        File fp = new File(path);
        try(InputStream inp = new FileInputStream(fp)){
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);

            int firstRow = sheet.getFirstRowNum();
            int lastRow  = sheet.getLastRowNum();

            for(int i = firstRow; i < lastRow; i++){
                Row row = sheet.getRow(i);

                for(int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++){
                    Cell cell = row.getCell(j);

                    switch(cell.getCellType()){

                        case STRING:
                            System.out.println(cell.getRichStringCellValue().getString());
                            break;

                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.println(cell.getDateCellValue());
                            } else {
                                System.out.println(cell.getNumericCellValue());
                            }
                            break;
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
