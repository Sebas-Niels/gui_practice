
import java.time.LocalDate;
import java.util.ArrayList;

import ctrl.MemberCtrl;
import ctrl.RegisterDogCtrl;
import gui.DogListCellRenderer;
import gui.DogView;
import gui.MemberRegisterView;
import gui.MemberView;
//import gui.DogView;
import model.Dog;
import model.Member;

public class TryMe {
	private static RegisterDogCtrl rdc = new RegisterDogCtrl();
	private static MemberCtrl mc = new MemberCtrl();
	public static void main(String[] args) {
		Member m1 = mc.createMember("Joe", "joe@joe", "12121212");
		rdc.findByEmail("joe@joe");
		Dog fido = rdc.registerDog("Fido", LocalDate.now().getYear());
		//DogView dv = new DogView(fido, rdc);
		//dv.setVisible(true);
		System.out.println(m1);
		
		
		Member m2 = mc.createMember("testName", "test@email.com", "testPhone");
		rdc.findByEmail("test@email.com");
		Dog testDog = rdc.registerDog("testDog", LocalDate.now().getYear());
		
		System.out.println(testDog.getName());
		
//		DogView frame = new DogView(fido, rdc);
//		frame.setVisible(true);
//		
//		System.out.println(fido.getName());
		
//		MemberView memberFrame = new MemberView(m1);
//		memberFrame.setVisible(true);
//		
//		DogListCellRenderer dcr = new DogListCellRenderer();
		
		
		ArrayList<Member> members = new ArrayList<>();
		members.add(m1);
		members.add(m2);
		MemberRegisterView mrv = new MemberRegisterView(members);
		mrv.setVisible(true);
		
		
	}
}
