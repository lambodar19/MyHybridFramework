/*
package com.qa.testcases;

import TestBase.Base;
import helpers.TestDataReader;
import org.testng.annotations.Test;

import java.util.List;

public class excelTest extends Base {

    @Test
    public void excelT()

    {
       List<Object> testData = TestDataReader.ExcelDataRead("Random","Sheet1");
        if (testData == null) {
            throw new RuntimeException("Test data for 'TC_001_Post_Vacancy' not found in the Excel sheet.");

        }

        String name = (String) testData.get(TestDataReader.getColumnIndex("JobTitle"));
        System.out.println(name);



        String methodofapp = (String) testData.get(TestDataReader.getColumnIndex("MethodOfApplication"));
        System.out.println(methodofapp);
    }
}
*/
