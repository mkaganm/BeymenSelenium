package com.beymen.pages;

import com.beymen.models.Product;
import core.driver.DriverChrome;
import core.utility.Logging;
import org.openqa.selenium.By;

import java.security.SecureRandom;

public class ProductPage extends BasePage {

    DriverChrome core;

    SecureRandom random = new SecureRandom();

    private final By productList =  By.xpath("//*[@class=\"col-sm-4 col-md-4 col-lg-4 col-xl-4 col-xxl-3 o-productList__itemWrapper\"]");
    private final By productPrice = By.xpath("//*[@id=\"priceNew\"]");
    private final By productDescription = By.xpath("//*[@class=\"o-productDetail__description\"]");
    private final By productBrand = By.xpath("//*[@class=\"o-productDetail__brandLink\"]");
    private final By adCartButton = By.xpath("//*[@id=\"addBasket\"]");
    private final By productSizeList = By.xpath("//*[@class=\"m-variation__item\"]");
    private final By productSizeList2 = By.xpath("//*[@class=\"m-variation__item -criticalStock\"]");
    private final By goToCartButton = By.xpath("//*[@class=\"icon icon-cart icon-cart-active\"]");


    public ProductPage(DriverChrome driver) {
        core = driver;
    }

    public ProductPage selectRandomProduct() {

        int size = core.getElements(productList).size();
        core.getElements(productList).get(random.nextInt(size)).click();
        Logging.pass("Select random product");
        return this;
    }

    public ProductPage saveProductDetails() {

        Product product = new Product();

        product.setPrice(core.getElement(productPrice).getText());
        product.setDescription(core.getElement(productDescription).getText());
        product.setBrand(core.getElement(productBrand).getText());

        Logging.pass("Product Details : " + product.getDescription());
        Logging.pass("Product Brand : " + product.getBrand());
        Logging.pass("Product Price : " + product.getPrice());

        product.saveProductFile();

        return this;
    }

    public ProductPage clickAddCartButton() {

        core.getElement(adCartButton).click();
        Logging.pass("Click add cart button");
        core.wait1s();
        return this;
    }

    public ProductPage selectProductSize() {

        if (!core.getElements(productSizeList).isEmpty()){

            core.getElements(productSizeList).get(0).click();

        } else if (!core.getElements(productSizeList2).isEmpty()) {

            core.getElements(productSizeList2).get(0).click();

        } else {
            Logging.fail("Product size is NOT available!");
        }

        core.wait1s();

        return this;
    }

    public ProductPage clickGoToCartButton() {

        core.getElement(goToCartButton).click();
        Logging.pass("Click go to cart button");

        return this;
    }

    public CartPage getCartPage() {
        return new CartPage(core);
    }



}
