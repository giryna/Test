package selenium.auth

import com.thoughtworks.selenium.Selenium
import extensions.SeleniumExtensions._
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{WebDriver, WebDriverBackedSelenium}
import org.scalatest._
import org.scalatest.selenium.WebBrowser
import pages.SignInPage
import utils.Utils

/**
  * Created by iryna on 25.08.16.
  */
class LoginSpecs extends FlatSpec with Matchers with WebBrowser with BeforeAndAfter {

  val USER_EMAIL: String = "gavrilyuk.iryna@gmail.com"
  val USER_PASS: String = "gavrilyuk.iryna@gmail.com"



  val INVALID_PASSWORD: String = "NegativeTestCase"
  val INVALID_PASSWORD_1: String = "invalidPasswordwith@tratata"

  var signInPage: SignInPage = _

  "The DataSources authorization" should "signIn" in {
    signIn()
  }

  it should "invalidLogin" in {
    invalidLogin()
  }


  it should "invalidPassword" in {
    invalidPassword(INVALID_PASSWORD)
    invalidPassword(INVALID_PASSWORD_1)
  }
  it should "emailFieldIsRequired" in {
    emailFieldIsRequired()
  }
  it should "passwordFieldIsRequired" in {
    passwordFieldIsRequired()
  }
  before {
    Utils.initialize()
    driver = new ChromeDriver()
    val webDriver = new WebDriverBackedSelenium(driver, SignInPage.Urls.BASE_URL)
    selenium = webDriver
    signInPage = new SignInPage(webDriver.getWrappedDriver())
  }

  after {
    driver.close()
  }

  implicit var driver: WebDriver = _
  var selenium: Selenium = _

  def signIn() = {
    selenium.open(SignInPage.Urls.SIGN_IN_PAGE_TAG_URL)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_EMAIL, USER_EMAIL)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_PASSWORD, USER_PASS)

    val elem = driver.findElement(SignInPage.XPATH_SELECTOR_SIGN_IN_FORM_HEADER)
    println("Test for \"" + elem.getText + "\" page is completed.")
    selenium.click(SignInPage.ID_SELECTOR_SIGN_IN_BUTTON)
    Thread.sleep(2000)
    println("URL for \"Profile page\" (after success login) " + driver.getCurrentUrl)
    driver.getCurrentUrl should be(SignInPage.Urls.PROFILE_URL)
    //    driver.findElement(SignInPage.XPATH_SELECTOR_LOGOUT_BUTTON).click()
    //    Thread.sleep(1000)
  }

  def invalidPassword(password: String) = {
    selenium.open(SignInPage.Urls.SIGN_IN_PAGE_TAG_URL)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_EMAIL, USER_EMAIL)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_PASSWORD, password)
    signInPage.signInButton.click()
    Thread.sleep(3000)
    val elem = driver.findElement(SignInPage.XPATH_SELECTOR_INCORRECT_LOGIN_PASS_MESSAGE)
    println("Error message for incorrect login or password - " + elem.getText)
    elem.getText should be("Invalid Email or password")
  }

  def invalidLogin() = {
    selenium.open(SignInPage.Urls.SIGN_IN_PAGE_TAG_URL)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_EMAIL, "email@example.com")
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_PASSWORD, USER_PASS)
    selenium.click(SignInPage.ID_SELECTOR_SIGN_IN_BUTTON)
    Thread.sleep(3000)
    val elem = driver.findElement(SignInPage.XPATH_SELECTOR_INCORRECT_LOGIN_PASS_MESSAGE)
    println("Error message for incorrect login is displayed - " + elem.isDisplayed)
    elem.isDisplayed should be(true)
  }

  def emailFieldIsRequired() = {
    selenium.open(SignInPage.Urls.SIGN_IN_PAGE_TAG_URL)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_PASSWORD, USER_PASS)
    selenium.click(SignInPage.ID_SELECTOR_SIGN_IN_BUTTON)
    Thread.sleep(3000)
    val elem = driver.findElement(SignInPage.XPATH_SELECTOR_EMAIL_FIELD)
    println("Email field is required - " + elem.getAttribute("required"))
    elem.getAttribute("required") should be("true")
  }

  def passwordFieldIsRequired() = {
    selenium.open(SignInPage.Urls.SIGN_IN_PAGE_TAG_URL)
    selenium.input(SignInPage.TYPE_SELECTOR_INPUT_EMAIL, USER_EMAIL)
    selenium.click(SignInPage.ID_SELECTOR_SIGN_IN_BUTTON)
    Thread.sleep(3000)
    val elem = driver.findElement(SignInPage.CSS_SELECTOR_PASSWORD_FIELD)
    println("Password field is required - " + elem.getAttribute("required"))
    elem.getAttribute("required") should be("true")
  }

}