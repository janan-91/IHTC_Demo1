package IHTC_wdMethods;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IHTC_Interface {

	/**
	 * This method will launch the chrome browser and maximise the browser and set
	 * the wait for 30 seconds and load the url
	 *
	 * @author Vinoth - Tringapps
	 * @param browser
	 *            - This will load the specified browser 
	 */
	public void startApp(String browser, String platform, String applicationUrl, String tcname) throws FileNotFoundException, IOException;

	/**
	 * This method will take snapshot of the browser
	 *
	 * @author Vinoth - TringApps
	 */
	public long takeScreenShot();

	/**
	 * This method will close all the browsers
	 *
	 * @author Vinoth - TringApps
	 */
	public void closeAllBrowsers();

}
