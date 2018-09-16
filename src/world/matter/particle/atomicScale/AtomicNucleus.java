package world.matter.particle.atomicScale;

public abstract class AtomicNucleus {
	private Proton[] proton;
	private Neutron[] neutron;
	
	public AtomicNucleus(Proton[] proton, Neutron[] neutron) {
		this.proton = proton;
		this.neutron = neutron;
	}
	
	public Proton[] getProton() {
		return proton;
	}
	
	public void setProton(Proton[] proton) {
		this.proton = proton;
	}
	
	public Neutron[] getNeutron() {
		return neutron;
	}
	
	public void setNeutron(Neutron[] neutron) {
		this.neutron = neutron;
	}
}
