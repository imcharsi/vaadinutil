package com.github.imcharsi.vaadin.vaadinutil.listener

import com.vaadin.data.fieldgroup.FieldGroup.{CommitEvent, CommitHandler}

/**
 * Created by KangWoo,Lee on 14. 7. 29.
 */
object CommitHandlerConverter {

  private class CommitHandlerImpl[T1, T2](f1: Option[CommitEvent ⇒ T1] = None, f2: Option[CommitEvent ⇒ T2] = None) extends CommitHandler {
    override def preCommit(commitEvent: CommitEvent): Unit = f1.foreach(_.apply(commitEvent))

    override def postCommit(commitEvent: CommitEvent): Unit = f2.foreach(_.apply(commitEvent))
  }

  implicit def convertPostHandler[T](f: CommitEvent ⇒ T): CommitHandler = new CommitHandlerImpl(None, Some(f))

  implicit def convertHandler[T1, T2](f1: CommitEvent ⇒ T1, f2: CommitEvent ⇒ T2): CommitHandler = new CommitHandlerImpl(Some(f1), Some(f2))
}
