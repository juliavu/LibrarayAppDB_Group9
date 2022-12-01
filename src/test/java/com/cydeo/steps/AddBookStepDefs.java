package com.cydeo.steps;

import com.cydeo.pages.AddBookPage;
import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AddBookStepDefs {
    DashBoardPage dashBoardPage = new DashBoardPage();
    AddBookPage addBookPage = new AddBookPage();
    LoginPage loginPage = new LoginPage();

    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String user) {
        loginPage.login(user);
        BrowserUtil.waitFor(4);
    }
    @When("I navigate to {string} page")
    public void i_navigate_to_page(String string) {
    dashBoardPage.books.click();
    }
    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
    addBookPage.addBookBtn.click();

    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String string) {
    addBookPage.bookName.sendKeys("Anna Karenina");
    }
    @When("The librarian fill out the table")
    public void the_librarian_fill_out_the_table() {
        BrowserUtil.waitFor(1);
        addBookPage.bookYear.sendKeys("1877");
        BrowserUtil.waitFor(1);
        addBookPage.bookAuthor.sendKeys("Lev Tolstoi");

        BrowserUtil.waitFor(1);
        Select select = new Select(addBookPage.bookCategoryId);
        select.selectByValue("16");



    }
    @When("click the button save changes")
    public void click_the_button_save_changes() {
        BrowserUtil.waitFor(1);
        addBookPage.saveChangesBtn.click();
    }
    @When("the book has been created notification should appear")
    public void the_book_has_been_created_notification_should_appear() {
        BrowserUtil.waitFor(1);
    addBookPage.notification.isDisplayed();
    }
    @Then("the librarian should see this book in database")
    public void the_librarian_should_see_this_book_in_database() {
        DB_Util.createConnection();
        DB_Util.runQuery("select name from books\n" +
                "where name = 'Anna Karenina'");
        String actual = DB_Util.getFirstRowFirstColumn();
        String expected = "Anna Karenina";
        Assert.assertEquals(expected, actual);
    }


}
