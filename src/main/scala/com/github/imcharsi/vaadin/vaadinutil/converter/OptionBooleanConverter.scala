package com.github.imcharsi.vaadin.vaadinutil.converter

import java.lang
import java.util.Locale

/**
 * Created by KangWoo,Lee on 14. 8. 3.
 */
object OptionBooleanConverter extends AbstractConverter[java.lang.Boolean, Option[Boolean]] {
  override def convertToModel(value: lang.Boolean, targetType: Class[_ <: Option[Boolean]], locale: Locale): Option[Boolean] = {
    if (value == null)
      None
    else
      Some(value.booleanValue())
  }

  override def convertToPresentation(value: Option[Boolean], targetType: Class[_ <: lang.Boolean], locale: Locale): lang.Boolean = {
    value.map(x ⇒ java.lang.Boolean.valueOf(x)).getOrElse(null)
  }
}
