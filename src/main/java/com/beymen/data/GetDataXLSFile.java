package com.beymen.data;

import core.utility.Logging;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class GetDataXLSFile {

    private List<String> listProduct = new ArrayList<>();

    private static GetDataXLSFile data;

    public static void setData(){


        try {
            FileInputStream file = new FileInputStream(new File("src/main/resources/data.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(0); // 0. satırı al
            Cell cell1 = row.getCell(0); // A1 hücresini al
            Cell cell2 = row.getCell(1); // B1 hücresini al

            String cellValue1 = cell1.getStringCellValue();
            String cellValue2 = cell2.getStringCellValue();

            data.setListProduct(List.of(cellValue1, cellValue2));

            file.close();
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static GetDataXLSFile getParameters() {
        setData();
        return data;
    }

    public static void main(String[] args) {
        setData();
    }

}
