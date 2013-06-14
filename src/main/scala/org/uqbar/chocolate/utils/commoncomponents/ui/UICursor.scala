package org.uqbar.chocolate.utils.commoncomponents.ui;

import org.uqbar.chocolate.core.appearances.Appearance
import org.uqbar.chocolate.core.collisions.BoundingBox
import org.uqbar.chocolate.core.reactions.annotations.io.enums.MouseButton
import org.uqbar.chocolate.core.reactions.annotations.io.mouse.OnMousePressed
import org.uqbar.chocolate.core.reactions.events.CustomEvent
import org.uqbar.chocolate.utils.commoncomponents.Cursor
import UICursor._
import org.uqbar.chocolate.core.components.Collisionable
import org.uqbar.chocolate.core.components.Visible

object UICursor {
	final val UI_CURSOR_CG = 7773
}

class UICursor(val appearance : Appearance, val boundingBox : BoundingBox) extends Cursor with Visible with Collisionable {

	def collisionGroup = UI_CURSOR_CG

	// ****************************************************************
	// ** TRIGGERS
	// ****************************************************************

	@OnMousePressed(button = MouseButton.LEFT)
	def requireMainAction = affectedComponent.foreach(_.reactTo(new CustomEvent(UIComponent.MAIN_ACTION)))

	// ****************************************************************
	// ** QUERIES
	// ****************************************************************

	def affectedComponent = if (collidingComponents.isEmpty) None else Some(collidingComponents maxBy { _.z })
}