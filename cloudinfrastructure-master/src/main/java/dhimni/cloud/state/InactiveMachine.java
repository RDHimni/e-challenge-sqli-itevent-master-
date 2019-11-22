package dhimni.cloud.state;


/**
 * @author rout
 *
 * Nov 17, 2019
 *
 * @project cloud
 */

public class InactiveMachine extends StateMachine{

	@Override
	public void startMachine() {
		machine.setState(new StartedMachine());		
	}

	@Override
	public void stopMachine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "inactive";
	}

}
