package com.paranoidkiwi.chocolate.utils.commoncomponents.ui;

import com.paranoidkiwi.chocolate.core.appearances.Appearance;
import com.paranoidkiwi.chocolate.core.collisions.BoundingBox;
import com.paranoidkiwi.chocolate.core.components.CollisionableComponent;
import com.paranoidkiwi.chocolate.core.reactions.annotations.io.mouse.OnMousePressed;
import com.paranoidkiwi.chocolate.core.reactions.enums.MouseButton;
import com.paranoidkiwi.chocolate.core.reactions.events.CustomEvent;
import com.paranoidkiwi.chocolate.utils.commoncomponents.Cursor;

object 	UICursor {
	final val UI_CURSOR_CG = 7773
}

import UICursor._

class UICursor(appearance: Appearance, boundingBox: BoundingBox) extends Cursor(appearance, boundingBox, UI_CURSOR_CG) {

	// ****************************************************************
	// ** TRIGGERS
	// ****************************************************************

	@OnMousePressed(button = MouseButton.LEFT)
	def requireMainAction = {
		def componentUnder = affectedComponent

		if (componentUnder != null) {
			componentUnder.reactTo(new CustomEvent(UIComponent.MAIN_ACTION))
		}
	}

	// ****************************************************************
	// ** QUERIES
	// ****************************************************************

	def affectedComponent = collidingComponents maxBy { _.z }
}