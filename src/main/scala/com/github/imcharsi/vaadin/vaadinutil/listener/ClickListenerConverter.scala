package com.github.imcharsi.vaadin.vaadinutil.listener

import com.vaadin.ui.Button.{ClickEvent, ClickListener}

/**
 * Created by KangWoo,Lee on 14. 7. 29.
 */
object ClickListenerConverter {

  private class ClickListenerImpl[T](f: ClickEvent ⇒ T) extends ClickListener {
    override def buttonClick(event: ClickEvent): Unit = f(event)
  }

  implicit def convertClickListener[T](f: ClickEvent ⇒ T): ClickListener = new ClickListenerImpl(f)
}
