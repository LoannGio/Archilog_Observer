package soldier.core;

import java.util.ArrayList;

public abstract class ObservableUnit implements Unit {
	private ArrayList<UnitObserver> _obs = new ArrayList<UnitObserver>();

	@Override
	public void Attach(UnitObserver obs) {
		_obs.add(obs);

	}

	@Override
	public void Detach(UnitObserver obs) {
		_obs.remove(obs);

	}

	@Override
	public void Notify() {
		for (UnitObserver uo : _obs)
			uo.update(this);

	}

}
