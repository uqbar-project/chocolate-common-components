package org.uqbar.chocolate.utils.commoncomponents.ui;

trait UIAction {

	// ****************************************************************
	// ** OPERATIONS
	// ****************************************************************

	def perform(component: UIComponent): Unit
}
