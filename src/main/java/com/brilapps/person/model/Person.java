/**
 * This document is a part of the source code and related artifacts for
 * PersonOrgMS.
 * www.brilapps.com
 * Copyright © 2016 brilapps
 *
 */
package com.brilapps.person.model;

/**
 * class for user
 *
 * @author pradeep created date 25-June-2015
 */
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;

import com.brilapps.constants.GenderConstant;
import com.brilapps.core.model.BaseEntity;

@Entity
@Table(name = "PERSON")
public class Person extends BaseEntity implements Serializable {

	/**
	 * Universal serial version id for this class
	 */
	private static final long serialVersionUID = 2772936954271883242L;

	@NotEmpty(message = "First name is mandatory.")
	@Column(name = "FIRST_NAME", nullable = false)
	private String				firstName;

	@NotEmpty(message = "Last name is mandatory.")
	@Column(name = "LAST_NAME", nullable = false)
	private String				lastName;

	@Column(name = "MIDDLE_NAME")
	private String				middleName;

	@NotNull(message = "Gender is mandatory.")
	@Basic
	@Column(name = "GENDER", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private GenderConstant		gender;

	@Column(name = "NATIONALITY", length = 50)
	private String					nationality;

	@Column(name = "RELIGION", length = 50)
	private String					religion;

	@Column(name = "MOTHER_TONGUE", length = 50)
	private String					motherTongue;

	@Temporal(TemporalType.DATE)
	@Past(message = "Please specify a valid birth date(Hint: Past date).")
	@Column(name = "DATE_OF_BIRTH")
	private Date					dateOfBirth;

	@Column(name = "BIRTH_COUNTRY", length = 200)
	private String					countryOfBirth;

	@Column(name = "RESERVATION", length = 50)
	private String					reservation;

	/**
	 * @return the countryOfBirth
	 */
	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getDisplayName() {
		if (StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
			return "";
		} else if (StringUtils.isEmpty(middleName)) {
			return firstName + " " + lastName;
		} else {
			return firstName + " " + middleName + " " + lastName;

		}
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the gender
	 */
	public GenderConstant getGender() {
		return gender;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return the motherTongue
	 */
	public String getMotherTongue() {
		return motherTongue;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @return the reservation
	 */
	public String getReservation() {
		return reservation;
	}

	/**
	 * @param countryOfBirth the countryOfBirth to set
	 */
	public void setCountryOfBirth(final String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(final Date dateofBirth) {
		Calendar theDateOfBirth = null;
		if (dateofBirth != null) {
			theDateOfBirth = Calendar.getInstance();
			theDateOfBirth.setTime(dateofBirth);
			final Date toDay = new Date(System.currentTimeMillis());

			if (theDateOfBirth.after(toDay)) {
				// TODO throw exception
			}
			dateOfBirth = theDateOfBirth.getTime();
		}

	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(final GenderConstant gender) {
		this.gender = gender;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @param motherTongue the motherTongue to set
	 */
	public void setMotherTongue(final String motherTongue) {
		this.motherTongue = motherTongue;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(final String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @param religion the religion to set
	 */
	public void setReligion(final String religion) {
		this.religion = religion;
	}

	/**
	 * @param reservation the reservation to set
	 */
	public void setReservation(final String reservation) {
		this.reservation = reservation;
	}
}
