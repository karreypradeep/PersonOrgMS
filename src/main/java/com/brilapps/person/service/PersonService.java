/**
 * This document is a part of the source code and related artifacts for
 * PersonOrgMS.
 * www.brilapps.com
 * Copyright © 2016 brilapps
 *
 */
package com.brilapps.person.service;

import java.util.List;

import com.brilapps.core.exceptions.BusinessException;
import com.brilapps.person.model.Person;

/**
 * class for PersonService
 *
 * @author pradeep created date 25-June-2015
 */
public interface PersonService {

    Person createPerson(final Person person) throws BusinessException;

    void deletePerson(final Long personId) throws BusinessException;

    List<Person> findByFirstNameOrLastNameOrMiddleName(final String firstName,final String lastName,final String middleName);

    Person getPersonById(final Long personId);

    Person updatePerson(final Person person) throws BusinessException;
}
