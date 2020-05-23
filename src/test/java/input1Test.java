import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class input1Test {
  @Test(dataProvider = "dp")
  public void f(String length,String width,
		  String height, String weight,int re
		  ) {
	  System.setProperty("java.awt.headless", "false");
	  Caculator caculator=new Caculator();
	  int re1=caculator.input1re(length,width,height,weight);
	  Assert.assertEquals(re1, re);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	{ "100", "60", "40","30",0},
    	{ "100", "60", "40","",11},
    	{ "100", "60", "40","asd",12},
    	{ "20", "20", "10","30",2},
    	{ "104", "60", "40","30",2},
    	{ "100", "60", "40","1",3},
    	{ "100", "60", "40","33",3},
    };
  }
}
