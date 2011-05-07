package com.paranoidkiwi.chocolate.utils.commoncomponents.ui;

import com.paranoidkiwi.chocolate.core.appearances.Appearance;
import com.paranoidkiwi.chocolate.core.bounds.BoundingBox;

public class Button extends UIComponent {

	private UIAction mainAction;

	// ****************************************************************
	// ** CONSTRUCTORS
	// ****************************************************************

	public Button(Appearance appearance, BoundingBox boundingBox, double x, double y, UIAction mainAction) {
		super(appearance, x, y);

		this.setBoundingBox(boundingBox);
		this.setMainAction(mainAction);
	}

	// ****************************************************************
	// ** OPERATIONS
	// ****************************************************************

	@Override
	public void performMainAction() {
		this.getMainAction().perform(this);
	}

	// ****************************************************************
	// ** ACCESSORS
	// ****************************************************************

	protected UIAction getMainAction() {
		return this.mainAction;
	}

	protected void setMainAction(UIAction mainAction) {
		this.mainAction = mainAction;
	}
}