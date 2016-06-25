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
 * Enums for relation type constants
 *
 * @author pradeep created date 25-June-2015
 */
public enum RelationTypeConstant implements Labeled {

	FATHER("father"), MOTHER("mother"), GUARDIAN("guardian");

	private String	label;

	RelationTypeConstant(final String label) {
		this.label = label;
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
