package world.matter.particle.molecularLevel;

import world.matter.particle.atomicScale.Atom;
import world.matter.particle.atomicScale.ChemicalFormula;

public abstract class Molecule {
	private final ChemicalFormula CHEMICALFORMULA;
	
	public Molecule(ChemicalFormula chemicalFormula) {
		this.CHEMICALFORMULA = chemicalFormula;
	}
	
	public Atom[] getChemicalFormula() {
		return this.CHEMICALFORMULA.CHEMICALFORMULA;
	}
}
