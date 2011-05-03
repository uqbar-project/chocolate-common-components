package com.paranoidkiwi.chocolate.utils.commoncomponents;

import com.paranoidkiwi.chocolate.core.appearances.VisualStrategy;
import com.paranoidkiwi.chocolate.core.bounds.BoundingBox;
import com.paranoidkiwi.chocolate.core.components.CollisionableComponent;
import com.paranoidkiwi.chocolate.core.reactions.annotations.OnMouseMoved;
import com.paranoidkiwi.chocolate.core.reactions.events.io.mouse.MouseMovedEvent;

public abstract class Cursor extends CollisionableComponent {

	// ****************************************************************
	// ** CONSTRUCTORS
	// ****************************************************************

	public Cursor(VisualStrategy visualStrategy, BoundingBox boundingBox, int collisionGroup) {
		super(boundingBox, collisionGroup);

		this.setVisualStrategy(visualStrategy);
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