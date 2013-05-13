package com.uqbar.chocolate.utils.commoncomponents.ui

import com.uqbar.chocolate.core.appearances.Appearance
import com.uqbar.chocolate.core.collisions.BoundingBox
import com.uqbar.chocolate.core.dimensions.Vector
import com.uqbar.chocolate.core.collisions.RectangularBoundingBox

class Button(position : Vector, val appearance : Appearance, mainAction : UIAction) extends UIComponent {

	translation = position
	val boundingBox = new RectangularBoundingBox(appearance.width, appearance.height)

	// ****************************************************************
	// ** OPERATIONS
	// ****************************************************************

	override def performMainAction = mainAction perform this
}