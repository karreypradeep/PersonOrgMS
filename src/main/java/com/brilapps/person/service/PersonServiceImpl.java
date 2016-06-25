/**
 * This document is a part of the source code and related artifacts for
 * PersonOrgMS.
 * www.brilapps.com
 * Copyright © 2016 brilapps
 *
 */
package com.brilapps.person.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brilapps.core.exceptions.ApplicationException;
import com.brilapps.core.exceptions.BusinessException;
import com.brilapps.person.model.Person;
import com.brilapps.person.repository.PersonRepository;


/**
 * class for PersonService
 *
 * @author pradeep created date 25-June-2015
 */
@Service
@Transactional(rollbackFor = { Exception.class, RuntimeException.class, BusinessException.class,
	ApplicationException.class })
@PreAuthorize("hasAuthority('EXCLUDE_ALL')")
public class PersonServiceImpl implements PersonService {

    public static void validatePerson(final Person person) throws BusinessException {

	if ((person.getFirstName() == null) || (person.getFirstName().trim().length() == 0)) {
	    throw new BusinessException("Person First Name is Mandatory.");
	}
	if ((person.getLastName() == null) || (person.getLastName().trim().length() == 0)) {
	    throw new BusinessException("Person Last Name is Mandatory.");
	}
	if (person.getDateOfBirth() == null) {
	    throw new BusinessException("Please enter person Date of Birth.");
	} else if (!person.getDateOfBirth().before(new Date())) {
	    throw new BusinessException("Please enter valid person Date of Birth.");
	}

	if (person.getGender() == null) {
	    throw new BusinessException("Please enter Gender of person.");
	}

	/*
	 * if ((person.getAddresses() == null) ||
	 * person.getAddresses().isEmpty()) { throw new BusinessException(
	 * "Please enter Address of Person."); }
	 *
	 * if (person.getContactInfo() == null) { throw new BusinessException(
	 * "Please enter Contact Information of Person."); }
	 */

	if (person.getCountryOfBirth() == null) {
	    throw new BusinessException("Please enter Birth Contry of Person.");
	}

    }

    @Autowired
    private PersonRepository personRepository;

    @Override
    @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN')  or ((hasAuthority('ACC_TYPE_ADMIN') or hasAuthority('ACC_TYPE_EMPLOYEE')) and (hasAuthority('CREATE_PERSON') ))")
    public Person createPerson(final Person person) throws BusinessException {
	PersonServiceImpl.validatePerson(person);
	/*
	 * for (final Address address : person.getAddresses()) {
	 * address.setPerson(person);
	 * address.setAddressType(AddressTypeConstant.PERSON); } if
	 * (person.getContactInfo() != null) {
	 * person.getContactInfo().setPerson(person);
	 * person.getContactInfo().setContactTypeConstant(
	 * ContactTypeConstant.PERSON); }
	 */
	final Person newPerson = personRepository.save(person);
	return newPerson;
    }

    @Override
    @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN')  or ((hasAuthority('ACC_TYPE_ADMIN') or hasAuthority('ACC_TYPE_EMPLOYEE')) and (hasAuthority('DELETE_PERSON')))")
    public void deletePerson(final Long personId) throws BusinessException {
	personRepository.delete(personId);
    }

    @Override
    @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN')  or ((hasAuthority('ACC_TYPE_ADMIN') or hasAuthority('ACC_TYPE_EMPLOYEE')) and (hasAuthority('ACCESS_PERSON')))")
    public List<Person> findByFirstNameOrLastNameOrMiddleName(final String firstName, final String lastName, final String middleName) {
	return personRepository.findByFirstNameLikeOrLastNameLikeOrMiddleNameLike(firstName, lastName, middleName);
    }

    @Override
    @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN')  or ((hasAuthority('ACC_TYPE_ADMIN') or hasAuthority('ACC_TYPE_EMPLOYEE')) and (hasAuthority('ACCESS_PERSON')))")
    public Person getPersonById(final Long personId) {
	final Person person = personRepository.findOne(personId);
	return person;
    }

    @Override
    @PreAuthorize("hasAuthority('ACC_TYPE_ADMIN') or hasAuthority('ACC_TYPE_SUPER_ADMIN') or hasAuthority('UPDATE_PERSON')")
    public Person updatePerson(final Person person) throws BusinessException {
	final Person updatedPerson = personRepository.save(person);
	return updatedPerson;
    }

}
