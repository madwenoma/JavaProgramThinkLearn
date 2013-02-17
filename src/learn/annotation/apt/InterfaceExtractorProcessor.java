package learn.annotation.apt;
import java.util.ArrayList;

import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;

public class InterfaceExtractorProcessor implements AnnotationProcessor{
	private final AnnotationProcessorEnvironment env = null;
	private ArrayList<MethodDeclaration> interfaceMethods = new ArrayList<MethodDeclaration>();
	@Override
	public void process() {
		
	}

}
