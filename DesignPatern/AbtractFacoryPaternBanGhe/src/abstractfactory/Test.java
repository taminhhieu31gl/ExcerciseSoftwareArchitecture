package abstractfactory;

import model.Ban;
import model.Computer;
import model.Ghe;

public class Test {
	public static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		Ban pc = VatLieuFactory.getBan(new VatLieuFactory("2 GB", 7));
		Ghe server = VatLieuFactory.getGhe(new VatLieuFactory("16 GB", 7));
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::" + server);
	}
}
