package tecketBookingDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ticketBookingMethods.BookATicket;

public class BookATicketSteps {
	BookATicket bt = new BookATicket();
	String result;

	@Given("I want to open the Web browser enter websiteURL {string}")
	public void i_want_to_open_the_web_browser_enter_website_url(String url) throws InterruptedException {
		result = bt.openBrowser_navigate(url);
	}
	
	@And("validate the website title")
	public void validate_the_website_title() throws InterruptedException {
		String expectTitle = "Home Page | Mail Travel";
		Assert.assertEquals(expectTitle, bt.validateTitle());
	}

	@When("search {string}")
	public void search(String srchtxt) throws InterruptedException {
		
			bt.search(srchtxt);
	}

		@Then("Click MoreInfo on the first result")
	public void clickMoreInfo() throws InterruptedException {

			bt.clickMore();
			
		
	}

	@Then("Make sure it displaying days Price telephoneNumber")
	public void make_sure_it_displaying_days_price_telephone_number() {
		Assert.assertTrue(bt.isElementPresent(By.xpath("//*[@id=\"price-pin\"]")), "Day Price is not present");
		Assert.assertTrue(bt.isElementPresent(By.xpath("//*[@id=\"supplier-phone\"]")), "Day Price is not present");
	
	}

	@Then("Click BookOnline")
	public void click_book_online() throws InterruptedException {
			bt.bookOnline();
		
	}

	@Then("Check for first Available Date is selected")
	public void check_for_first_available_date_is_selected() throws InterruptedException {
	
			bt.defaultRadio();
		

	}

	@Then("Click Continue")
	public void click_continue() throws InterruptedException {
		
			bt.clickContinue();
		} 

	@Then("Select standard room")
	public void select_standard_room() throws InterruptedException {
		bt.selRoom();
	}

	@Then("Click select your room and continue")
	public void click_select_your_room_and_continue() throws InterruptedException {
		
			bt.clickRoomContinue();
		
	}

	@And("Click Continue without extra")
	public void click_continue_without_extra() throws InterruptedException {
	
			bt.clickRoomWithoutExtra();
		
	}

	@Then("Fill in Passanger Detail")
	public void fill_in_passanger_detail() throws InterruptedException  {

		bt.passengerForm();
	}
	
	@Then("Verify Payment amount as per selected Accomodation")
	public void verify_payment_amount_as_per_selected_accomodation()  throws InterruptedException {
		Assert.assertTrue(bt.comp2());
		bt.quitDriver();
	}

}
