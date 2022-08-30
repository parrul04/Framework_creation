package managers;

import com.framework.utils.ConfigReader;

/**
 * Explanation
1). The FileReaderManager class maintains a static reference to its own instance and returns that reference from the 
	static getInstance() method.
2).FileReaderManager implements a private constructor so clients cannot instantiate FileReaderManager instances.
3). getConfigReader() method returns the instance of the ConfigFileReader but this method is not static.
 So that client has to use the getInstance() method to access other public methods of the FileReaderManager like FileReaderManager.getInstance().getConfigReader()
 * 
 * @author parul
 *
 */

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigReader configReader;

	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	 public ConfigReader getConfigReader() {
		 return (configReader == null) ? new ConfigReader() : configReader;
	 }
}