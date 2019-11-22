package dhimni.cloud.state;

import dhimni.cloud.entities.Machine;

/**
 * @author rout
 *
 * Nov 17, 2019
 *
 * @project cloud
 */

public abstract class StateMachine {

	protected Machine machine;
	
	public abstract void startMachine();
	public abstract void stopMachine();
	public abstract String toString();
	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
}
