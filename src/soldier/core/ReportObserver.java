package soldier.core;

public class ReportObserver implements UnitObserver {

	@Override
	public void update(Unit u) {
		System.out.println("L'unit� : " + u.getName() + " a �t� touch�e");

	}

}
