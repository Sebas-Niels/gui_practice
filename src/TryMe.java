
import java.time.LocalDate;

import ctrl.MemberCtrl;
import ctrl.RegisterDogCtrl;
import gui.DogListCellRenderer;
import gui.DogView;
import gui.MemberView;
//import gui.DogView;
import model.Dog;
import model.Member;

public class TryMe {
	private static RegisterDogCtrl rdc = new RegisterDogCtrl();
	private static MemberCtrl mc = new MemberCtrl();
	public static void main(String[] args) {
		Member m = mc.createMember("Joe", "joe@joe", "12121212");
		rdc.findByEmail("joe@joe");
		Dog fido = rdc.registerDog("Fido", LocalDate.now().getYear());
		//DogView dv = new DogView(fido, rdc);
		//dv.setVisible(true);
		System.out.println(m);
		
		
		Member m2 = mc.createMember("testName", "test@email.com", "testPhone");
		rdc.findByEmail("test@email.com");
		Dog testDog = rdc.registerDog("testDog", LocalDate.now().getYear());
		
		System.out.println(testDog.getName());
		
//		DogView frame = new DogView(fido, rdc);
//		frame.setVisible(true);
//		
//		System.out.println(fido.getName());
		
		MemberView memberFrame = new MemberView(m);
		memberFrame.setVisible(true);
		
		DogListCellRenderer dcr = new DogListCellRenderer();
		
		
	}
}
