package pages

import org.openqa.selenium.By

/**
  * Created by iryna on 01.09.16.
  */
object ResetPasswordPage {
  val XPATH_SELECTOR_SEND_PASSWORD_BUTTON: By = By.xpath("//*[contains(text(), \"Send password \")]")
  val TYPE_SELECTOR_INPUT_EMAIL_RESET_PAGE: String = "//input[@type='text']"
  val ID_SELECTOR_INPUT_NEW_PASSWORD: String = "id=newPassword"
  val XPATH_SELECTOR_INPUT_REPEAT_PASSWORD: String = "xpath=(//input[@type='text'])[3]"

  object Urls {
    val RESET_PAGE_URL: String = "http://alpha2.dsources.com/#/reset"
  }

}
