package abstractfactory;

public class GoFactory extends AbstractTwoFactory {

	@Override
	public Ban createBan() {
		// TODO Auto-generated method stub
		return new BanGo();
	}

	@Override
	public Ghe createGhe() {
		// TODO Auto-generated method stub
		return new GheGo();
	}

}
