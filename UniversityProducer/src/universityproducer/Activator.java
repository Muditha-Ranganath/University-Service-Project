package universityproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import StudentImplService.StudentImplService;
import StudentService.StudentService;

public class Activator implements BundleActivator {
	
	ServiceRegistration serviceRegister;
	
    @Override
	public void start(BundleContext Context) throws Exception {
		System.out.println("***** University Started. *****");
		StudentService studentService = new StudentImplService();
		serviceRegister = Context.registerService(StudentService.class.getName(), studentService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("***** University Closed *****");
		serviceRegister.unregister();
	}

}
