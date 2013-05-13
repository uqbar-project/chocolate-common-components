package com.uqbar.chocolate.utils.commoncomponents.ui;

import com.uqbar.chocolate.core.appearances.Appearance
import com.uqbar.chocolate.core.collisions.BoundingBox
import com.uqbar.chocolate.core.reactions.annotations.io.mouse.OnMousePressed
import com.uqbar.chocolate.core.reactions.enums.MouseButton
import com.uqbar.chocolate.core.reactions.events.CustomEvent
import com.uqbar.chocolate.utils.commoncomponents.Cursor;

import UICursor._
import com.uqbar.chocolate.core.components.Collisionable

object UICursor {
	final val UI_CURSOR_CG = 7773
}

class UICursor(val boundingBox : BoundingBox) extends Cursor with Collisionable {

	def collisionGroup = UI_CURSOR_CG

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