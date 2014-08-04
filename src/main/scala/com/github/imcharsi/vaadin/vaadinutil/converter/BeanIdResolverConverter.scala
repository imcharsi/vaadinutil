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
