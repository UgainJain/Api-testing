package Api;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Api.businessLogic.BusinessLogic;
import utils.Base.BaseClass;
import utils.dataSource.ExcelLib;

public class Demo extends BaseClass{
	ExcelLib exl;

	BusinessLogic bl = new BusinessLogic();
	@BeforeSuite
	public void before() {
		BusinessLogic bl = new BusinessLogic();
		exl = new ExcelLib();
		bl.beforeAll();
	}
	
@Test(priority = 1)
public void test1() {
	Assert.assertTrue(bl.getLists());
	
}

@Test(priority = 2)
public void test2() {

	Assert.assertTrue(bl.createList());
}

@Test(priority = 3)
public void test3() {

	Assert.assertTrue(bl.getspecificList());
}

@Test(priority = 4)
public void test4() {
	
	Assert.assertTrue(bl.updateputList());}

@Test(priority = 5)
public void test5() {
	Assert.assertTrue(bl.updatepatchList());}

@Test(priority = 6)
public void test6() {
	Assert.assertTrue(bl.deleteLists());}

@Test(priority = 7)
public void test7() {
	Assert.assertTrue(bl.gettasks());}

@Test(priority = 8)
public void test9() {
	Assert.assertTrue(bl.createtasks());}

@Test(priority = 10)
public void test10() {
	Assert.assertTrue(bl.updatepatchtasks());
}

@Test(priority = 11)
public void test11() {
	Assert.assertTrue(bl.updateputtasks());}

@Test(priority = 12)
public void test12() {
	Assert.assertTrue(bl.deletetasks());
	}
@AfterMethod
public void flush() {
	if (reports != null) {
	reports.flush();
}
}
}
