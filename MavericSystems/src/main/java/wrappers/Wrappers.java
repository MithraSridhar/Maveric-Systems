package wrappers;

public interface Wrappers {

	// This method will launch the browser by the given browser name and URL
	public void invokeApp(String browser, String Url);

	/*
	 * This method will find the field by using the ID as the attribute and
	 * enter the text we passed through data variable
	 */
	public void enterById(String idValue, String data);

	/*
	 * This method will find the field by using the name as the attribute and
	 * enter the text we passed through data variable
	 */
	public void enterByName(String nameValue, String data);

	/*
	 * This method will find the field by using the Xpath as the attribute and
	 * enter the text we passed through data variable
	 */
	public void enterByXpath(String xpathValue, String data);

	/*
	 * This method will verify the title with the given text, can be used to
	 * verify the title of the page landed
	 */
	public void verifyTitle(String title);

	/*
	 * This method will verify the text by using ID as attribute with the exact
	 * value matches with the text value passed
	 */
	public void verifyTextById(String id, String text);

	/*
	 * This method will verify the text by using Xpath as attribute with the
	 * exact value matches with the text value passed
	 */
	public void verifyTextByXpath(String xpath, String text);

	/*
	 * This method will verify the text by using Xpath as attribute with the
	 * partial value matches with the text value passed
	 */
	public void verifyTextContainsByXpath(String xpath, String text);

	// This method will click the element using ID attribute

	public void clickById(String id);

	// This method will click the element using class name attribute
	public void clickByClassName(String classVal);

	// This method will click the element using name attribute
	public void clickByName(String name);

	// This method will click the element using linktext attribute
	public void clickByLink(String name);

	// This method will click the element using linktext attribute without
	// taking snap
	public void clickByLinkNoSnap(String name);

	// This method will click the element using xpath attribute
	public void clickByXpath(String xpathVal);

	/*
	 * This method will click the element using xpath attribute without taking
	 * snap
	 */
	public String getTextById(String idVal);

	// This method will get the text of the element using Xpath attribute

	public String getTextByXpath(String xpathVal);

	// This method will select the drop down using visible text and ID locator
	public void selectVisibileTextById(String id, String value);

	// This method will select the drop down using index and ID locator
	public void selectIndexById(String id, int value);

	// This method will accept alert
	public void acceptAlert();

	// This method will take snap of the active browser
	public void takeSnap();

	// This method will close only the active browser
	public void closeBrowser();

	// This method will close all the browser opened in the session
	public void closeAllBrowsers();

	// This method is used to switch to frame by its name
	public void switchToFrame(String name);

	// This method is used to switch to default content
	public void switchToDefaultContent();
}
