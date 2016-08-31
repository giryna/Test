package selenium.auth

import java.util.concurrent.TimeUnit

import com.thoughtworks.selenium.Selenium
import extensions.SeleniumExtensions._
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui._
import org.openqa.selenium.{By, WebDriver, WebDriverBackedSelenium}
import org.scalatest.selenium.WebBrowser
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}
import pages.SignInPage

/**
  * Created by iryna on 29.08.16.
  */
class ResetPasswordSpecs extends FlatSpec with Matchers with WebBrowser with BeforeAndAfter {
  val USER_EMAIL: String = "gavrilyuk.iryna@gmail.com"
  val USER_PASS: String = "gavrilyuk.iryna@gmail.com"

  "Forgot password page" should "resetPassword" in {
    resetPassword()
  }
  it should "notIdenticalPasswords" in {
    notIdenticalPasswords()
  }
  it should "generatePassword" in {
    generatePassword()
  }
  it should "inactiveSendButton" in {
    inactiveSendButton()
  }
  implicit var driver: WebDriver = _
  var selenium: Selenium = _

  before {
    System.setProperty("webdriver.chrome.driver", "/home/iryna/seleniumdrivers/chromedriver")
    driver = new ChromeDriver()
    selenium = new WebDriverBackedSelenium(driver, "http://alpha2.dsources.com/")
  }

  after {
    driver.close()
  }

  def resetPassword() = {
    selenium.open(SignInPage.Urls.SIGN_IN_PAGE_TAG_URL)
    selenium.click(SignInPage.FORGOT_PASSWORD_LINK)
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_EMAIL_RESET_PAGE, USER_EMAIL)
    selenium.input(SignInPage.ID_SELECTOR_INPUT_NEW_PASSWORD, USER_PASS)
    selenium.input(SignInPage.XPATH_SELECTOR_INPUT_REPEAT_PASSWORD, USER_PASS)
    selenium.click("//button")
    println("Url for \"Reset Password\" page is " + driver.getCurrentUrl)
    driver.getCurrentUrl should be(SignInPage.Urls.RESET_PAGE_URL)
    val waiter = new WebDriverWait(driver, 5)
    waiter.until(ExpectedConditions.textToBePresentInElement(By.className("ng-binding"), "Sign in to DataSources"))
    driver.getCurrentUrl should be("http://alpha2.dsources.com/#/signin")
  }

  def generatePassword() = {
    selenium.open(SignInPage.Urls.SIGN_IN_PAGE_TAG_URL)
    selenium.click(SignInPage.FORGOT_PASSWORD_LINK)
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_EMAIL_RESET_PAGE, USER_EMAIL)

    driver.findElement(SignInPage.XPATH_SELECTOR_GENERATE_PASSWORD_BUTTON).click()
    val newPass = driver.findElement(By.id("newPassword")).getText
    val repeatPass = driver.findElement(SignInPage.CSS_SELECTOR_REPEAT_PASSWORD_FIELD).getText

    newPass should equal(repeatPass)
    //    try {
    //      val waiter = new WebDriverWait(driver, 2)
    //      waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), \"Reset \")]")))
    //    } finally {
    //      val el = driver.findElement(By.xpath("//*[contains(text(), \"Reset \")]"))
    //      println("search" + el)

  }

  def notIdenticalPasswords() = {
    selenium.open(SignInPage.Urls.SIGN_IN_PAGE_TAG_URL)
    selenium.click(SignInPage.FORGOT_PASSWORD_LINK)
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_EMAIL_RESET_PAGE, USER_EMAIL)
    selenium.input(SignInPage.ID_SELECTOR_INPUT_NEW_PASSWORD, USER_PASS)
    selenium.input(SignInPage.XPATH_SELECTOR_INPUT_REPEAT_PASSWORD, "negativeTest")
    val el = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[3]/div/div/strong"))
    el.getText should be("Passwords are not identical")
    println("If passwords are different, appears the next error message: \"" + el.getText + "\"")
  }

  def inactiveSendButton() = {
    selenium.open(SignInPage.Urls.SIGN_IN_PAGE_TAG_URL)
    selenium.click(SignInPage.FORGOT_PASSWORD_LINK)
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_EMAIL_RESET_PAGE, USER_EMAIL)
    selenium.input(SignInPage.ID_SELECTOR_INPUT_NEW_PASSWORD, USER_PASS)
    val el = driver.findElement(SignInPage.XPATH_SELECTOR_SEND_PASSWORD_BUTTON)
    println("Send button is selected - " + el.isSelected)
    el.isSelected should be(false)
  }
}


