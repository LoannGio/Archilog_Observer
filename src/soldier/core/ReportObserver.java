package soldier.core;

public class ReportObserver implements UnitObserver {

	@Override
	public void update(Unit u) {
		System.out.println("L'unité : " + u.getName() + " a été touchée");

	}

}
