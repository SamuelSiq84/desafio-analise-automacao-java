package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Evidences {

    public void takeScreenshot(WebDriver driver, String pastaPrint,String nomePrint) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // tratativa de erro try e catch
        //try {
            FileUtils.copyFile(foto, new File(pastaPrint + nomePrint + ".png"));
        //
        //catch (Exception e){
            //System.out.println("Houveram problemas ao copiar o arquivo para pasta" + e.getMessage());
        //}

    }



}
