package org.uqbar.chocolate.utils.commoncomponents.ui

import org.uqbar.chocolate.core.appearances.Appearance
import org.uqbar.chocolate.core.collisions.BoundingBox
import org.uqbar.chocolate.core.dimensions.Vector
import org.uqbar.chocolate.core.collisions.RectangularBoundingBox

class Button(val appearance : Appearance)(position : Vector)(mainAction : UIComponent ⇒ Unit) extends UIComponent {

	translation = position
	val boundingBox = new RectangularBoundingBox(appearance.width, appearance.height)

	// ****************************************************************
	// ** OPERATIONS
	// ****************************************************************

	override def performMainAction = mainAction(this)
}