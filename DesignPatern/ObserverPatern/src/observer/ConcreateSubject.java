package observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreateSubject implements Subject {
	private List<Observer> listObs = new ArrayList<Observer>();
	@Override
	public void attach(Observer o) {
		// TODO Auto-generated method stub
		listObs.add(o);
	}

	@Override
	public void detach(Observer o) {
		// TODO Auto-generated method stub
		listObs.remove(o);
	}

	@Override
	public void notifiAll() {
		// TODO Auto-generated method stub
		for(Observer o : listObs) {
			o.update();
		}
	}
	public void notifi() {
		notifiAll();
	}

}
