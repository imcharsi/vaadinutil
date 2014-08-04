package com.github.imcharsi.vaadin.vaadinutil.listener

import com.vaadin.ui.MenuBar
import com.vaadin.ui.MenuBar.Command

/**
 * Created by KangWoo,Lee on 14. 7. 30.
 */
object MenuBarCommandConverter {

  private class CommandImpl[T](f: MenuBar#MenuItem ⇒ T) extends Command {
    override def menuSelected(selectedItem: MenuBar#MenuItem): Unit = f(selectedItem)
  }

  implicit def convertMenuBarCommand[T](f: MenuBar#MenuItem ⇒ T): Command = new CommandImpl(f)
}
