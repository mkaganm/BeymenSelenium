package com.beymen.data;

import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class GetDataXLSFile {

    private List<String> listProduct = new ArrayList<>();

    private static GetDataXLSFile data = new GetDataXLSFile();

    public static void setData(){


        try {
            FileInputStream file = new FileInputStream(new File("src/main/resources/data.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(0);
            Cell cell1 = row.getCell(0);
            Cell cell2 = row.getCell(1);

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

}
