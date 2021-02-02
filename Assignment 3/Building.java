package assignment3;

public class Building {

	OneBuilding data;
	Building older;
	Building same;
	Building younger;
	
	public Building(OneBuilding data){
		this.data = data;
		this.older = null;
		this.same = null;
		this.younger = null;
	}
	
	public String toString(){
		String result = this.data.toString() + "\n";
		if (this.older != null){
			result += "older than " + this.data.toString() + " :\n";
			result += this.older.toString();
		}
		if (this.same != null){
			result += "same age as " + this.data.toString() + " :\n";
			result += this.same.toString();
		}
		if (this.younger != null){
			result += "younger than " + this.data.toString() + " :\n";
			result += this.younger.toString();
		}
		return result;
	}
	
	public Building addBuilding (OneBuilding b){
		// ADD YOUR CODE HERE
		return this; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public Building addBuildings (Building b){
		// ADD YOUR CODE HERE
		return this; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public Building removeBuilding (OneBuilding b){
		// ADD YOUR CODE HERE
		return this; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int oldest(){
		// ADD YOUR CODE HERE
		return 0; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int highest(){
		// ADD YOUR CODE HERE
		return 0; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public OneBuilding highestFromYear (int year){
		// ADD YOUR CODE HERE
		return new OneBuilding("",0,0,0,0); // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int numberFromYears (int yearMin, int yearMax){
		// ADD YOUR CODE HERE
		return 0; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int[] costPlanning (int nbYears){
		// ADD YOUR CODE HERE
		return new int[0]; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
}
