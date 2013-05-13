package com.uqbar.chocolate.utils.commoncomponents;

import com.uqbar.chocolate.core.appearances.Appearance
import com.uqbar.chocolate.core.collisions.BoundingBox
import com.uqbar.chocolate.core.reactions.annotations.io.mouse.OnMouseMoved
import com.uqbar.chocolate.core.reactions.events.io.mouse.MouseMovedEvent
import com.uqbar.chocolate.core.utils.Implicits._
import com.uqbar.chocolate.core.components.Collisionable
import com.uqbar.chocolate.core.components.Visible
import com.uqbar.chocolate.core.components.GameComponent
import com.uqbar.chocolate.core.dimensions.Positioned

trait Cursor extends GameComponent with Positioned {

	// ****************************************************************
	// ** INITIALIZATION
	// ****************************************************************

	z = Integer.MAX_VALUE

	// ****************************************************************
	// ** TRIGGERS
	// ****************************************************************

	@OnMouseMoved
	def updatePosition(e : MouseMovedEvent) = translation = (e.position.x, e.position.y)
}