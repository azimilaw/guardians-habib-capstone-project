package tek.capstone.guardians.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	//---------------Update Information------------
	@FindBy(id="accountLink")
	public WebElement accountOption;
	
	@FindBy(id="nameInput")
	public WebElement nameField;
	
	@FindBy(id="personalPhoneInput")
	public WebElement phoneNumberField;
	
	@FindBy(id="personalUpdateBtn")
	public WebElement updateBtn;
	
	@FindBy(xpath="//div[text()='Personal Information Updated Successfully']")
	public WebElement updatedMssg;
	//--------------AddPayment----------------------
	
	@FindBy(xpath="//p[text()='Add a payment method']")
	public WebElement addPaymentLink;
	
	@FindBy(id="cardNumberInput")
	public WebElement cardNumberField;
	
	@FindBy(id="nameOnCardInput")
	public WebElement cardNameField;
	
	@FindBy(id="expirationMonthInput")
	public WebElement cardMonth;
	
	@FindBy(id="expirationYearInput")
	public WebElement cardYear;
	
	@FindBy(id="securityCodeInput")
	public WebElement securityCode;
	
	@FindBy(id="paymentSubmitBtn")
	public WebElement addBtnCard;
	
	@FindBy(xpath="//div[text()='Payment Method added sucessfully']")
	public WebElement successedMssg;
	//--------------ChangeCard--------------------------------
	@FindBy(xpath="//div[@class='account__payment-image-wrapper']")
	public WebElement accountPayment;
	
	@FindBy(xpath="//button[text()='Edit']")
	public WebElement editBtn;
	
	@FindBy(id="cardNumberInput")
	public WebElement cardNumber2;
	
	@FindBy(id="nameOnCardInput")
	public WebElement nameOnCard;
	
	@FindBy(id="expirationMonthInput")
	public WebElement monthInput;
	
	@FindBy(id="expirationYearInput")
	public WebElement yearInout;
	
	@FindBy(id="securityCodeInput")
	public WebElement cardCode;
	
	@FindBy(xpath="//button[text()='Update Your Card']")
	public WebElement updatCardBtn2;
	
	@FindBy(xpath="//div[text()='Payment Method updated Successfully']")
	public WebElement updatedCardSuccessMssg;
//---------------CardRemove-------------------------------
	@FindBy(xpath="//p[@class='account__payment-sub-title']")
	public WebElement masterCardBtn;
	
	
	@FindBy(xpath="//button[text()='remove']")
	public WebElement removBtn;
	
	@FindBy(xpath="//div[@class='account__payment-sub']")
	public WebElement cardremoval1;


	
//--------------AddAddress-----------------------
	
	@FindBy(xpath = "//div[starts-with(@class,'account__address-new-')]")
	public WebElement addAddressLink;
	
	@FindBy(id = "countryDropdown")
	public WebElement addressCountryDropdown;
	
	@FindBy(id = "fullNameInput")
	public WebElement addressNameField;
	
	@FindBy(id = "phoneNumberInput")
	public WebElement addressPhoneField;
	
	@FindBy(id = "streetInput")
	public WebElement addressStreetField;
	
	@FindBy(id = "apartmentInput")
	public WebElement addressApartmentNum;
	
	@FindBy(id = "cityInput")
	public WebElement addressCityField;
	
	@FindBy(name = "state")
	public WebElement addressStateDropdown;
	
	@FindBy(id = "zipCodeInput")
	public WebElement addressZipCodeField;
	
	@FindBy(id = "addressBtn")
	public WebElement addressAddBttn;
	
	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressSuccessMssg;
	//--------------Edit Address-----------------------
	@FindBy(xpath="//button[text()='Edit']")
	public WebElement addressEditBtn;
	
	@FindBy(id="countryDropdown")
	public WebElement countryList;
	
	@FindBy(id="fullNameInput")
	public WebElement fullName;
	
	@FindBy(id="phoneNumberInput")
	public WebElement phoneNumber;
	
	@FindBy(id="streetInput")
	public WebElement streetAddress;
	
	@FindBy(id="apartmentInput")
	public WebElement aptNumber;
	
	@FindBy(id="cityInput")
	public WebElement cityName;
	
	@FindBy(xpath="//select[@name='state']")
	public WebElement stateName;
	
	@FindBy(id="zipCodeInput")
	public WebElement zipCode;
	
	@FindBy(id="addressBtn")
	public WebElement updatBtn;
	
	@FindBy(xpath="//div[text()='Address Updated Successfully']")
	public WebElement addressEditSuccessMssg;
	
	//-------------Remove Address-----------------------
	
	@FindBy(xpath="//button[text()='Remove']")
	public WebElement removeAddressBtn;
	
	@FindBy(xpath="//div[@class='account__address-btn-wrapper']")
	public WebElement addressBar1;

}
