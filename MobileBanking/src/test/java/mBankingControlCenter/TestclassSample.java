package mBankingControlCenter;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestclassSample implements IHookable {

    private List<String> methodsToRun = new ArrayList<>();

    @Factory(dataProvider = "dp")
    public TestclassSample(List<String> methodsToRun) {
        this.methodsToRun = methodsToRun;
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        String testMethodName = testResult.getMethod().getMethodName();
        if (methodsToRun.contains(testMethodName)) {
            System.out.println("About to run " + testResult.getMethod().getMethodName());
            callBack.runTestMethod(testResult);
        } else {
            testResult.setStatus(ITestResult.SKIP);
        }
    }

    @Test
    public void testMethod() {
        System.out.println("testMethod()");
    }

    @Test
    public void anotherTestMethod() {
        System.out.println("anotherTestMethod()");
    }

    @Test
    public void thirdTestMethod() {
        System.out.println("thirdTestMethod()");
    }

    @DataProvider(name = "dp")
    public static Object[][] getData() {
        return new Object[][]{
                {Arrays.asList("testMethod", "thirdTestMethod")}
        };
    }
}
