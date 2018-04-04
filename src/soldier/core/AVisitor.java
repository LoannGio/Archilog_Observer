package soldier.core;

import soldier.units.UnitBikerMan;
import soldier.units.UnitCenturion;
import soldier.units.UnitHorseMan;
import soldier.units.UnitRobot;

public abstract class AVisitor implements IVisitor {
	@Override
	public void visit(Unit u) {
		System.out.println("not yet implemented");

	}

	@Override
	public void visit(UnitSimple u) {
		visit((Unit) u);

	}

	@Override
	public void visit(Army u) {
		visit((Unit) u);

	}

	@Override
	public void visit(UnitBikerMan u) {
		visit((UnitSimple) u);

	}

	@Override
	public void visit(UnitCenturion u) {
		visit((UnitSimple) u);

	}

	@Override
	public void visit(UnitHorseMan u) {
		visit((UnitSimple) u);

	}

	@Override
	public void visit(UnitRobot u) {
		visit((UnitSimple) u);

	}

	public void visitEquipment(Unit u) {
		System.out.println("not yet implemented");

	}

	public void visitEquipment(Army u) {
		visitEquipment((Unit) u);
	}

	public void visitEquipment(UnitSimple u) {
		visitEquipment((Unit) u);

	}

}
