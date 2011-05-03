package com.paranoidkiwi.chocolate.utils.commoncomponents.ui;

import com.paranoidkiwi.chocolate.core.appearances.VisualStrategy;
import com.paranoidkiwi.chocolate.core.bounds.BoundingBox;

public class Button extends UIComponent {

	private UIAction mainAction;

	// ****************************************************************
	// ** CONSTRUCTORS
	// ****************************************************************

	public Button(VisualStrategy visualStrategy, BoundingBox boundingBox, double x, double y, UIAction mainAction) {
		super(visualStrategy, x, y);

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