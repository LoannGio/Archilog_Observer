package soldier.core;

import soldier.units.UnitBikerMan;
import soldier.units.UnitCenturion;
import soldier.units.UnitHorseMan;
import soldier.units.UnitRobot;

public interface IVisitor {
	public void visit(Unit u);

	public void visit(UnitSimple u);

	public void visit(Army u);

	public void visit(UnitBikerMan u);

	public void visit(UnitCenturion u);

	public void visit(UnitHorseMan u);

	public void visit(UnitRobot u);

	public void visitEquipment(Unit u);

	public void visitEquipment(Army u);

	public void visitEquipment(UnitSimple u);

}
