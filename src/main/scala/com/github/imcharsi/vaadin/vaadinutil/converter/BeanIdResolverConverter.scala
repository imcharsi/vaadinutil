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

import com.vaadin.data.util.AbstractBeanContainer.BeanIdResolver

/**
 * Created by KangWoo,Lee on 14. 7. 28.
 */
object BeanIdResolverConverter {

  private class BeanIdResolverImpl[IdType, BeanType](f: BeanType ⇒ IdType) extends BeanIdResolver[IdType, BeanType] {
    override def getIdForBean(p1: BeanType): IdType = f(p1)
  }

  implicit def convertBeanIdResolver[IdType, BeanType](f: BeanType ⇒ IdType): BeanIdResolver[IdType, BeanType] = new BeanIdResolverImpl(f)
}
