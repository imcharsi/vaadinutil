/*
 * #%L
 * vaadinutil
 * %%
 * Copyright (C) 2014 KangWoo, Lee
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
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

