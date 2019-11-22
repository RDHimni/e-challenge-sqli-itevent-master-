package dhimni.cloud.state;

import dhimni.cloud.exceptions.MachineStateException;

/**
 * @author rout
 *
 * Nov 17, 2019
 *
 * @project cloud
 */

public class StopedMachine extends StateMachine{

	@Override
	public void startMachine() {
		// TODO Auto-generated method stub
		machine.setState(new StartedMachine());
	}

	@Override
	public void stopMachine() {
		// TODO Auto-generated method stub
		throw new MachineStateException();
		
	}

	@Override
	public String toString() {		
		// TODO Auto-generated method stub
		return "stopped";
	}

}
