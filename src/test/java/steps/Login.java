package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import jdk.jfr.ContentType;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import suporte.Evidences;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Login {
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


    @Dado("^que acesso o site na pagina de autenticacao$")
    public void que_acesso_o_site_na_pagina_de_autenticacao() throws IOException {
        driver.get(url);
        driver.findElement(By.cssSelector("a.login")).click();
        assertThat(driver.findElement(By.cssSelector("span.navigation_page")).getText(),is("Authentication"));
        evidences.takeScreenshot(driver,pastaPrint,"Cenario 1 - Passo 1 - Pagina de login");

    }

    @Quando("^insiro \"([^\"]*)\" e clico no botao create account$")
    public void insiro_e_clico_no_botao_create_account(String email) throws IOException {
        driver.findElement(By.id("email_create")).sendKeys("samuel.siqueira.pereira@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
        evidences.takeScreenshot(driver,pastaPrint,"Cenario 1 - Passo 2 - Inserir email");

    }

    @Entao("^realizo o cadastro da conta$")
    public void realizoOCadastroDaConta() throws IOException {
        assertThat(driver.findElement(By.cssSelector("h1.page-heading")).getText(),containsString("AUTHENTICATION"));
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 1 - Passo 3 - Criar Conta");
    }


    @Dado("^que acesso o site para realizar o login$")
    public void queAcessoOSiteParaRealizarOLogin() throws IOException {
        driver.get(url);
        driver.findElement(By.cssSelector("a.login")).click();
        assertThat(driver.findElement(By.cssSelector("span.navigation_page")).getText(),is("Authentication"));
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 2 - Passo 2 - Realizar Login");
    }

    @Quando("^insiro \"([^\"]*)\" e \"([^\"]*)\" e clico no botao sign in$")
    public void insiroEEClicoNoBotaoSignIn(String arg0, String arg1) throws Throwable {
        driver.findElement(By.id("email")).sendKeys("samuel.siqueira.pereira@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.id("SubmitLogin"));
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 2 - Passo 3 - Logar com email e senha");

    }
    @Entao("^logo com as crendecias validas$")
    public void logoComAsCrendeciasValidas() throws IOException {

        evidences.takeScreenshot(driver,pastaPrint,"Cenário 2 - Passo 4 - Validar a autenticacao");

    }

    @Dado("^que na pagina de autenticacao$")
    public void queNaPaginaDeAutenticacao()throws IOException {
        driver.get(url);
        driver.findElement(By.cssSelector("a.login")).click();
        assertThat(driver.findElement(By.cssSelector("span.navigation_page")).getText(),is("Authentication"));
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 3 - Passo 1 - Validar a Pagina de Autenticacao");


    }

    @Quando("^digito no campo \"([^\"]*)\" e \"([^\"]*)\"$")
    public void digitoNoCampoE(String emailfake, String senhafake)throws IOException {
        driver.findElement(By.id("email")).sendKeys("samuel.siqueira.pereira@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.id("SubmitLogin")).click();
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 3 - Passo 2 - Logar com email e senha Invalido");
    }

    @Entao("^retorna mensagem de erro na autenticacao$")
    public void retornaMensagemDeErroNaAutenticacao() throws IOException{
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(),containsString("Authentication failed."));
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 3 - Passo 3 - Mensagem de Autenticação Falhada");
    }

    @Dado("^que acesso a pagina de autenticacao$")
    public void queAcessoAPaginaDeAutenticacao() throws IOException {
        driver.get(url);
        driver.findElement(By.cssSelector("a.login")).click();
        assertThat(driver.findElement(By.cssSelector("span.navigation_page")).getText(),is("Authentication"));
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 4 - Passo 1 - Validar a Pagina de Autenticacao");
    }

    @Quando("^digito no campo \"([^\"]*)\" e clico no link Forgot You Password$")
    public void digitoNoCampoEClicoNoLinkForgotYouPassword(String arg0) throws Throwable {
        driver.findElement(By.id("email")).sendKeys("samuel.siqueira.pereira@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/p[1]/a")).click();
        evidences.takeScreenshot(driver,pastaPrint,"Cenário 4 - Passo 2 - Informar o email");
    }

    @Entao("^informo \"([^\"]*)\" e clico no botao Retrieve Password$")
    public void informoEClicoNoBotaoRetrievePassword(String arg0) throws Throwable {
        driver.findElement(By.id("email")).sendKeys("samuel.siqueira.pereira@gmail.com");
        assertEquals("Forgot your password - My Store",driver.getTitle());

    }
}
