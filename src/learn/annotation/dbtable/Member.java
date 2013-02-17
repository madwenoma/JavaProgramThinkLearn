package learn.annotation.dbtable;

/**
 * 该javabean代表数据库中的一个表
 * 
 * @author biGpython
 * 
 */
@DBTable(name = "member")
public class Member {

	@SQLString(30)
	String firstName;
	@SQLString(20)
	String lastName;

	@SQLInteger
	int age;
	@SQLString(value = 30, name = "", constains = @Constains(primaryKey = true))
	String handle;
	
	static int memberCount;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getHandle() {
		return handle;
	}

	public static int getMemberCount() {
		return memberCount;
	}
	
}
