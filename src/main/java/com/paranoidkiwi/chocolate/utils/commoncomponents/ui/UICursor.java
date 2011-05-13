package com.paranoidkiwi.chocolate.utils.commoncomponents.ui;

import com.paranoidkiwi.chocolate.core.appearances.Appearance;
import com.paranoidkiwi.chocolate.core.collisions.BoundingBox;
import com.paranoidkiwi.chocolate.core.components.CollisionableComponent;
import com.paranoidkiwi.chocolate.core.reactions.annotations.OnMousePressed;
import com.paranoidkiwi.chocolate.core.reactions.enums.MouseButton;
import com.paranoidkiwi.chocolate.core.reactions.events.CustomEvent;
import com.paranoidkiwi.chocolate.utils.commoncomponents.Cursor;

public class UICursor extends Cursor {

	public static final int UI_CURSOR_CG = 7773;

	// ****************************************************************
	// ** CONSTRUCTORS
	// ****************************************************************

	public UICursor(Appearance appearance, BoundingBox boundingBox) {
		super(appearance, boundingBox, UI_CURSOR_CG);
	}

	// ****************************************************************
	// ** TRIGGERS
	// ****************************************************************

	@OnMousePressed(button = MouseButton.LEFT)
	public void requireMainAction() {
		CollisionableComponent componentUnder = this.getAffectedComponent();

		if (componentUnder != null) {
			componentUnder.reactTo(new CustomEvent(UIComponent.MAIN_ACTION));
		}
	}

	// ****************************************************************
	// ** QUERIES
	// ****************************************************************

	protected CollisionableComponent getAffectedComponent() {
		CollisionableComponent answer = null;

		for (CollisionableComponent component : this.getCollidingComponents()) {
			answer = answer == null || answer.getZ() < component.getZ() ? component : answer;
		}

		return answer;
	}
}