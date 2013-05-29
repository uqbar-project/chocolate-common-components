package org.uqbar.chocolate.utils.commoncomponents;

import org.uqbar.chocolate.core.appearances.Appearance
import org.uqbar.chocolate.core.collisions.BoundingBox
import org.uqbar.chocolate.core.reactions.annotations.io.mouse.OnMouseMoved
import org.uqbar.chocolate.core.utils.Implicits._
import org.uqbar.chocolate.core.components.Collisionable
import org.uqbar.chocolate.core.components.Visible
import org.uqbar.chocolate.core.components.GameComponent
import org.uqbar.chocolate.core.dimensions.Positioned
import org.uqbar.chocolate.core.reactions.events.MouseMovedEvent

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