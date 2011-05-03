package com.paranoidkiwi.chocolate.utils.commoncomponents.ui;

import com.paranoidkiwi.chocolate.core.appearances.VisualStrategy;
import com.paranoidkiwi.chocolate.core.bounds.NoBoundingBox;
import com.paranoidkiwi.chocolate.core.components.CollisionableComponent;
import com.paranoidkiwi.chocolate.core.reactions.annotations.OnCustomEvent;

public abstract class UIComponent extends CollisionableComponent {

	public static final int UI_COMPONENT_CG = 7772;
	public static final String MAIN_ACTION = "UI Main Action";

	// ****************************************************************
	// ** CONSTRUCTORS
	// ****************************************************************

	public UIComponent(VisualStrategy visualStrategy, double x, double y) {
		super(new NoBoundingBox(), UI_COMPONENT_CG, x, y);

		this.setVisualStrategy(visualStrategy);
	}

	// ****************************************************************
	// ** TRIGGERS
	// ****************************************************************

	@OnCustomEvent(MAIN_ACTION)
	public abstract void performMainAction();
}