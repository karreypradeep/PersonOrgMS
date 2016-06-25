/**
 * This document is a part of the source code and related artifacts for
 * CPersonOrgMS.
 * www.brilapps.com
 * Copyright © 2016 brilapps
 *
 */
package com.brilapps.person;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.brilapps.PersonOrgMsApplication;
import com.brilapps.person.model.Person;
import com.brilapps.person.repository.PersonRepository;
import com.brilapps.utility.TestUtil;

/**
 * @author pradeep created date 25-June-2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PersonOrgMsApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testCreatePerson() {
	final Person personBeforeSaving = TestUtil.createPerson();
	final Person person = personRepository
		.save(personBeforeSaving);
	Assert.assertNotNull(person);
	Assert.assertTrue("Incorrect Person Name Retrieved.",
		personBeforeSaving.getFirstName().equals(person.getFirstName()));
    }

    @Test
    @Transactional
    public void testDeletePerson() {
	final Person person = personRepository
		.save(TestUtil.createPerson());
	Person result = personRepository
		.findOne(person.getId());
	Assert.assertNotNull(result);
	personRepository.delete(result.getId());
	result = null;
	try{
	    result = personRepository
		    .findOne(person.getId());
	}catch(final Exception e){
	}
	Assert.assertNull(result);
    }

    @Test
    @Transactional
    public void testGetAllPerson() {
	final List<Person> existingPersons = personRepository
		.findAll();
	Assert.assertNotNull(personRepository.save(TestUtil
		.createPerson()));
	final List<Person> persons = personRepository
		.findAll();
	final int compareSize = existingPersons.size()+3;
	Assert.assertTrue("Incorrect Persons retrieved expected " + (existingPersons.size()+3) + " but retrieved " + persons.size(),
		compareSize == persons.size());
    }

    @Test
    @Transactional
    public void testGetPersonById() {
	final Person personBeforeSaving = TestUtil.createPerson();
	final Person person = personRepository
		.save(personBeforeSaving);
	Assert.assertTrue("Incorrect Person Name Retrieved.",
		personBeforeSaving.getFirstName().equals(person.getFirstName()));

	final Person result = personRepository
		.findOne(person.getId());
	Assert.assertNotNull(result);
	Assert.assertTrue("Wrong person retrieved.", person
		.getId().equals(result.getId()));
	Assert.assertTrue("Incorrect Person Name Retrieved.",
		result.getFirstName().equals(person.getFirstName()));

    }

    @Test
    @Transactional
    public void testUpdatePerson() {
	final Person person = personRepository
		.save(TestUtil.createPerson());
	Person result = personRepository
		.findOne(person.getId());
	result.setFirstName("Updated First Name");
	result = personRepository
		.findOne(person.getId());
	Assert.assertTrue("Person update failed." ,
		result.getFirstName().endsWith("Updated First Name"));
    }

}
