package org.examples.service;

import org.examples.model.Library1;
import org.examples.model.Library2;
import org.examples.model.Person;

public interface BorrowerService {
    void borrowBookWithPriority(String bookName, Person person, Library1 library1);
    void borrowWithoutPriority(String bookName, Person person, Library2 library2);

}
