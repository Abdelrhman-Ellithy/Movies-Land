package UI.stepDefinitions;

import Pages.MoivePage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static UI.Base.BaseStepDefinition.driver;

public class SearchStepDefinitions {
    SearchPage searchPage;
    MoivePage moivePage;
    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage() throws InterruptedException {
            searchPage=new SearchPage(driver);
    }
    @When("they type a {string} into the search bar")
    public void they_type_a_search_query_into_the_search_bar(String name) {
        searchPage.searchItem(name);
        searchPage.clickEnter();
    }
    @When("they searches for \"Deadpool\" into the search bar")
    public void searchDeadpool(){
        searchPage.searchItem("Deadpool");
        searchPage.clickEnter();
    }

    @Then("the search query should be accepted and processed")
    public void the_search_query_should_be_accepted_and_processed() {
        String actualText=searchPage.getTextInSearchField();
        String expectedText="Deadpool";
        Assert.assertTrue(actualText.contains(expectedText));
    }
    @And("click on it's image")
    public void clickImage(){
        moivePage=searchPage.clickItem("533535");
    }
    @Then("the \"Deadpool\" movie should be displayed")
    public void movieCkick(){
        String actualTitle=moivePage.getMovieTitle();
        String expectedTitle="Deadpool & Wolverine";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Given("The user has entered a search query")
    public void the_user_has_entered_a_search_query() {
        searchPage.searchItem("Deadpool");
    }

    @When("they click the Search button or press Enter key")
    public void they_click_the_button_or_press_enter_key() {
        searchPage.clickEnter();
    }

    @Then("the search results page should display items matching the search query")
    public void the_search_results_page_should_display_items_matching_the_search_query() {
        List<String>names=searchPage.getResultsNames();
        int i=0;
        for (String name:names){
            i++;
            System.out.println(i+" - "+name.toLowerCase());
            Assert.assertTrue(name.toLowerCase().contains("Deadpool"));
        }
    }

    @Given("The user enters a search query")
    public void the_user_enters_a_search_query() {
        searchPage.searchItem("رئيس جمهورية للبيع");
    }

    @When("no items match the search query")
    public void no_items_match_the_search_query() {
        searchPage.clickEnter();
    }

    @Then("a {string} message should be displayed")
    public void a_message_should_be_displayed(String string) {
        List<String>results=searchPage.getResultsNames();
        Assert.assertEquals(results.size(),0, "فيه عندهم رئيس للبيع");
    }

    @Then("company products should be displayed")
    public void compny_products_should_be_displayed() {
        List<String>names=searchPage.getResultsNames();
        int i=0;
        for (String name:names){
            i++;
            System.out.println(i+" - "+name.toLowerCase());
            Assert.assertTrue(name.toLowerCase().contains("dell"));
        }
    }

    @Given("the user enters movie name partially in the search field")
    public void the_user_enters_product_name_partially_in_the_search_field() {
            searchPage.searchItem("Dead");
            searchPage.clickEnter();
    }

    @Then("products relevant to that name should be displayed")
    public void products_relevant_to_that_name_should_be_displayed() {
        List<String>names=searchPage.getResultsNames();
        int i=0;
        for (String name:names){
            i++;
            System.out.println(i+" - "+name.toLowerCase());
            Assert.assertTrue(name.toLowerCase().contains("Deadpool"));
        }
    }
}
