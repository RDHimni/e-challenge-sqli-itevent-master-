package dhimni.could.factory;

import dhimni.cloud.entities.File;

/**
 * @author rout
 *
 * Nov 17, 2019
 *
 * @project cloud
 */

public class FileFactory {
	
	public File getInstance(String Name) {
		
		return new File(Name);
	}

}
