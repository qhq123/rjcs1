import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class chargeTest {
  @Test(dataProvider = "dp")
  public void f(int line,int passager,int seat,String prices, 
		  ArrayList<SpeLuggage> speluglist,ArrayList<Luggage>luglist,float re
			  ) {
	      System.setProperty("java.awt.headless", "false");
  	      Cacu caculator= new Cacu();
		  float re1=caculator.checkticket(line, passager, seat, prices, speluglist, luglist);
		  Assert.assertEquals(re1, re);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	{ 0, 1, 1,"1000",new ArrayList<SpeLuggage>(),new ArrayList<Luggage>(),-1},
    	{ 1, 0, 1,"1000",new ArrayList<SpeLuggage>(),new ArrayList<Luggage>(),-2},
    	{ 1, 1, 0,"1000",new ArrayList<SpeLuggage>(),new ArrayList<Luggage>(),-3},
    	{ 1, 1, 1,"",new ArrayList<SpeLuggage>(),new ArrayList<Luggage>(),-4},
    	{ 1,1,1 ,"asd",new ArrayList<SpeLuggage>(),new ArrayList<Luggage>(),-5},
    	{ 1,1 ,1 ,"-1000",new ArrayList<SpeLuggage>(),new ArrayList<Luggage>(),-6},
    	{ 1,1 ,1 ,"1000",new ArrayList<SpeLuggage>(Arrays.asList(new SpeLuggage(30,11))),new ArrayList<Luggage>(),0},
    	{ 1,2 ,2 ,"1000",new ArrayList<SpeLuggage>(),new ArrayList<Luggage>(Arrays.asList(new Luggage(100,60,40,30))),300},
    	{ 1,3 , 2,"1000",new ArrayList<SpeLuggage>(),new ArrayList<Luggage>(Arrays.asList(new Luggage(100,60,40,20))),150},
    	{ 5, 4, 1,"1000",new ArrayList<SpeLuggage>(Arrays.asList(new SpeLuggage(30,21))),new ArrayList<Luggage>(),0},
    	{ 21,4 ,2 ,"1000",new ArrayList<SpeLuggage>(),new ArrayList<Luggage>(Arrays.asList(new Luggage(100,60,40,25))),1660},
    	{ 21,4 ,2 ,"1000",new ArrayList<SpeLuggage>(Arrays.asList(new SpeLuggage(30,21))),new ArrayList<Luggage>(Arrays.asList(new Luggage(100,60,40,30))),1660},
    };
  }
}
