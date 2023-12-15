package helpers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.C;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class TestDataReader {


    private static Sheet sheet;
    //XSSFWorkbook workbook;
    private static final Logger logger = Logger.getLogger(TestDataReader.class.getName());
    private int testCaseNameColumnIndex = 0;
    public static List<Object>  ExcelDataRead(String TestCaseName, String SheetName)
    {
        try {
            FileInputStream file = new FileInputStream(new File(ConfigReader.loadProperty().getProperty("dataPath")));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            sheet =workbook.getSheet(SheetName);

            for(Row row: sheet)
            {
                Cell cell = row.getCell(0);
                if(cell!=null && cell.getStringCellValue().equalsIgnoreCase(TestCaseName))
                {
                    List<Object> testData = new ArrayList<>();

                    //Iterator for iterating through the cells in the row
                    Iterator<Cell> cellIterator = row.cellIterator();

                    //skip the first cell as it's always the testcase name
                    cellIterator.hasNext();
                    while (cellIterator.hasNext())
                    {
                        Cell cellData = cellIterator.next();
                        switch (cellData.getCellType())
                        {
                            case STRING:
                                testData.add(cellData.getStringCellValue());
                                break;
                            case NUMERIC:
                                testData.add(cellData.getNumericCellValue());
                                break;
                            case BLANK:
                                testData.add(null);
                                break;
                            default:
                                throw  new RuntimeException("Unsupported Cell Type");
                        }
                    }
                    return testData;

                }
            }

            return null;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static int getColumnIndex(String columnName) {
        // Find the column index by column name
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equals(columnName)) {
                return cell.getColumnIndex();
            }
        }
        throw new RuntimeException("Column with name '" + columnName + "' not found.");
    }

    private void updateResultInExcel(String testCaseName, boolean testPassed) {
        for (Row row : sheet) {
            Cell cell = row.getCell(testCaseNameColumnIndex);
            if (cell != null && cell.getStringCellValue().equals(testCaseName)) {
                // Find the column index for the "Result" column
                int resultColumnIndex = getColumnIndex("Result");

                // Create a new cell for the result if not present
                Cell resultCell = row.getCell(resultColumnIndex);
                if (resultCell == null) {
                    resultCell = row.createCell(resultColumnIndex);
                }

                // Update the result based on testPassed
                resultCell.setCellValue(testPassed ? "Passed" : "Failed");
                logger.info("Updated result for test case '" + testCaseName + "'.");
                return;
            }
        }
        logger.warning("Test case '" + testCaseName + "' not found for result update.");
    }



}
