package snhu.cs320.module.four;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Nichole Griffith
 *
 */

public class TaskTest {
	Task task = new Task();
	
	@Test
	void testName() {
		// too long
		Assert.assertFalse(task.setTaskName("abcdefghijklmnopqrstuvwxyz"));
		// null/empty
		Assert.assertFalse(task.setTaskName(""));
		Assert.assertFalse(task.setTaskName(null));
		// good name
		Assert.assertTrue(task.setTaskName("a new name"));
	}
	
	@Test
	void testDescription() {
		// too long
		Assert.assertFalse(task.setTaskDescription("0123456789012345678901234567890123456789012345678901234567890012345678901234567890"));
		// null/empty
		Assert.assertFalse(task.setTaskDescription(null));
		Assert.assertFalse(task.setTaskDescription(""));
		// good description
		Assert.assertTrue(task.setTaskDescription("this is a good description"));
	}
	
	@Test
	void testTaskID() {
		// cannot be null
		Assert.assertNotNull(task.getTaskID());
		// cannot be updated
		/* Note: I don't know what the best technique for this test was,
		 * because the field is private and there is no set method for it,
		 * so this checks for NoSuchFieldException when trying to access it.
		 * I hope that's sufficient to prove that it cannot be updated.
		*/
		Assert.assertThrows(NoSuchFieldException.class, ()->{task.getClass().getField("taskID");});
	}
	
}
