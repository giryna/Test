package extensions

import com.thoughtworks.selenium.Selenium

/**
  * Created by iryna on 31.08.16.
  */
object SeleniumExtensions {

  implicit class SeleniumExtension(val selenium: Selenium) extends AnyVal {
    def input(locator: String, value: String) = {
      selenium.`type`(locator, value)
    }
  }

}
