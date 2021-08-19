package weatherDetailsTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
    public void onTestStart(ITestResult result){

    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test run Successfully :"+" "+ result.getName());
    }

    public void onTestFailure(ITestResult result) {

//        File file=((TakesScreenshot) WebDriverManagerSetup.driver).getScreenshotAs(OutputType.FILE);
//        String fileName=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
//        File dest=new File("./screenshot/"+fileName+".jpg");
//        try {
//            FileUtils.copyFile(file, dest);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
        System.out.println("Test Failure :"+" "+ result.getName());
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }

}
