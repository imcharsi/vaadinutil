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
package com.github.imcharsi.vaadin.vaadinutil.property

import com.vaadin.data.Property
import com.vaadin.data.util.{AbstractProperty, VaadinPropertyDescriptor}

import scala.reflect.ClassTag

/**
 * Created by KangWoo,Lee on 14. 7. 29.
 */
class FunctionPropertyDescriptor[BeanType, PropertyType](name: String, f: BeanType ⇒ PropertyType)(implicit ct: ClassTag[PropertyType]) extends VaadinPropertyDescriptor[BeanType] {
  override def getName: String = name

  override def getPropertyType: Class[PropertyType] = ct.runtimeClass.asInstanceOf[Class[PropertyType]]

  override def createProperty(bean: BeanType): Property[PropertyType] = new FunctionProperty(bean, f)
}

class FunctionProperty[BeanType, PropertyType](bean: BeanType, f: BeanType ⇒ PropertyType)(implicit ct: ClassTag[PropertyType]) extends AbstractProperty[PropertyType] {
  override def getValue: PropertyType = f(bean)

  override def getType: Class[_ <: PropertyType] = ct.runtimeClass.asInstanceOf[Class[PropertyType]]

  override def setValue(newValue: PropertyType): Unit = ???
}
