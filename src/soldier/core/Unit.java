package soldier.core;

import java.util.Iterator;

public interface Unit {

	public boolean alive();

	public void heal();

	public float parry(float force);

	public float strike();

	public void addEquipment(Equipment w);

	public void removeEquipment(Equipment w);

	public Iterator<Equipment> getWeapons();

	public int nbWeapons();

	public String getName();

	public void Attach(UnitObserver obs);

	public void Detach(UnitObserver obs);

	public void Notify();

	public void accept(IVisitor v);

}
