package javalanguage.reflect.创建接口的动态代理实现;

public class UserDao implements IUserDao {

	@Override
	public String getUserName() {
		return "UserDao-getUserName";
	}

}
