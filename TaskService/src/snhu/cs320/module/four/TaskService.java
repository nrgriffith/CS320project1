package snhu.cs320.module.four;

import java.util.ArrayList;

/**
 * @author Nichole Griffith
 *
 */

public class TaskService {

	private ArrayList<Task> taskList = new ArrayList<Task>();
	
	public Task searchTask(String id) {
		// search for a task
		// iterate through taskList to find the matching taskID
		for(Task task : taskList) {
			if(task.getTaskID().equals(id)) {
				return task;
			}
		}
		Task returnTask = null;
		return returnTask;
	}
	
	// add with specified ID
	public String addTask(String id) {
		// verify that the id doesn't already exist
		Task task = searchTask(id);
		if(task == null) { // contact not found
			// add a new task
			task = new Task(id);
			taskList.add(task);
			return task.getTaskID();

		}
		else { //
			return null;
		}
	}
	
	// add without specified ID
	public String addTask() {
		Task task = new Task();
		taskList.add(task);
		return task.getTaskID();
	}
	
	// delete task
	public Boolean deleteTask(String id) {
		Task task = searchTask(id);
		if(task == null) {
			return false;
		}
		taskList.remove(task);
		return true;
	}
	
	// update task
	public Boolean updateTask(String id, int item, String value) {
		// find task if it exists
		Task task = searchTask(id);
		if(task == null) {
			return false;
		}
		// update
		switch(item) {
			case 1: // update name
				task.setTaskName(value);
				return true;
			case 2: // update description
				task.setTaskDescription(value);
				return true;
			default:
				return false;
		}
	}
}
