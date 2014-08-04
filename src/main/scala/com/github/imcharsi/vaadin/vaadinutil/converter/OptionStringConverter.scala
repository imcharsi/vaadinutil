package com.github.imcharsi.vaadin.vaadinutil.converter

import java.util.Locale

/**
 * Created by KangWoo,Lee on 14. 7. 29.
 */
object OptionStringConverter extends AbstractOptionStringConverter[String] {
  override protected def innerConvertToModel(value: String, targetType: Class[_ <: Option[String]], locale: Locale): Option[String] = {
    Option(value)
  }

  override protected def innerConvertToPresentation(value: Option[String], targetType: Class[_ <: String], locale: Locale): String = {
    value.getOrElse(null.asInstanceOf[String])
  }
}
