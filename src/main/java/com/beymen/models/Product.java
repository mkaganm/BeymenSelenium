package com.beymen.models;

import core.utility.Logging;
import lombok.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Data
public class Product {

    private String brand;
    private String description;
    private String price;

    public void saveProductFile() {

        try {
            File productFile = new File("src/main/resources/product.txt");
            productFile.createNewFile();
            FileWriter writer = new FileWriter(productFile, false);
            writer.write("");
            writer.write(this.brand + "\n" + this.description + "\n" + this.price);
            writer.close();

        } catch (Exception e) {
            Logging.fail(e.getMessage());
        }
    }

    public static Product readProductTxt() {

        Product product = new Product();
        List<String> strList = new ArrayList<>();

        try {
            File file = new File("src/main/resources/product.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String str = bufferedReader.readLine();
            strList.add(str);
            while (str != null) {
                str = bufferedReader.readLine();
                strList.add(str);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Dosya okunurken bir hata oluştu.");
            e.printStackTrace();
        }

        product.setBrand(strList.get(0).toUpperCase());
        product.setDescription(strList.get(1).toUpperCase());
        product.setPrice(strList.get(2).toUpperCase());

        return product;
    }

}
