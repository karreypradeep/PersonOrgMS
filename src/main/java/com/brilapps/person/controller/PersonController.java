/**
 * This document is a part of the source code and related artifacts for
 * Emilent.
 * www.brilapps.com
 * Copyright © 2015 brilapps
 *
 */
package com.brilapps.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brilapps.core.controller.AbstractBaseController;
import com.brilapps.person.service.PersonService;

/**
 * @author pradeep created date 30-Jan-2015
 */
@RestController
@RequestMapping("/persons")
public class PersonController extends AbstractBaseController {

    @Autowired
    PersonService personService;

    /* @RequestMapping(value = "/getPersonPicture", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getPersonPicture(@RequestBody final StudentSearchCriteria studentSearchCriteria,final HttpServletResponse response) throws BusinessException{
	byte[] documentBody = null;
	try {
	    final PersonPicture personPicture = personPictureService.findPersonPicture(studentSearchCriteria.getPersonId());
	    if((personPicture!=null) && (personPicture.getPersonPicture()!=null)) {
		documentBody = personPicture.getPersonPicture();
		response.setContentType("application/image");
		response.setContentLength(documentBody.length);
		try {
		    if(documentBody!=null) {
			response.getOutputStream().write(documentBody);
		    }
		} catch (final IOException e) {
		    throw new BusinessException(e.getMessage());
		}
		response.flushBuffer();
	    }else{
		throw new BusinessException("No Picture found.");
	    }
	} catch (final Exception e) {
	    throw new BusinessException(e.getMessage());
	}

    }

    @RequestMapping(value = "/personPictureUpload")
    public ResponseEntity<Void> uploadPersonPicture(@RequestParam("personId") final Long personId,
	    @RequestParam("file") final MultipartFile  file)
		    throws BusinessException {

	final Person person = personService.getPersonById(personId);

	if(person==null){
	    throw new BusinessException("Invalid Person Id passed.");
	}
	if(file==null){
	    throw new BusinessException("Please select File to import.");
	}

	try {
	    personPictureService.savePersonPicture(personId, file.getBytes());
	} catch (final IOException e) {
	    throw new BusinessException(e.getMessage());
	}
	return new ResponseEntity<Void>(HttpStatus.OK);
    }*/
}
