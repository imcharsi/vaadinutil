package com.github.imcharsi.vaadin.vaadinutil.converter

import java.sql.Date
import java.util.Locale

import com.vaadin.data.util.converter.Converter.ConversionException
import org.apache.commons.lang3.time.FastDateFormat

import scala.util.{Failure, Success, Try}

/**
 * Created by KangWoo,Lee on 14. 7. 30.
 */
class OptionDateConverter(pattern: String = "yyyy-MM-dd") extends AbstractOptionStringConverter[Date] {
  val fastDateFormat: FastDateFormat = FastDateFormat.getInstance(pattern, Locale.getDefault)

  override protected def innerConvertToModel(value: String, targetType: Class[_ <: Option[Date]], locale: Locale): Option[Date] = {
    Try(Some(fastDateFormat.parse(value)).map(_.getTime).map(new Date(_))) match {
      case Success(x) ⇒ x
      case Failure(x) ⇒ throw new ConversionException(x)
    }
  }

  override protected def innerConvertToPresentation(value: Option[Date], targetType: Class[_ <: String], locale: Locale): String = {
    Try(value.map(fastDateFormat.format)) match {
      case Success(Some(x)) ⇒ x
      case Success(None) ⇒ null
      case Failure(x) ⇒ throw new ConversionException(x)
    }
  }
}

object OptionDateConverter extends OptionDateConverter("yyyy-MM-dd")

class OptionDateConverter2(pattern: String = "yyyy-MM-dd") extends AbstractConverter[java.util.Date, Option[Date]] {
  val fastDateFormat: FastDateFormat = FastDateFormat.getInstance(pattern, Locale.getDefault)

  override def convertToModel(p1: java.util.Date, p2: Class[_ <: Option[Date]], p3: Locale): Option[Date] = {
    if (p1 == null)
      None
    else
      Some(new Date(p1.getTime))
  }

  override def convertToPresentation(p1: Option[Date], p2: Class[_ <: java.util.Date], p3: Locale): java.util.Date = {
    p1 match {
      case Some(x) ⇒ x
      case None ⇒ null
    }
  }
}

object OptionDateConverter2 extends OptionDateConverter2("yyyy-MM-dd")
