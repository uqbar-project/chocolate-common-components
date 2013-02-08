package com.paranoidkiwi.chocolate.utils.commoncomponents;

import com.paranoidkiwi.chocolate.core.appearances.Appearance
import com.paranoidkiwi.chocolate.core.collisions.BoundingBox
import com.paranoidkiwi.chocolate.core.components.CollisionableComponent
import com.paranoidkiwi.chocolate.core.components.DEFAULT_POSITION
import com.paranoidkiwi.chocolate.core.reactions.annotations.io.mouse.OnMouseMoved
import com.paranoidkiwi.chocolate.core.reactions.events.io.mouse.MouseMovedEvent
import com.paranoidkiwi.chocolate.core.utils.Implicits._

abstract class Cursor(appearance: Appearance, boundingBox: BoundingBox, collisionGroup: Int) 
	extends CollisionableComponent(DEFAULT_POSITION, appearance, boundingBox, collisionGroup) {

	// ****************************************************************
	// ** INITIALIZATION
	// ****************************************************************

	z = Integer.MAX_VALUE

	// ****************************************************************
	// ** TRIGGERS
	// ****************************************************************

	@OnMouseMoved
	def updatePosition(e: MouseMovedEvent) = position = e.getPosition
}