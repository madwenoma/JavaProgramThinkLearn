package learn.generate;

public class ExpertController extends Controller<ExpertService, ExpertCommandService<ExpertDTO>, ExpertDTO>{

	//模拟ASP.NET MVC3控制器中某个方法
	public void index() throws Exception{
		Expert model = new Expert();
		model.expertName = "experA";
		model.age = 23;
		ExpertService service = getCurrentService(ExpertService.class, "learn.generate.ExpertCommandService");
		service.insert(model);
		service.update(model);
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		new ExpertController().index();
	}
}
