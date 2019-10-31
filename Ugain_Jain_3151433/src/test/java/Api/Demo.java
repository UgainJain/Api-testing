package Api;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Api.businessLogic.BusinessLogic;
import utils.dataSource.ExcelLib;

public class Demo {
	ExcelLib exl;
	@BeforeSuite
	public void before() {
		BusinessLogic bl = new BusinessLogic();
		exl = new ExcelLib();
	}
	
@Test
public void test() {
	BusinessLogic bl = new BusinessLogic();
//	Assert.assertTrue(bl.getLists());
//	Assert.assertTrue(bl.createList());
//	Assert.assertTrue(bl.getspecificList());
//	Assert.assertTrue(bl.updateputList());
//	Assert.assertTrue(bl.updatepatchList());
//	Assert.assertTrue(bl.deleteLists());
	Assert.assertTrue(bl.gettasks());
	Assert.assertTrue(bl.createtasks());
	Assert.assertTrue(bl.updatepatchtasks());
	Assert.assertTrue(bl.updateputtasks());
	Assert.assertTrue(bl.deletetasks());
	
}
}
