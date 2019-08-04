package pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OpenWeatherPage {
	
	private WebDriver driver;
	
	public OpenWeatherPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//------------------------------------------- Page Elements --------------------------------------------------

	@FindBy(how=How.XPATH,using="//li[contains(@class,'nav__item')]/a")
	public List<WebElement> links_TopMenu;
	
	@FindBy(how=How.XPATH,using="//div/h2[@class='weather-widget__city-name']")
	public WebElement cityName;
	
	@FindBy(how=How.XPATH,using="//label/following::input[@id='q']")
	public WebElement input_Search;

	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange']")
	public WebElement button_Search;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-warning']")
	public WebElement alertSearch;
	
	@FindBy(how=How.XPATH,using="//ul/li[@class='widget-tabs__item']/a")
	public List<WebElement> links_currentWeatherMenu;

	@FindBy(how=How.XPATH,using="//div[@class='widget__graphic']//div/h2")
	public WebElement currentWeatherMenuName;
	
	@FindBy(how=How.XPATH,using="//table[@class='table']//td/b/a")
	public WebElement validSearchMenuName;

	@FindBy(how=How.XPATH,using="//table[@class='table']//td/p/span")
	public WebElement validSearchMenuTemp;
	
	
	//------------------------------------------- Page Methods --------------------------------------------------
	
	public String topMenuList()
	{
		/*
		 * This method:
		 * return string of all top menu link's text with " " as seperator in two texts.
		 */
		StringBuilder listofelements=new StringBuilder();
		for (WebElement webElement : links_TopMenu) {
			listofelements.append(webElement.getText()+" ");
		}
		return listofelements.toString();
	}

	public String defaultCityname()
	{
		/*
		 * This method:
		 * get cityName and split it using "in " to return city name with country code
		 */
		String [] city=cityName.getText().split("in ");
		return city[1].toString();
	}
	
	public boolean currentweatherLinks()
	{
		/* This method will:
		 * click on each link under 'Current Weather Menu'
		 * and return
		 * 		True if click on all links working properly otherwise return false
		 * 
		 * To verify this
		 * 	method compare currentWeatherMenuName reflects the selected links_currentWeatherMenu option's text in it or not
		 */
		boolean flag=true;
		for(int i=1;i<links_currentWeatherMenu.size();i++)
		{
			links_currentWeatherMenu.get(i).click();
			//System.out.println(currentWeatherMenuName.getText()+" : "+links_currentWeatherMenu.get(i).getText());
			if(!currentWeatherMenuName.getText().contains(links_currentWeatherMenu.get(i).getText()))
			{
			flag=false;
			}
			//System.out.println(flag);
		}
		return flag;
	}
}
