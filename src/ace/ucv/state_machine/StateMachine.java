package ace.ucv.state_machine;

import java.util.HashMap;

public abstract class StateMachine {

	@SuppressWarnings("unused")
	private String currentState = "";
	@SuppressWarnings("unused")
	private HashMap<String, HashMap<String, String>> transitionTable = new HashMap<String, HashMap<String, String>>();

	public abstract void transition(String action);
}
