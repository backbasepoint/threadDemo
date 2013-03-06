package guardedsuspention;

public class Request {
	private String name =null;
	public Request(String name){
		this.name =name;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
