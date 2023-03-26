package snhu.cs320.module.four;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Nichole Griffith
 *
 */

public class TaskServiceTest {

	TaskService tasks = new TaskService();
	
	TaskServiceTest() {
		// initialize with some tasks
		tasks.addTask();
		tasks.addTask();
		tasks.addTask();
		tasks.addTask("deleteme");
	}
	
	@Test
	void testAdd() {
		String id = "testID";
		String test = tasks.addTask(id);
		Assert.assertTrue(test.equals(id));
	}
	
	@Test
	void testSearch() {
		Assert.assertEquals(tasks.searchTask("deleteme").getTaskID(), "deleteme");
	}
	
	@Test
	void testUpdate() {
		String id = "deleteme";
		String name = "Foo";
		String description = "Bar";
		
		// update the fields
		Assert.assertTrue(tasks.updateTask(id, 1, name));
		Assert.assertTrue(tasks.updateTask(id, 2, description));
		
		// make sure the fields are updated
		Task task = tasks.searchTask(id);
		Assert.assertEquals(task.getTaskName(), name);
		Assert.assertEquals(task.getTaskDescription(), description);
	}
	
	@Test
	void testDelete() {
		// delete task
		Assert.assertTrue(tasks.deleteTask("deleteme"));
		// ensure that it is deleted
		Task task = tasks.searchTask("deleteme");
		// above code should come back null
		Assert.assertNull(task);
	}
	
}
