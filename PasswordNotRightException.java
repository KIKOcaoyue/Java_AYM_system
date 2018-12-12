
public class PasswordNotRightException extends Exception {
	private String password;
	
	public PasswordNotRightException(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
}
