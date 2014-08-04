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
package com.github.imcharsi.vaadin.vaadinutil.listener

import com.vaadin.data.Property.{ValueChangeEvent, ValueChangeListener}

/**
 * Created by KangWoo,Lee on 14. 7. 29.
 */
object ValueChangeListenerConverter {

  private class ValueChangeListenerImpl[T](f: ValueChangeEvent ⇒ T) extends ValueChangeListener {
    override def valueChange(event: ValueChangeEvent): Unit = f(event)
  }

  implicit def convertValueChangeListener[T](f: ValueChangeEvent ⇒ T): ValueChangeListener = new ValueChangeListenerImpl(f)
}
