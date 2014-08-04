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
