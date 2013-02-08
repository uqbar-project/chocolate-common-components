package com.paranoidkiwi.chocolate.utils.commoncomponents.ui

import com.paranoidkiwi.chocolate.core.appearances.Appearance
import com.paranoidkiwi.chocolate.core.collisions.BoundingBox
import com.paranoidkiwi.chocolate.core.dimensions.Position

class Button(position: Position, appearance: Appearance, mainAction: UIAction)
  extends UIComponent(position: Position, appearance: Appearance) {

  // ****************************************************************
  // ** OPERATIONS
  // ****************************************************************

  override def performMainAction = mainAction perform this
}