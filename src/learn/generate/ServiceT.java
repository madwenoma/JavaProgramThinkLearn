package learn.generate;

import java.util.List;


public abstract class ServiceT<IServiceT extends IService<DTO>, Model, DTO> extends Service{
	protected abstract void sayHello();

	
	private IServiceT hostService;
	

	
	public ServiceT(){}
	
	//在这里面实例化IServiceT类
	@SuppressWarnings("unchecked")
	public ServiceT(String iserviceSubClassName){
		System.out.println("ServiceT 实例化host服务器构造器调用");
		try {
			setHostService((IServiceT)(Class.forName(iserviceSubClassName).newInstance()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	protected boolean insert(Model model){
		
		System.out.println("insert in ServiceT.java and model -> dto");
		DTO dto = null;
		return hostService.insert(dto);
	}
	
	public boolean update(Model model){
		System.out.println("update int ServiceT.java and model -> dto");
		DTO dto = null;
		return hostService.update(dto);
	}
	
	protected abstract List<Model> getDataList();
	
	//Model to dto
	public DTO changeModel2DTO(Model model){
		System.out.println("change model 2 dto");
		DTO dto = null;
		return dto;
	}
	
	//dto to model
	public Model changeDTO2Model(DTO dto){
		System.out.println("change dto 2 model");
		Model model = null;
		return model;
	}
	public IServiceT getHostService() {
		return hostService;
	}
	public void setHostService(IServiceT hostService) {
		this.hostService = hostService;
	}
	
	
}
