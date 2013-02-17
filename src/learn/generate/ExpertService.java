package learn.generate;

import java.util.List;

public class ExpertService extends ServiceT<ExpertCommandService<ExpertDTO>, Expert, ExpertDTO>{
	public ExpertService(){
		System.out.println("ExpertService default constructor");
	}
	
	public ExpertService(String name){
		super(name);
	}
	
	@Override
	protected void sayHello() {
		System.out.println("say hello in ExpertService");
		
	}

	@Override
	protected List<Expert> getDataList() {
		System.out.println("getDataList in ExpertService");	
		return null;
	}

	@Override
	public boolean update(Expert model) {
		System.out.println("update override in customize ExpertService model -> dto");
		ExpertDTO dto = changeModel2DTO(model);
		return getHostService().update(dto);
 
	}
	
	
	

}
