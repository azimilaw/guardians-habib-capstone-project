package tek.capstone.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;
import tek.capstone.guardians.utilities.DataGenerator;

public class RetailAccountSteps extends CommonUtility {
	POMFactory pomFactory = new POMFactory();

	// -----updateInformation-----------------------------------------------------
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(pomFactory.retailAccountPage().accountOption);
		logger.info("Account option was clicked");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String Name, String phone) {
		clearTextUsingSendKeys(pomFactory.retailAccountPage().nameField);
		clearTextUsingSendKeys(pomFactory.retailAccountPage().phoneNumberField);
		sendText(pomFactory.retailAccountPage().nameField,DataGenerator.addressGenerator(Name));
		sendText(pomFactory.retailAccountPage().phoneNumberField, DataGenerator.addressGenerator(phone));
		logger.info("Name and Phone mumber were enterd");
	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(pomFactory.retailAccountPage().updateBtn);
		logger.info("Update Button was clicked");

	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(pomFactory.retailAccountPage().updatedMssg);
		String expectedMssg = "Personal Information Updated Successfully";
		Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().updatedMssg.getText());
		logger.info("Account is updated successfully");
	}

///-----------AddPayment--------------------------------------------------------------------
	@When("User click on Account options")
	public void userClickOnAccountOptions() {
		click(pomFactory.retailAccountPage().accountOption);
		logger.info("Account options was clicked");
	}
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(pomFactory.retailAccountPage().addPaymentLink);
		logger.info("Payment Method Link was clicked successfully");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.retailAccountPage().cardNumberField, 
				DataGenerator.addressGenerator(paymentInfo.get(0).get("cardNumber")));	
				sendText(pomFactory.retailAccountPage().cardNameField, 
				DataGenerator.addressGenerator(paymentInfo.get(0).get("nameOnCard")));
		selectByVisibleText(pomFactory.retailAccountPage().cardMonth, paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.retailAccountPage().cardYear, paymentInfo.get(0).get("expirationYear"));
		sendText(pomFactory.retailAccountPage().securityCode, paymentInfo.get(0).get("securityCode"));
		logger.info("Card Information was entered successfully");
	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(pomFactory.retailAccountPage().addBtnCard);
		logger.info("Payment submitted button was clicked successfully");

	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMssg) {
		if (expectedMssg.contains("Payment Method added")) {
			waitTillPresence(pomFactory.retailAccountPage().successedMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().successedMssg.getText());
			logger.info("Expected Message" + expectedMssg);
		} else if (expectedMssg.contains("Address Added")) {
			waitTillPresence(pomFactory.retailAccountPage().addressSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().addressSuccessMssg.getText());
			logger.info("Expected Message" + expectedMssg);
		} else if (expectedMssg.contains("Payment Method updated")) {
			waitTillPresence(pomFactory.retailAccountPage().updatedCardSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().updatedCardSuccessMssg.getText());
			logger.info("Card Information updated successfully");
		} else if (expectedMssg.contains("Address Updated")) {
			waitTillPresence(pomFactory.retailAccountPage().addressEditSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().addressEditSuccessMssg.getText());
			logger.info("Address Was updated successfully");
		}else if(expectedMssg.contains("Order Placed")) {
			waitTillPresence(pomFactory.retailOrderPage().orderPlacedSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailOrderPage().orderPlacedSuccessMssg.getText());
			logger.info("Order placed Successfully");
		}
	}

	// -----------------------------------EditPayment----------------------------------------------------
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(pomFactory.retailAccountPage().accountPayment);
		logger.info("Cards and Account button was clicked successfuly");
	}

	@When("User click on Edit button of card section")
	public void userClickOnEditButtonOfCardSection() {
		click(pomFactory.retailAccountPage().editBtn);
		logger.info("Edit button was clicked ");

	}

	@When("User edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(pomFactory.retailAccountPage().cardNumber2);
		sendText(pomFactory.retailAccountPage().cardNumber2, 
				DataGenerator.addressGenerator(cardInfo.get(0).get("cardNumber")));
		sendText(pomFactory.retailAccountPage().nameOnCard, 
						DataGenerator.addressGenerator(cardInfo.get(0).get("nameOnCard")));

		selectByVisibleText(pomFactory.retailAccountPage().monthInput, cardInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.retailAccountPage().yearInout, cardInfo.get(0).get("expirationYear"));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().cardCode);
		sendText(pomFactory.retailAccountPage().cardCode, cardInfo.get(0).get("securityCode"));
		logger.info("Card Information entered successfully");
	}

	@When("User click on Update Your card button")
	public void userClickOnUpdateYourCardButton() {
		click(pomFactory.retailAccountPage().updatCardBtn2);
		logger.info("Updat Button was clicked successfully");
	}

	// ---------------------Remove payment-----------
	@When("User click on Card option")
	public void userClickOnCardOption() {
		click(pomFactory.retailAccountPage().masterCardBtn);
		logger.info("Master Card button was clicked");

	}
	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(pomFactory.retailAccountPage().removBtn);
		logger.info("Remove button was clicked successfully");

	}
	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		if(!isElementDisplayed(pomFactory.retailAccountPage().cardremoval1)) {
		logger.info("Card removed successfully");
	} else {
		logger.info("Card is not removed");
	
	}
	}
//--------------------AddAddress------------------------------------------------------
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(pomFactory.retailAccountPage().addAddressLink);
		logger.info("AddressAdd link Was clicked successfully");
	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable2) {
		List<Map<String, String>> addressInfo = dataTable2.asMaps(String.class, String.class);
		selectByVisibleText(pomFactory.retailAccountPage().addressCountryDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
		sendText(pomFactory.retailAccountPage().addressNameField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		sendText(pomFactory.retailAccountPage().addressPhoneField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		sendText(pomFactory.retailAccountPage().addressStreetField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		sendText(pomFactory.retailAccountPage().addressApartmentNum,
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		sendText(pomFactory.retailAccountPage().addressCityField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		sendText(pomFactory.retailAccountPage().addressStateDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		sendText(pomFactory.retailAccountPage().addressZipCodeField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));
		logger.info("Address Form Was filled out Successfully");
	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(pomFactory.retailAccountPage().addressAddBttn);
		logger.info("Address Add Button Was clicked successfully");
	}
	// --------------------Edit Address-----------------------------

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(pomFactory.retailAccountPage().addressEditBtn);
		logger.info("Edit Button was clicked successfully");

	}

	@When("user fill new address form with below informations")
	public void userFillNewAddressFormWithBelowInformations(DataTable dataTable) {
		List<Map<String, String>> addressInfo1 = dataTable.asMaps(String.class, String.class);

		selectByVisibleText(pomFactory.retailAccountPage().countryList, addressInfo1.get(0).get("country"));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().fullName);
		sendText(pomFactory.retailAccountPage().fullName, 
				DataGenerator.addressGenerator(addressInfo1.get(0).get("fullName")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().phoneNumber);
		sendText(pomFactory.retailAccountPage().phoneNumber, 
				DataGenerator.addressGenerator(addressInfo1.get(0).get("phoneNumber")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().streetAddress);
		sendText(pomFactory.retailAccountPage().streetAddress, 
				DataGenerator.addressGenerator(addressInfo1.get(0).get("streetAddress")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().aptNumber);
		sendText(pomFactory.retailAccountPage().aptNumber, 
				DataGenerator.addressGenerator(addressInfo1.get(0).get("apt")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().cityName);
		sendText(pomFactory.retailAccountPage().cityName, 
				DataGenerator.addressGenerator(addressInfo1.get(0).get("city")));	
		clearTextUsingSendKeys(pomFactory.retailAccountPage().stateName);
		sendText(pomFactory.retailAccountPage().stateName, 
				DataGenerator.addressGenerator(addressInfo1.get(0).get("state")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().zipCode);
		sendText(pomFactory.retailAccountPage().zipCode, 
				DataGenerator.addressGenerator(addressInfo1.get(0).get("zipCode")));
	
		sendText(pomFactory.retailAccountPage().zipCode, addressInfo1.get(0).get("zipCode"));
		logger.info("Address Information was clicked successfully");
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(pomFactory.retailAccountPage().updatBtn);
		logger.info("Update button was clicked successfully");

	}

	@Then("a message should be displayed ‘Address Updated Successfully’")
	public void aMessageShouldBeDisplayedAddressUpdatedSuccessfully() {

		logger.info("Update button was clicked successfully");
	}
	// --------------------Remove Address-----------------------------

	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(pomFactory.retailAccountPage().removeAddressBtn);
		logger.info("Remove Button was clicked successfully");

	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		if(!isElementDisplayed(pomFactory.retailAccountPage().addressBar1));
		logger.info("removed address successfully");
	}

}
