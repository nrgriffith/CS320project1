package snhu.cs320.module.four;

public class Task {
	
	private String taskID;
	private String taskName;
	private String taskDescription;
	
	// Maximum character allowance per the rubric
	private final int MAX_CHAR_ID = 10;
	private final int MAX_CHAR_NM = 20;
	private final int MAX_CHAR_DE = 50;
	
	// Iterator to create unique contact IDs
	private static int idIterator = 0;
	
	Task(String id) { // create a task with an id
		super();
		if(id != null && id.length() <= MAX_CHAR_ID && !id.isEmpty()) {
			taskID = id;
		}
	}
	
	Task() { // default constructor to initialize task
		taskID = String.valueOf(idIterator);
		idIterator++;
		taskName = "name";
		taskDescription = "description";
	}
	
	// getter methods
	public String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	// setter methods
	public Boolean setTaskName(String name) {
		if(name == null) {
			return false;
		}
		if(!name.isBlank() && name.length() <= MAX_CHAR_NM) {
			this.taskName = name;
			return true;
		}
		return false;
	}
	
	public Boolean setTaskDescription(String description) {
		if(description == null) {
			return false;
		}
		if(!description.isBlank() && description.length() <= MAX_CHAR_DE) {
			this.taskDescription = description;
			return true;
		}
		return false;
	}

}
