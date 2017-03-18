package week11;

public class Model<T> {

/*	public class ObjectsModel {
		public void all() {
			
		}
	}*/
	
/*	public ObjectsModel objects() {
		return new ObjectsModel();
	}*/
	
	public ObjectsModel<T> objects() {
		return new ObjectsModel<T>();
	}
}
