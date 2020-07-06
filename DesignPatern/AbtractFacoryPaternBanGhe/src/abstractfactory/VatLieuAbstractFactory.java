package abstractfactory;

import model.Ban;
import model.Ghe;

public interface VatLieuAbstractFactory {
	public Ban themBan();
	public Ghe themGhe();
}
