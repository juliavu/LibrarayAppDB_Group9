package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBookPage {
    public AddBookPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement bookName;

    @FindBy(xpath = "//a[@class = 'btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")
    public WebElement addBookBtn;

    @FindBy(xpath = "//input[@name = 'year']")
    public WebElement bookYear;

    @FindBy(xpath = "//input[@name = 'author']")
    public WebElement bookAuthor;

    @FindBy(xpath = "//select[@id = 'book_group_id']")
    public WebElement bookCategoryId;

    @FindBy(xpath = "//button[@class = 'btn btn-primary']")
    public WebElement saveChangesBtn;


    @FindBy(xpath = "//div[@class = 'toast-message']")
    public WebElement notification;
}
