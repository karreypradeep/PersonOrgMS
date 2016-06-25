/**
 * This document is a part of the source code and related artifacts for
 * PersonOrgMS.
 * www.brilapps.com
 * Copyright © 2016 brilapps
 *
 */
package com.brilapps.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brilapps.person.model.Person;

/**
 * class for PersonRepository
 *
 * @author pradeep created date 25-June-2015
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByFirstNameLikeOrLastNameLikeOrMiddleNameLike(final String firstName,final String lastName,final String middleName);
}
