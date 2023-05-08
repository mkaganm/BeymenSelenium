package com.beymen.pages;

import com.beymen.models.Product;
import core.driver.DriverChrome;
import core.utility.Logging;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By productBrand = By.xpath("//*[@class=\"m-basket__productInfoCategory\"]");
    private final By productDetails = By.xpath("//*[@class=\"m-basket__productInfoName\"]");
    private final By productPrice = By.xpath("//*[@class=\"m-productPrice__salePrice\"]");
    private final By pieceButton = By.xpath("//*[@id=\"quantitySelect0-key-0\"]");
    private final By value2 = By.xpath("//*[@value=\"2\"]");
    private final By removeCartItem = By.xpath("//*[@class=\"m-basket__remove btn-text\"]");

    DriverChrome core;

    public CartPage(DriverChrome driverChrome) {
        this.core = driverChrome;
    }

    private static final String EXPECTED = "Expected : ";
    private static final String ACTUAL = " Actual : ";
    public CartPage checkProductDetails() {

        String brandName = core.getElement(productBrand).getText().toUpperCase();
        String productName = core.getElement(productDetails).getText().toUpperCase();
        String price = core.getElement(productPrice).getText().toUpperCase();

        Product product = Product.readProductTxt();

        Logging.pass(product);

        core.control(product.getBrand().equals(brandName),
                EXPECTED + product.getBrand() + ACTUAL+ brandName,
                EXPECTED + product.getBrand() + ACTUAL + brandName);

        core.control(product.getDescription().equals(productName),
                EXPECTED + product.getDescription() + ACTUAL+ productName,
                EXPECTED + product.getDescription() + ACTUAL + productName);

        core.control(product.getPrice().equals(price),
                EXPECTED + product.getPrice() + ACTUAL + price,
                EXPECTED + product.getPrice() + ACTUAL + price);

        return this;
    }

    public CartPage clickPieceButton() {

        core.getElement(pieceButton).click();
        Logging.pass("Click piece button");

        return this;
    }

    public CartPage increaseQuantity() {

        try {
            core.getElement(value2).click();
            Logging.pass("Increase quantity");
        } catch (Exception e) {
            Logging.warning("Quantity error!");
        }

        return this;
    }

    public CartPage checkPiece() {

        String str = core.getElement(value2).getText();

        core.control(str.contains("2"),
                "Piece : " +str,
                "Piece " + str);

        return this;
    }

    public CartPage removeCartProduct() {

        core.getElement(removeCartItem).click();
        Logging.pass("Remove product from cart ");

        return this;
    }
}
