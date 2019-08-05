package com.boot.cache.springbootcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentDetailsController {
  private static final Logger LOG = LoggerFactory.getLogger(StudentDetailsController.class);

  @GetMapping(value = "/details")
  @Cacheable(value = "cacheStudentDetails")
  public ResponseEntity<List<StudentDetails>> getStudentDetails() {
    LOG.info("Trying to get the details from backend system");
    List<StudentDetails> listOfStudents = new ArrayList<>();
    listOfStudents.add(new StudentDetails(1, "ashish"));
    listOfStudents.add(new StudentDetails(2, "amit"));
    HttpHeaders headers = new HttpHeaders();
    headers.add("cached", "false");
    LOG.info("Returning response");
    return new ResponseEntity<List<StudentDetails>>(listOfStudents, headers, HttpStatus.OK);
    // return ResponseEntity.ok(listOfStudents);
  }
}
