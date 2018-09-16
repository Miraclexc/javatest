package world.matter.particle.atomicScale.atoms;

import world.matter.particle.atomicScale.Atom;
import world.matter.particle.atomicScale.Electron;
import world.matter.particle.atomicScale.Neutron;
import world.matter.particle.atomicScale.Proton;

public class Hydrogen extends Atom {
	public Hydrogen(int neutronCount, int electronCount) {
		super(new Proton[1], new Neutron[neutronCount], new Electron[electronCount], "H");
	}
}
