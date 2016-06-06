
public class Orientation {
	int id;
	String orientationName;
	int orientationAge;
	
	public Orientation() {
		super();
	}
	public Orientation(int id, String name, int age) {
		super();
		this.id = id;
		this.orientationName = name;
		this.orientationAge = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrientationName() {
		return orientationName;
	}
	public void setOrientationName(String orientationName) {
		this.orientationName = orientationName;
	}
	public int getOrientationAge() {
		return orientationAge;
	}
	public void setOrientationAge(int orientationAge) {
		this.orientationAge = orientationAge;
	}
}
