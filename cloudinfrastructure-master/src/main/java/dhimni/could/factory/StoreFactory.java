package dhimni.could.factory;

import dhimni.cloud.entities.Store;

public class StoreFactory {
	

	public Store getInstance(String Nane){
		return new Store(Nane);
		}
	

}
