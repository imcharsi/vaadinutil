package com.github.imcharsi.vaadin.vaadinutil.converter

import java.text.NumberFormat
import java.util.Locale

import com.vaadin.data.util.converter.Converter.ConversionException

import scala.util.{Failure, Success, Try}

/**
 * Created by KangWoo,Lee on 14. 7. 29.
 */
object OptionIntConverter extends AbstractOptionStringConverter[Int] {
  override protected def innerConvertToModel(value: String, targetType: Class[_ <: Option[Int]], locale: Locale): Option[Int] = {
    Try(NumberFormat.getInstance().parse(value)).map(_.intValue()) match {
      case Success(x) ⇒ Some(x)
      case Failure(x) ⇒ throw new ConversionException(x)
    }
  }

  override protected def innerConvertToPresentation(value: Option[Int], targetType: Class[_ <: String], locale: Locale): String = {
    Try(value.map(x ⇒ NumberFormat.getInstance().format(x))) match {
      case Success(Some(x)) ⇒ x
      case Success(None) ⇒ null
      case Failure(x) ⇒ throw new ConversionException(x)
    }
  }
}

