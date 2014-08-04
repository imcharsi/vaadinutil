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
