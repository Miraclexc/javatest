package world.matter.particle.molecularLevel.moleculars;

import tools.array.ArrayTools;
import world.matter.particle.atomicScale.Atom;
import world.matter.particle.atomicScale.ChemicalFormula;
import world.matter.particle.atomicScale.atoms.Hydrogen;
import world.matter.particle.molecularLevel.Molecule;

public class MHydrogen extends Molecule {
	public MHydrogen(int count) {
		super(new ChemicalFormula(new Hydrogen(0, 1), new Hydrogen(0, 1)));
	}
	
}
