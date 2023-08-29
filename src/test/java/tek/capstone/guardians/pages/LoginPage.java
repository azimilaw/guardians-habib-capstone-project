package tek.capstone.guardians.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class LoginPage extends BaseSetup {
	
	public LoginPage () {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText = "TEKSCHOOL")
	public WebElement tekSchoolLogo;
	
	@FindBy(id="signinLink")
	public WebElement signInlink;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement emailField;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordField;
	
	@FindBy(id="loginBtn")
	public WebElement loginBttn;
	
	@FindBy(id="logoutBtn")
	public WebElement logoutField;
	//---------------------------------register
	
	@FindBy(id="newAccountBtn")
	public WebElement newAccountBttn;
	
	@FindBy(id="nameInput")
	public WebElement nameInputField;
	
	@FindBy(id="emailInput")
	public WebElement emailInputField; 
	
	@FindBy(xpath="//input[@id='passwordInput']")
	public WebElement passwordInputField; 
	
	@FindBy(id="confirmPasswordInput")
	public WebElement confirmPasswordInputField; 
	
	@FindBy(id="signupBtn")
	public WebElement signUpBttn; 
	
	@FindBy(xpath="//h1[text()='Your Profile']")
	public WebElement profileText;
	
	
}
