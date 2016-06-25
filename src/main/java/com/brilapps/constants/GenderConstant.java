/**
 * This document is a part of the source code and related artifacts for
 * PersonOrgMS.
 * www.brilapps.com
 * Copyright © 2016 brilapps
 *
 */
package com.brilapps.constants;

import com.brilapps.core.constants.Labeled;

/**
 * Enums for Gender constants
 *
 * @author pradeep created date 25-June-2015
 */

public enum GenderConstant implements Labeled {

	MALE("male"), FEMALE("female"), OTHER("other");

	private String	label;

	GenderConstant(final String label) {
		this.setLabel(label);
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(final String label) {
		this.label = label;
	}

}
