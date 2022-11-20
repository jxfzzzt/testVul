package fileUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileUtils {

	public Properties config = null;
	public InputStream fis = null;

	public FileUtils(String filePath) throws IOException {
		config = new Properties();
		fis = new FileInputStream(filePath);
		config.load(fis);

	}

	public String getSelectedBrowser() throws IOException {
		return String.valueOf(config.getProperty("browser"));
	}

	public String getSelectedUrl() throws IOException {
		return String.valueOf(config.getProperty("url"));
	}
	
	public Boolean getcloudTesting() throws IOException {
		return Boolean.valueOf(config.getProperty("cloudTesting"));
	}
	
	public Map<String, String> getcloudParameters() throws IOException {
		Map<String,String> cloudParameters = new HashMap<String,String>();
		cloudParameters.put("browser", config.getProperty("browserOnCloud"));
		cloudParameters.put("browser_version", config.getProperty("browserVersion"));
		cloudParameters.put("os", config.getProperty("osOnCloud"));
		cloudParameters.put("os_version", config.getProperty("osVersion"));
		cloudParameters.put("resolution", config.getProperty("resolution"));
		return cloudParameters;
	}
	
	
	
	
	

}
