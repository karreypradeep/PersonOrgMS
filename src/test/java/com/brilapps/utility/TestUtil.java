/**
 * This document is a part of the source code and related artifacts for
 * Emilent.
 * www.brilapps.com
 * Copyright © 2015 brilapps
 *
 */
package com.brilapps.utility;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.MediaType;

import com.brilapps.constants.GenderConstant;
import com.brilapps.person.model.Person;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author pradeep created date 27-Jan-2015
 */
public class TestUtil {



    public static Date DATE_MARCH_31_2015;
    public static Date DATE_APRIL_01_2014;
    public static Date DATE_MARCH_31_2016;
    public static Date DATE_APRIL_01_2015;
    static {
	try {
	    DATE_MARCH_31_2015 = new SimpleDateFormat("dd/MM/yyyy")
		    .parse(TestConstants.MARCH_31_2015);
	    DATE_APRIL_01_2014 = new SimpleDateFormat("dd/MM/yyyy")
		    .parse(TestConstants.APRIL_01_2014);
	    DATE_MARCH_31_2016 = new SimpleDateFormat("dd/MM/yyyy")
		    .parse(TestConstants.MARCH_31_2016);
	    DATE_APRIL_01_2015 = new SimpleDateFormat("dd/MM/yyyy")
		    .parse(TestConstants.APRIL_01_2015);
	} catch (final Exception e) {

	}
    }

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));


    public static byte[] convertObjectToJsonBytes(final Object object) throws IOException {
	final ObjectMapper mapper = new ObjectMapper();
	mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	return mapper.writeValueAsBytes(object);
    }


    public static Person createPerson() {
	final Person person = new Person();
	person.setFirstName("Person First Name");
	person.setLastName("Person Last Name");
	person.setMiddleName("Person Middle Name");
	person.setGender(GenderConstant.MALE);
	person.setDateOfBirth(DATE_APRIL_01_2015);
	person.setNationality("Indian");
	person.setCreatedUser("anonymous");
	person.setLastUpdatedUser("anonymous");
	person.setCountryOfBirth("IND");
	return person;
    }



}
