package world.matter.particle.atomicScale;

public abstract class Atom extends AtomicNucleus {
	private Electron[] electron;
	public final String SYMBOLOFELEMENT;
	
	public Atom(Proton[] proton, Neutron[] neutron, Electron[] electron, String symbolOfElement) {
		super(proton, neutron);
		this.electron = electron;
		this.SYMBOLOFELEMENT = symbolOfElement;
	}
	
	public Electron[] getElectron() {
		return electron;
	}

	public void setElectron(Electron[] electron) {
		this.electron = electron;
	}
}
