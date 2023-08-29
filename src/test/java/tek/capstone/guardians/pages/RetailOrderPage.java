package tek.capstone.guardians.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//select[@id='search']")
	public WebElement allDepartmentDropDown;
	
	@FindBy(id="searchInput")
	public WebElement inputSearchField;
	
	@FindBy(id = "searchBtn")
	public WebElement searchBttn;
	
	@FindBy(xpath="//img[starts-with(@alt,'Kasa Outdoor')]")
	public WebElement selectItem;
	
	@FindBy(xpath="//select[starts-with(@class,'product')]")
	public WebElement qtySelection;
	
	@FindBy(id="addToCartBtn")
	public WebElement addToCarBtn;
	
	@FindBy(xpath = "//span[@id='cartQuantity']")
	public WebElement cartItemQty;
	
//-------------check out-----------------------------
	@FindBy(xpath="//p[text()='Cart ']")
	public WebElement cartBtn;
	
	@FindBy(id="proceedBtn")
	public WebElement proceedBtn;
	
	@FindBy(id="placeOrderBtn")
	public WebElement placeOrderBtn;
	
	@FindBy(xpath="//div[text()='Order Placed Successfully']")
	public WebElement orderPlacedSuccessMssg;
	
	@FindBy(xpath="//img[starts-with(@alt,'Apex Legends')]")
	public WebElement apexLegendsItem;
	
//-----------------Cancel order-------------------------
	@FindBy(id = "orderLink")
	public WebElement OrderLink;
	
	@FindBy(xpath = "//div[@class='order']//descendant::p[7]")
	public List<WebElement> listOfOrders;
	
	@FindBy(xpath = "//button[text()='Cancel The Order']")
	public List<WebElement> cancelOrderBttn;
	
	@FindBy(id = "reasonInput")
	public WebElement reasonForCancelation;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement cancelationSubmitBttn;
	
	@FindBy(xpath = "//p[text()='Your Order Has Been Cancelled']")
	public WebElement orderCancelledSuccessMssg;
	
//-----------------Return Order--------------------------
	
	@FindBy(id="orderLink")
	public WebElement ordersLink;
	
	
	@FindBy(xpath="(//p[@class='order__header-btn'])")
	public List<WebElement> returnOrderList;
	
	@FindBy(xpath="//button[@id='returnBtn']")
	public WebElement returnItemBtn;
	
	@FindBy(xpath="//select[@id='reasonInput']")
	public WebElement returnReason;
	
	@FindBy(xpath="//select[@id='dropOffInput']")
	public WebElement dropOff;
	
	@FindBy(id="orderSubmitBtn")
	public WebElement returnOrderBtn;
	
	@FindBy(xpath="//p[text()='Return was successfull']")
	public WebElement returnSuccessMsg;
//------------------Write Review---------------------------
	
	@FindBy(id="reviewBtn")
	public WebElement reviewBtn;
	
	@FindBy(id = "headlineInput")
	public WebElement headLineText;
	
	@FindBy(id="descriptionInput")
	public WebElement descriptionInput;
	
	@FindBy(id="reviewSubmitBtn")
	public WebElement addReviewBtn;
	
	@FindBy(xpath="//div[text()='Your review was added successfully']")
	public WebElement reviewSuccessMsg1;


}
	
