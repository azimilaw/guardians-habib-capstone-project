package tek.capstone.guardians.pages;

import tek.capstone.guardians.base.BaseSetup;

public class POMFactory extends BaseSetup {
	
	private RetailHomePage homePage;
	private LoginPage loginPage;
	private RetailAccountPage retailAccountPage;
	private RetailOrderPage retailOrderPage;
	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.loginPage = new LoginPage();
		this.retailAccountPage = new RetailAccountPage();
		this.retailOrderPage= new RetailOrderPage();
		
	}

	public RetailHomePage homePage() {
		return this.homePage;
	}
	
	public LoginPage loginPage() {
		return this.loginPage;
	}
	
	public RetailAccountPage retailAccountPage () {
		return this.retailAccountPage;
	}
	public RetailOrderPage retailOrderPage() {
		return this.retailOrderPage;
		
	}

}
