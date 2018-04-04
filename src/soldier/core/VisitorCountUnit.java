package soldier.core;

import java.util.Iterator;

public class VisitorCountUnit extends AVisitor {
	public int count;

	public VisitorCountUnit() {
		count = 0;
	}

	@Override
	public void visit(Army a) {
		Iterator<Unit> iter = a.iterator();
		while (iter.hasNext()) {
			Unit u = iter.next();
			u.accept(this);
		}

	}

	@Override
	public void visit(UnitSimple u) {
		count += 1;
	}
}
