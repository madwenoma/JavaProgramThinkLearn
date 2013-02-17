package learn.generate;

public class ExpertCommandService<DTO> implements IService<DTO>{

	public ExpertCommandService(){
		System.out.println(11111);
	}
	@Override
	public boolean insert(DTO dto) {
		System.out.println("insert in ExpertCommandService");
		return true;
	}

	@Override
	public boolean update(DTO dto) {
		System.out.println("update in ExpertCommandService");
		return true;
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class.forName("learn.generate.ExpertCommandService").newInstance();
	}
}
