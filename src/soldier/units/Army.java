package soldier.units;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import soldier.core.Equipment;
import soldier.core.EquipmentException;
import soldier.core.Unit;
import soldier.core.UnitObserver;

public class Army implements Unit, Iterable<Unit> {
	private ArrayList<Unit> _children = new ArrayList<Unit>();
	private ArrayList<UnitObserver> _obs = new ArrayList<UnitObserver>();
	private String _name;

	public Army(String name) {
		_name = name;
	}

	public void add(Unit u) {
		_children.add(u);

	}

	public void remove(Unit u) {
		_children.remove(u);

	}

	public Unit getChild(int i) {
		return _children.get(i);
	}

	@Override
	public boolean alive() {
		for (Unit u : _children) {
			if (u.alive())
				return true;
		}
		return false;
	}

	@Override
	public void heal() {
		for (Unit u : _children) {
			u.heal();
		}
	}

	public Iterator<Unit> iterator() {
		return _children.iterator();
	}

	@Override
	public float parry(float force) {
		float residu = 0f;
		float EPSILON = 0.001f;

		Boolean stop = false;

		while (!stop) {
			residu = 0f;

			ListIterator<Unit> iter = _children.listIterator();
			while (iter.hasNext()) {
				Unit u = iter.next();
				float tmpResidu = u.parry(force / _children.size());
				if (Math.abs(residu - 0f) > EPSILON)
					/* il y a un residu, u est donc mort */
					iter.remove();

				residu += tmpResidu;
			}

			if (alive() && Math.abs(residu - 0f) < EPSILON)
				parry(residu);
			else
				stop = true;
		}
		Notify();
		return residu;
	}

	@Override
	public float strike() {
		float sumForces = 0f;
		for (Unit u : _children)
			sumForces += u.strike();
		return sumForces;
	}

	@Override
	public void addEquipment(Equipment w) {
		for (Unit u : _children) {
			try {
				u.addEquipment(w);
				break;
			} catch (EquipmentException ee) {
			}
		}
	}

	@Override
	public void removeEquipment(Equipment w) {

	}

	@Override
	public Iterator<Equipment> getWeapons() {
		return new Iterator<Equipment>() {
			Iterator<Equipment> itE = null;
			Iterator<Unit> itU = _children.iterator();

			@Override
			public boolean hasNext() {
				while (itE == null || itE.hasNext()) {
					if (itU.hasNext())
						itE = itU.next().getWeapons();
					else
						return false;
				}
				return true;
			}

			@Override
			public Equipment next() {
				return itE.next();
			}
		};
	}

	@Override
	public int nbWeapons() {
		int nbWeapons = 0;
		for (Unit u : _children)
			nbWeapons += u.nbWeapons();
		return nbWeapons;
	}

	@Override
	public String getName() {
		return _name;
	}

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
