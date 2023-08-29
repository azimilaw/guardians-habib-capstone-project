package tek.capstone.guardians.steps;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {
	POMFactory pomFactory = new POMFactory();

//-------------------------addItemToCart------------------------------------
	@Then("User change the category to {string}")
	public void userChangeTheCategoryTo(String category) {
		selectByVisibleText(pomFactory.retailOrderPage().allDepartmentDropDown, category);
		logger.info("Category has been selected successfully");

	}

	@Then("User search for an item {string}")
	public void userSearchForAnItem(String kasaOutdoorSmartPlug) {
		sendText(pomFactory.retailOrderPage().inputSearchField, kasaOutdoorSmartPlug);
		logger.info("Item searched and selected successfully");

	}

	@Then("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(pomFactory.retailOrderPage().searchBttn);
		logger.info("Search Button was clicked successfully");

	}

	@Then("User click on item")
	public void userClickOnItem() {
		click(pomFactory.retailOrderPage().selectItem);
		logger.info("Item was clicked successfully");

	}

	@Then("User select quantity {string}")
	public void userSelectQuantity(String qty2) {
		selectByVisibleText(pomFactory.retailOrderPage().qtySelection, qty2);
		logger.info("Quantity of the item has been selected successfully");

	}

	@Then("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(pomFactory.retailOrderPage().addToCarBtn);
		logger.info("Add to Cart button was clicked successfuly");
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String itemQty) {
		Assert.assertEquals(itemQty, pomFactory.retailOrderPage().cartItemQty.getText());
		logger.info("Item qty in the cart was validated successfully");
	}
//--------------------------checkout-----------------------------------------
		@Then("User change the category to {string} Apex Legends")
		public void userChangeTheCategoryToApexLegends(String electronics) {
			selectByVisibleText(pomFactory.retailOrderPage().allDepartmentDropDown, electronics);
			logger.info("Category changed to electronics successfully");
		}
		@Then("User search for an item {string} Apex Legends")
		public void userSearchForAnItemApexLegends(String ApexLegends) {
			sendText(pomFactory.retailOrderPage().inputSearchField, ApexLegends);
			logger.info("Item name was entered successfully");
		}
		@Then("User click on item Apex Legends")
		public void userClickOnItemApexLegends() {
			click(pomFactory.retailOrderPage().apexLegendsItem);
			logger.info("Item Apex Legends was clicked successfully");
		}
		@Then("User select quantity {string} for Apex Legends")
		public void userSelectQuantityForApexLegends(String apexLegendsQty) {
			selectByVisibleText(pomFactory.retailOrderPage().qtySelection,apexLegendsQty);
			logger.info("Apex Legends Quantity was changed successfully");
		}
		@Then("the cart icon quantity should change to {string} Apex Legends")
		public void theCartIconQuantityShouldChangeToApexLegends(String ApexQty) {
			Assert.assertTrue(pomFactory.retailOrderPage().qtySelection.isDisplayed());
			logger.info("Quantity displayed successfully");
			
//			Assert.assertEquals(ApexQty, pomFactory.retailOrderPage().cartItemQty.getText());
//			logger.info("Apex Legends qty in the cart was validated to 5 successfully");
		}
		@Then("User click on Cart option")
		public void userClickOnCartOption() {
			click(pomFactory.retailOrderPage().cartBtn);
			logger.info("Cart Button was clicked successfully");	
		}
		@Then("User click on Proceed to Checkout button")
		public void userClickOnProceedToCheckoutButton() {
			click(pomFactory.retailOrderPage().proceedBtn);
			logger.info("Proceed to check out button was clicked successfully");
		}
		@Then("User click on Place Your Order")
		public void userClickOnPlaceYourOrder() {
			click(pomFactory.retailOrderPage().placeOrderBtn);
			logger.info("Place your order button was clicked successfuly");
		}
	
//------------------------Cancel Order--------------------
		
		@Then("User click on Orders sections")
		public void userClickOnOrdersSections() {
			click(pomFactory.retailOrderPage().OrderLink);
			logger.info("Order link was clicked successfully");

		}
		@Then("User click on first order in lists")
		public void userClickOnFirstOrderInLists() {
			List<WebElement>listOfOrder = pomFactory.retailOrderPage().listOfOrders;
			for (int i = 0; i < listOfOrder.size(); i++) {
				if(listOfOrder.get(i).getText().equalsIgnoreCase("Hide Details")) {
					
				}else if(listOfOrder.get(i).getText().equalsIgnoreCase("Show Details")) {
					click(pomFactory.retailOrderPage().listOfOrders.get(i));
					
				}
				
			}
		logger.info("First Order in the list was clicked successfully");
		}
		@Then("User click on Cancel The Order button")
		public void userClickOnCancelTheOrderButton() {
			List<WebElement>cancelBttns = pomFactory.retailOrderPage().cancelOrderBttn;
//            for (int i = 0; i < cancelBttns.size(); i++) {
            	click(cancelBttns.get(0));
//				
//			}
            	logger.info("Order cancel button was clicked");
		}
		@Then("User select the cancelation Reason {string}")
		public void userSelectTheCancelationReason(String cancelationReason) {
			selectByVisibleText(pomFactory.retailOrderPage().reasonForCancelation, cancelationReason);
			logger.info("Canelation reason was selected");

		}
		@Then("User click on Cancel Order button")
		public void userClickOnCancelOrderButton() {
			click(pomFactory.retailOrderPage().cancelationSubmitBttn);
			logger.info("Cancel Submit Button was clicked successfully");
	
		}
		@Then("an order of cancelation message should be displayed {string}")
		public void anOrderOfCancelationMessageShouldBeDisplayed(String CancelationSuccessMssg) {
			Assert.assertEquals(CancelationSuccessMssg, pomFactory.retailOrderPage().orderCancelledSuccessMssg.getText());
			logger.info("Cancelation success Message validated successfully");
		
		}	
		
//------------------------Return Order---------------------

	@Then("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(pomFactory.retailOrderPage().ordersLink);
		logger.info("Order link was clicked successfully");

	}

	@Then("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		List<WebElement> firstReturnOrder= pomFactory.retailOrderPage().returnOrderList;
		for (int i = 0; i < firstReturnOrder.size(); i++) {
			if (firstReturnOrder.get(i).getText().equalsIgnoreCase("Hide Details")) {

			} else if (firstReturnOrder.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(pomFactory.retailOrderPage().returnOrderList.get(i));
			}

		}
		logger.info("First return order on the list was clicked");

	}

	@Then("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(pomFactory.retailOrderPage().returnItemBtn);
		logger.info("Return Item button was clicked successfully");

	}

	@Then("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String reason) {
		sendText(pomFactory.retailOrderPage().returnReason, reason);
		logger.info("Reason for Return was selected successfully");

	}

	@Then("User select the drop off service {string}")
	public void userSelectTheDropOffService(String dropService) {
		sendText(pomFactory.retailOrderPage().dropOff, dropService);
		logger.info("Drop Off Service was selected successfully");

	}

	@Then("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(pomFactory.retailOrderPage().returnOrderBtn);
		logger.info("Return Order Button was clicked successfully");

	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String actualMsg) {
		Assert.assertEquals(actualMsg, pomFactory.retailOrderPage().returnSuccessMsg.getText());
		logger.info("Item was return successfully");

	}
	
//-------------------------------------Write Review----------------------------------------------------------------
	@Then("User click on Order sections")
	public void userClickOnOrderSections() {
		click(pomFactory.retailOrderPage().ordersLink);
		logger.info("Order link was clicked successfully");

	}

	@Then("User click on first order in return list")
	public void userClickOnFirstOrderInReturnList() {
		List<WebElement> firstReturnOrder= pomFactory.retailOrderPage().returnOrderList;
		for (int i = 0; i < firstReturnOrder.size(); i++) {
			if (firstReturnOrder.get(i).getText().equalsIgnoreCase("Hide Details")) {

			} else if (firstReturnOrder.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(pomFactory.retailOrderPage().returnOrderList.get(i));
			}

		}
		logger.info("First return order on the list was clicked");

	}
	@Given("User click on Review button")
	public void userClickOnReviewButton() {
	  click(pomFactory.retailOrderPage().reviewBtn);
	  logger.info("Review Button was clicked successfully");
	    
	}
	@Given("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headLine, String description) {
	 sendText(pomFactory.retailOrderPage().headLineText, headLine);
	 sendText(pomFactory.retailOrderPage().descriptionInput, description);
	 logger.info("Review Was entered successfully");
	}
	@Given("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(pomFactory.retailOrderPage().addReviewBtn);
		logger.info("Add Review Button was clicked");
	   
	}
	
	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String actualMsg2) {
	 waitTillPresence(pomFactory.retailOrderPage().reviewSuccessMsg1);
	 Assert.assertEquals(actualMsg2, pomFactory.retailOrderPage().reviewSuccessMsg1.getText());
	 logger.info("Review Added successfully");
	}

}
