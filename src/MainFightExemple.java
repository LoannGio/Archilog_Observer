
/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */

import soldier.core.Army;
import soldier.core.Equipment;
import soldier.core.ReportObserver;
import soldier.core.Unit;
import soldier.core.UnitObserver;
import soldier.equipment.WeaponShield;
import soldier.units.UnitCenturion;
import soldier.units.UnitHorseMan;

public class MainFightExemple {

	public static void main(String[] args) {

		/*
		 * UnitSimple trooper = new UnitCenturion("StormTrooper"); UnitSimple r2
		 * = new UnitRobot("R2D2");
		 * 
		 * trooper.addEquipment(new WeaponSword()); trooper.addEquipment(new
		 * WeaponShield());
		 * 
		 * r2.addEquipment(new WeaponShield()); r2.addEquipment(new
		 * EquipmentTrumpet());
		 * 
		 * int round = 0; while (trooper.alive() && r2.alive()) {
		 * System.out.println("Round  #" + round++); float st1 =
		 * trooper.strike(); System.out.println(trooper.getName() +
		 * " attack with force : " + st1); r2.parry(st1); if (r2.alive()) {
		 * float st2 = r2.strike(); System.out.println(r2.getName() +
		 * " attack with force : " + st2); trooper.parry(st2); } }
		 * System.out.println("The end ... " + (trooper.alive() ?
		 * trooper.getName() : r2.getName()) + " won.");
		 */
		// fight();
		fightObs();
	}

	private static void fightObs() {
		UnitObserver obs = new ReportObserver();
		Unit hm = new UnitHorseMan("hm1");
		Unit im = new UnitCenturion("inf1");
		Unit gr1 = new Army("gr1");
		hm.Attach(obs);
		im.Attach(obs);
		((Army) gr1).Attach(obs);
		((Army) gr1).add(hm);
		((Army) gr1).add(im);
		Unit im2 = new UnitCenturion("inf2");
		Unit hm2 = new UnitHorseMan("hm2");
		Unit gr2 = new Army("gr2");
		hm2.Attach(obs);
		im2.Attach(obs);
		((Army) gr2).Attach(obs);
		((Army) gr2).add(hm2);
		((Army) gr2).add(im2);
		Unit gr3 = new Army("gr3");
		((Army) gr3).add(gr1);
		((Army) gr3).add(gr2);
		((Army) gr3).Attach(obs);
		double residu = gr3.parry(3000);
		System.out.println(residu);

	}

	private static void fight() {
		Unit hm = new UnitCenturion("infantry1");
		Unit im = new UnitHorseMan("horseman1");
		Unit gr1 = new Army("gr1");
		((Army) gr1).add(hm);
		((Army) gr1).add(im);
		Unit hm2 = new UnitCenturion("infantry2");
		Unit im2 = new UnitHorseMan("horseman2");
		Unit gr2 = new Army("gr2");
		((Army) gr2).add(hm2);
		((Army) gr2).add(im2);
		Unit gr3 = new Army("gr3");
		((Army) gr3).add(gr1);
		((Army) gr3).add(gr2);
		Equipment shield = new WeaponShield();
		gr3.addEquipment(shield);
		System.out.println("la force de frappe de l'armée " + gr1.getName() + " est de : " + gr1.strike());
		System.out.println("la force de frappe de l'armée " + gr2.getName() + " est de : " + gr2.strike());
		System.out.println("la force de frappe de l'armée " + gr3.getName() + " est de : " + gr3.strike());
		System.out.println(gr2.parry(gr1.strike()));
	}
}
