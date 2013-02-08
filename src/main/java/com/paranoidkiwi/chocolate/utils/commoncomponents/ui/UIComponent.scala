package com.paranoidkiwi.chocolate.utils.commoncomponents.ui

import com.paranoidkiwi.chocolate.core.appearances.Appearance
import com.paranoidkiwi.chocolate.core.collisions.NoBoundingBox
import com.paranoidkiwi.chocolate.core.components.CollisionableComponent
import com.paranoidkiwi.chocolate.core.dimensions.Position
import com.paranoidkiwi.chocolate.core.reactions.annotations.OnCustomEvent

object UIComponent {
	final val UI_COMPONENT_CG = 7772
	final val MAIN_ACTION = "UI Main Action"
}

import UIComponent._

abstract class UIComponent(position: Position, appearance: Appearance) 
	extends CollisionableComponent(position, appearance, NoBoundingBox, UI_COMPONENT_CG) {
  

	// ****************************************************************
	// ** TRIGGERS
	// ****************************************************************

	@OnCustomEvent(MAIN_ACTION)
	def performMainAction
}