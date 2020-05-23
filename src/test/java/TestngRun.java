import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

public class TestngRun {
    public static void main(String[] args){
        TestNG testng = new TestNG();
        List suites = Lists.newArrayList();
        suites.add("test.xml");//path to xml..
        testng.setTestSuites(suites);
        testng.run(); 
    }

}

