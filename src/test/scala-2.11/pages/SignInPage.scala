package pages

import org.openqa.selenium.{By, WebDriver}

/**
  * Created by iryna on 31.08.16.
  */
class SignInPage(webDriver: WebDriver) {

  lazy val generatePasswordButton = webDriver.findElement(SignInPage.XPATH_SELECTOR_GENERATE_PASSWORD_BUTTON)
  lazy val signInButton = webDriver.findElement(By.id(SignInPage.ID_SELECTOR_SIGN_IN_BUTTON))
}

object SignInPage {

  val XPATH_SELECTOR_SIGN_IN_FORM_HEADER: By = By.xpath("//*[contains(text(), \"Sign \")]")
  val XPATH_SELECTOR_LOGOUT_BUTTON: By = By.xpath("/html/body/div[2]/div[2]/div[1]/div/ng-include/div/div[9]/a/h3")
  val XPATH_SELECTOR_EMAIL_FIELD: By = By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[1]/div/div/input")
  val CSS_SELECTOR_PASSWORD_FIELD: By = By.cssSelector("body > div > div > div > div.ng-scope > div.panel.panel-default.auth-modal.ng-scope > div > form > div:nth-child(2) > div > div > input")
  val TYPE_SELECTOR_INPUT_EMAIL: String = "//input[@type='email']"
  val TYPE_SELECTOR_INPUT_PASSWORD: String = "//input[@type='password']"
  val ID_SELECTOR_SIGN_IN_BUTTON: String = "id=signIn"
  val XPATH_SELECTOR_INCORRECT_LOGIN_PASS_MESSAGE: By = By.xpath("/html/body/div/div/div/div[2]/div[1]/strong")
  val FORGOT_PASSWORD_LINK: String = "link=exact:Forgot password?"
  val XPATH_SELECTOR_GENERATE_PASSWORD_BUTTON: By = By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div/div/div/strong")
  val CSS_SELECTOR_REPEAT_PASSWORD_FIELD: By = By.cssSelector("body > div > div > div > div.ng-scope > div > div > div:nth-child(3) > div > div > input")

  object Urls {
    val SIGN_IN_PAGE_TAG_URL: String = "/#/signin"
    val SIGN_IN_PAGE_URL: String = "http://alpha2.dsources.com/#/signin"
    val BASE_URL: String = "http://alpha2.dsources.com/"
    val PROFILE_URL: String = "http://alpha2.dsources.com/#/profile"
  }

  def apply(webDriver: WebDriver) = new SignInPage(webDriver)

}
