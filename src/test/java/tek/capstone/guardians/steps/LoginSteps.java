package tek.capstone.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;
import tek.capstone.guardians.utilities.DataGenerator;

public class LoginSteps extends CommonUtility{
	
	POMFactory pomFactory = new POMFactory();
	@Given("User is on retail website home page")
	public void userIsOnRetailWebsiteHomePage() {
		Assert.assertTrue(pomFactory.homePage().tekschoolLogo.isDisplayed());
		logger.info("Tekschool Logo is displayed successfully");
	   
	}
	@Given("User click on sign in link button")
	public void userClickOnSignInLinkButton() {
		click(pomFactory.loginPage().signInlink);
		logger.info("SignIn link was clicked successfully");
		
	}
	@Given("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(pomFactory.loginPage().emailField, email);
		logger.info("email entered fuccessfully");
		sendText(pomFactory.loginPage().passwordField, password);
		logger.info("password entered successfully");
	}
	@Given("User click on login button")
	public void userClickOnLoginButton() {
		click(pomFactory.loginPage().loginBttn);
		logger.info("Login Button was clicked successfully");
	}
	@Then("User should be logged in into account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(pomFactory.loginPage().logoutField.isDisplayed());
		logger.info("User signed in was confirrmed successfully");
	}
	//--------register
	@Given("User click on create new account button")
	public void userClickOnCreateNewAccountButton() {
		click(pomFactory.loginPage().newAccountBttn);
		logger.info("Create New Account button was clicked successfully");
	}
	@Given("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> registerInfo = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.loginPage().nameInputField,
				DataGenerator.addressGenerator(registerInfo.get(0).get("name")));
		sendText(pomFactory.loginPage().emailInputField,
				DataGenerator.addressGenerator(registerInfo.get(0).get("email")));
		sendText(pomFactory.loginPage().passwordInputField, registerInfo.get(0).get("password"));
		sendText(pomFactory.loginPage().confirmPasswordInputField, registerInfo.get(0).get("confirmPassword"));
		logger.info("Account information was enterd successfully");
	}
	@Given("User click on SignUP button")
	public void userClickOnSignUPButton() {
		click(pomFactory.loginPage().signUpBttn);
		logger.info("SignUp button was clicked successfully");
	}
	@Then("User account should be created into retail page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(pomFactory.loginPage().profileText.isDisplayed());
		logger.info("User new account has been created successfully");
		
	 
	}
	
	
}
