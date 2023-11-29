package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * 
 * @author Divya
 *
 */

public class PropertyFileUtilities {
	/**
	 * This method is used to read from property file
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.Property_FilePath);
		Properties property=new Properties();
		property.load(fis);
		String value = property.getProperty(key);
		return value;
		
	}

}
