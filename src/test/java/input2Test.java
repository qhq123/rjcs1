import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class input2Test {
  @Test(dataProvider = "dp")
  public void f(int select, String weight,int re) {
	  System.setProperty("java.awt.headless", "false");
  	  Caculator caculator=new Caculator();
	  int re2=caculator.input2re(select,weight);
	  Assert.assertEquals(re2, re);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	{ 3, "40", 0},
    	{ 8, "5", 0},
    	{ 1, "30", 0},
    	{ 1, "", 11},
    	{ 1, "asd", 12},
    	{ 0, "1", 2},
    	{ 3, "1", 3},
    	{ 3, "46", 3},
    	{ 8, "1", 4},
    	{ 8, "6", 4},
    	{ 1, "1", 5},
    	{ 1, "33", 5},
    };
  }
}
