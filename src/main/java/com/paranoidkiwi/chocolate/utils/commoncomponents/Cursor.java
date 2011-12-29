package com.paranoidkiwi.chocolate.utils.commoncomponents;

import com.paranoidkiwi.chocolate.core.appearances.Appearance;
import com.paranoidkiwi.chocolate.core.collisions.BoundingBox;
import com.paranoidkiwi.chocolate.core.components.CollisionableComponent;
import com.paranoidkiwi.chocolate.core.reactions.annotations.io.mouse.OnMouseMoved;
import com.paranoidkiwi.chocolate.core.reactions.events.io.mouse.MouseMovedEvent;

public abstract class Cursor extends CollisionableComponent {

	// ****************************************************************
	// ** CONSTRUCTORS
	// ****************************************************************

	public Cursor(Appearance appearance, BoundingBox boundingBox, int collisionGroup) {
		super(boundingBox, collisionGroup);

		this.setAppearance(appearance);
		this.setZ(Integer.MAX_VALUE);
	}

	// ****************************************************************
	// ** TRIGGERS
	// ****************************************************************

	@OnMouseMoved
	public void updatePosition(MouseMovedEvent e) {
		this.setPosition(e.getPosition());
	}
}