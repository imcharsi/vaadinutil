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

import java.util.Locale

import com.vaadin.data.util.converter.Converter

import scala.reflect.ClassTag

/**
 * Created by KangWoo,Lee on 14. 7. 29.
 */
abstract class AbstractConverter[Presentation <: AnyRef, Model <: AnyRef](implicit presentationClassTag: ClassTag[Presentation], modelClassTag: ClassTag[Model]) extends Converter[Presentation, Model] {
  override def getPresentationType: Class[Presentation] = presentationClassTag.runtimeClass.asInstanceOf[Class[Presentation]]

  override def getModelType: Class[Model] = modelClassTag.runtimeClass.asInstanceOf[Class[Model]]
}

abstract class AbstractStringConverter[Model <: AnyRef](implicit modelClassTag: ClassTag[Model]) extends AbstractConverter[String, Model] {
  override def convertToModel(value: String, targetType: Class[_ <: Model], locale: Locale): Model = {
    if (value == null)
      null.asInstanceOf[Model]
    else
      innerConvertToModel(value, targetType, locale)
  }

  protected def innerConvertToModel(value: String, targetType: Class[_ <: Model], locale: Locale): Model

  override def convertToPresentation(value: Model, targetType: Class[_ <: String], locale: Locale): String = {
    if (value == null)
      null.asInstanceOf[String]
    else
      innerConvertToPresentation(value, targetType, locale)
  }

  protected def innerConvertToPresentation(value: Model, targetType: Class[_ <: String], locale: Locale): String
}

abstract class AbstractOptionStringConverter[Model](implicit modelClassTag: ClassTag[Model]) extends AbstractStringConverter[Option[Model]] {
  override def convertToModel(value: String, targetType: Class[_ <: Option[Model]], locale: Locale): Option[Model] = {
    if (value == null)
      None
    else
      super.convertToModel(value, targetType, locale)
  }

  override def convertToPresentation(value: Option[Model], targetType: Class[_ <: String], locale: Locale): String = {
    if (value == null || value == None)
      null.asInstanceOf[String]
    else
      super.convertToPresentation(value, targetType, locale)
  }
}