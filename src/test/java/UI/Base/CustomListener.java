package UI.Base;
import Utilities.logsUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

public class CustomListener implements ITestListener {
    private final String RESET = "\u001B[37m";
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String BLUE = "\u001B[34m";
    private final String PURPLE = "\u001B[35m";
    private final String CYAN = "\u001B[36m";
    @Override
    public void onTestStart(ITestResult result) {
        logsUtils.info(BLUE+ " [START]" +" Test " + result.getName() + " started"+ RESET);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logsUtils.info(GREEN+ " [PASSED]" +" Test " + result.getName() + " passed"+ RESET);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        logsUtils.info(RED+" [FAIlED]" +" Test " + result.getName() + " failed" + RESET);
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        logsUtils.info(YELLOW+" [SKIPPED]" +" Test " + result.getName() + " skipped" + RESET);
    }

    @Override
    public void onStart( ITestContext context ) {
        logsUtils.info(CYAN+context.getName()+ "Tests Started" + RESET);
    }
    @Override
    public void onFinish(ITestContext context ) {
        logsUtils.info(PURPLE+" All tests completed: " + context.getName()+ RESET);
    }

}
