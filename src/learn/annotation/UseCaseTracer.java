package learn.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * UseCase的注解处理器
 * @author biGpython
 *
 */
public class UseCaseTracer {
	
	public static void useCaseTrace(List<Integer> useCases, Class<?> cl){
		for (Method m : cl.getDeclaredMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);//指定注解
			if(uc != null){
				System.out.println("found annotation " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for (Integer integer : useCases) {
			System.out.println("not found annotation " + integer);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 46,47,48,49);
		useCaseTrace(useCases,TestUseCase.class);
	}
}
