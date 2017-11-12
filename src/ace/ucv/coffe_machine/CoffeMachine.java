package ace.ucv.coffe_machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ace.ucv.state_machine.StateMachine;

public class CoffeMachine extends StateMachine {

	private String currentState;
	private HashMap<String, HashMap<String, String>> transitionTable;
	private List<String> availableCoffes;

	public CoffeMachine() {
		this.currentState = "0";
		this.transitionTable = populateHashMap();
		this.availableCoffes = populateCoffeList();
	}

	@Override
	public void transition(String action) {
		if (transitionTable.get(currentState).get(action) != null) {
			currentState = transitionTable.get(currentState).get(action);
			if(availableCoffes.contains(action)){
				System.out.println("Preparing coffe " + action);
			}
			System.out.println("Available credit " + currentState);
			System.out.println();
			System.out.println("Insert another coin");
		} else {
			System.out.println("You don't have enough money");
		}
	}

	private HashMap<String, HashMap<String, String>> populateHashMap() {

		HashMap<String, HashMap<String, String>> outerMap = new HashMap<String, HashMap<String, String>>();

		HashMap<String, String> innerMap1 = new HashMap<String, String>();
		innerMap1.put("5", "5");
		innerMap1.put("10", "10");
		outerMap.put("0", innerMap1);

		HashMap<String, String> innerMap2 = new HashMap<String, String>();
		innerMap2.put("5", "10");
		innerMap2.put("10", "15");
		outerMap.put("5", innerMap2);

		HashMap<String, String> innerMap3 = new HashMap<String, String>();
		innerMap3.put("C10", "0");
		innerMap3.put("5", "15");
		outerMap.put("10", innerMap3);

		HashMap<String, String> innerMap4 = new HashMap<String, String>();
		innerMap4.put("C10", "5");
		innerMap4.put("C15", "0");
		outerMap.put("15", innerMap4);

		return outerMap;
	}

	private List<String> populateCoffeList() {

		List<String> coffeList = new ArrayList<String>();

		coffeList.add("C10");
		coffeList.add("C15");

		return coffeList;
	}

}
