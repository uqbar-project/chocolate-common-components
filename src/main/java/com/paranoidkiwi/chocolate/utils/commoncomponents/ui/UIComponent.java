package com.paranoidkiwi.chocolate.utils.commoncomponents.ui;

import com.paranoidkiwi.chocolate.core.appearances.Appearance;
import com.paranoidkiwi.chocolate.core.bounds.NoBoundingBox;
import com.paranoidkiwi.chocolate.core.components.CollisionableComponent;
import com.paranoidkiwi.chocolate.core.reactions.annotations.OnCustomEvent;

public abstract class UIComponent extends CollisionableComponent {

	public static final int UI_COMPONENT_CG = 7772;
	public static final String MAIN_ACTION = "UI Main Action";

	// ****************************************************************
	// ** CONSTRUCTORS
	// ****************************************************************

	public UIComponent(Appearance appearance, double x, double y) {
		super(new NoBoundingBox(), UI_COMPONENT_CG, x, y);

		this.setAppearance(appearance);
	}

	// ****************************************************************
	// ** TRIGGERS
	// ****************************************************************

	@OnCustomEvent(MAIN_ACTION)
	public abstract void performMainAction();
}