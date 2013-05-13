package com.uqbar.chocolate.utils.commoncomponents.ui

import com.uqbar.chocolate.core.appearances.Appearance
import com.uqbar.chocolate.core.collisions.NoBoundingBox
import com.uqbar.chocolate.core.reactions.annotations.OnCustomEvent
import UIComponent._
import com.uqbar.chocolate.core.components.Visible
import com.uqbar.chocolate.core.components.Collisionable

object UIComponent {
	final val UI_COMPONENT_CG = 7772
	final val MAIN_ACTION = "UI Main Action"
}

trait UIComponent extends Visible with Collisionable {

	val collisionGroup = UI_COMPONENT_CG

	// ****************************************************************
	// ** TRIGGERS
	// ****************************************************************

	@OnCustomEvent(MAIN_ACTION)
	def performMainAction
}