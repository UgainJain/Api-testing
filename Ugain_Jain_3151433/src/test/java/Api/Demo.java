package Api;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Api.businessLogic.BusinessLogic;

public class Demo {
	@BeforeSuite
	public void before() {
		BusinessLogic bl = new BusinessLogic();
		bl.BeforeAll();
	}
@Test
public void test() {
	BusinessLogic bl = new BusinessLogic();
	Assert.assertTrue(bl.getLists());
	
}
}
