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
