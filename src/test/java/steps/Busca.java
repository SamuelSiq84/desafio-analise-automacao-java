package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import suporte.Evidences;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Busca {
    Evidences evidences;
    String url;
    WebDriver driver;
    static String pastaPrint = "evidencias/" + new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime()) + "/";


    @Before
    public void setup(){
        url ="http://automationpractice.com";
        System.setProperty("webdriver.chrome.driver","drivers/chrome/91/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        evidences = new Evidences();

    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Dado("^que busco nome do produto \"([^\"]*)\"$")
    public void queBuscoNomeDoProduto(String arg0) throws Throwable {
        driver.get(url);
        driver.findElement(By.id("search_query_top")).sendKeys("shirt");
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 1 - Passo 1 - Busco por Produtp");


    }

    @Quando("^clico no botao da lupa$")
    public void clicoNoBotaoDaLupa() {
        driver.findElement(By.cssSelector("button.btn.btn-default.button-search")).click();

    }

    @Entao("^devem ser retornados produto \"([^\"]*)\"$")
    public void devemSerRetornadosProduto(String arg0) throws Throwable {
        assertThat(driver.findElement(By.cssSelector("span.lighter")).getText(),containsString("SHIRT") );

    }
    @Dado("^que procuro produto \"([^\"]*)\"$")
    public void queProcuroProduto(String arg0) throws Throwable {
        driver.get(url);
        driver.findElement(By.id("search_query_top")).sendKeys("shirt");
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 2 - Passo 1 - Procuro por produto");

    }

    @Quando("^clico na lupa$")
    public void clicoNaLupa() throws Throwable {
        driver.findElement(By.cssSelector("button.btn.btn-default.button-search")).click();
        assertThat(driver.findElement(By.cssSelector("span.available-now")).getText(),containsString("In stock"));
        driver.findElement(By.id("color_2")).click();
        driver.findElement(By.cssSelector("a.button.lnk_view.btn.btn-default")).click();
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 2 - Passo 2 - Descricao do produto");
    }

    @Entao("^adiciona ao carrinho de compras$")
    public void adiciona_ao_carrinho_de_compras() throws Throwable {

        assertEquals("Faded Short Sleeve T-shirts - My Store",driver.getTitle());
        assertThat(driver.findElement(By.cssSelector("div.content_prices.clearfix")).getText(),containsString("$16.51"));
        driver.findElement(By.id("color_14")).click();
        driver.findElement(By.id("add_to_cart")).click();
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 2 - Passo 3 - Adciono no carrinho");
        //assertEquals("Product successfully added to your shopping cart",driver.findElement(By.cssSelector("i.icon-ok")));


    }

    @Dado("^que busco pelo produto \"([^\"]*)\"$")
    public void que_busco_pelo_produto(String arg1) throws Throwable {
        driver.get(url);
        driver.findElement(By.id("search_query_top")).sendKeys("cafe");
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 3 - Passo 1 - Procuro por produto fake");

    }

    @Quando("^clico no botao de busca$")
    public void clico_no_botao_de_busca() throws Throwable {
        driver.findElement(By.cssSelector("button.btn.btn-default.button-search")).click();
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 3 - Passo 2 - Clico na Lupa");
        assertEquals("Search - My Store",driver.getTitle());

    }

    @Entao("^retorna resultado nao encontrado$")
    public void retorna_resultado_nao_encontrado() throws Throwable {
        assertThat(driver.findElement(By.cssSelector("span.heading-counter")).getText(),containsString("0 results have been found."));
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 3 - Passo 3 - Resultado nao encontrado");


    }




}
