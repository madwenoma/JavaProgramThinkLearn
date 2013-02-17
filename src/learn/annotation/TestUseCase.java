package learn.annotation;

import java.util.List;

/**
 * 使用了UseCase注解
 * @author biGpython
 *
 */
public class TestUseCase {
	@UseCase(id = 47,description="password must contain at least one numeric")
	public boolean validatePwd(String pwd){
		
		return pwd.matches("\\w*\\d\\w*");
		
	}
	
	@UseCase(id = 48)
	public String encryptPwd(String pwd){
		
		return new StringBuilder(pwd).reverse().toString();
	}
	
	@UseCase(id = 49, description="new pwd can't equals previously used ones")
	public boolean checkNewPwd(List<String> prePwds, String newPwd){
		return prePwds.contains(newPwd);
	}
	
}
