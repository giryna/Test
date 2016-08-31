package pages

import org.openqa.selenium.By

/**
  * Created by iryna on 31.08.16.
  */
object SignInPage {

  val XPATH_SELECTOR_SIGN_IN_FORM_HEADER: By = By.xpath("//*[contains(text(), \"Sign \")]")
  val XPATH_SELECTOR_LOGOUT_BUTTON: By = By.xpath("/html/body/div[2]/div[2]/div[1]/div/ng-include/div/div[9]/a/h3")
  val XPATH_SELECTOR_EMAIL_FIELD: By = By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[1]/div/div/input")
  val CSS_SELECTOR_PASSWORD_FIELD: By = By.cssSelector("body > div > div > div > div.ng-scope > div.panel.panel-default.auth-modal.ng-scope > div > form > div:nth-child(2) > div > div > input")
  val TYPE_SELECTOR_INPUT_EMAIL: String = "//input[@type='email']"
  val TYPE_SELECTOR_INPUT_PASSWORD: String = "//input[@type='password']"
  val ID_SELECTOR_SIGN_IN_BUTTON: String = "id=signIn"
  val XPATH_SELECTOR_INCORRECT_LOGIN_PASS_MESSAGE: By = By.xpath("/html/body/div/div/div/div[2]/div[1]/strong")
  val XPATH_SELECTOR_SEND_PASSWORD_BUTTON: By = By.xpath("//*[contains(text(), \"Send password \")]")
  val FORGOT_PASSWORD_LINK: String = "link=exact:Forgot password?"
  val TYPE_SELECTOR_INPUT_EMAIL_RESET_PAGE: String = "//input[@type='text']"
  val ID_SELECTOR_INPUT_NEW_PASSWORD: String = "id=newPassword"
  val XPATH_SELECTOR_INPUT_REPEAT_PASSWORD: String = "xpath=(//input[@type='text'])[3]"
  val XPATH_SELECTOR_GENERATE_PASSWORD_BUTTON: By = By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div/div/div/strong")
  val CSS_SELECTOR_REPEAT_PASSWORD_FIELD: By = By.cssSelector("body > div > div > div > div.ng-scope > div > div > div:nth-child(3) > div > div > input")
  object Urls {
    val SIGN_IN_PAGE_TAG_URL: String = "/#/signin"
    val RESET_PAGE_URL: String = "http://alpha2.dsources.com/#/reset"
  }
}
