package seedu.address.model.person;

import static seedu.address.model.person.PersonComparatorUtil.compareAddress;
import static seedu.address.model.person.PersonComparatorUtil.compareEmail;
import static seedu.address.model.person.PersonComparatorUtil.compareFavorite;
import static seedu.address.model.person.PersonComparatorUtil.compareLastAccessDate;
import static seedu.address.model.person.PersonComparatorUtil.compareName;
import static seedu.address.model.person.PersonComparatorUtil.comparePhone;

import java.util.Comparator;

//@@author marvinchin
/**
 * Default comparator for persons. Sorts first by name in alphabetical order, then by favorite
 * then by phone in numeric order, then by address in alphabetical order, then by email in alphabetical order
 */
public class PersonNameComparator implements Comparator<ReadOnlyPerson> {
    @Override
    public int compare(ReadOnlyPerson thisPerson, ReadOnlyPerson otherPerson) {
        if (!thisPerson.getName().equals(otherPerson.getName())) {
            return compareName(thisPerson, otherPerson);
        } else if (!thisPerson.getFavorite().equals(otherPerson.getFavorite())) {
            return compareFavorite(thisPerson, otherPerson);
        } else if (!thisPerson.getPhone().equals(otherPerson.getPhone())) {
            return comparePhone(thisPerson, otherPerson);
        } else if (!thisPerson.getAddress().equals(otherPerson.getAddress())) {
            return compareAddress(thisPerson, otherPerson);
        } else if (!thisPerson.getEmail().equals(otherPerson.getEmail())) {
            return compareEmail(thisPerson, otherPerson);
        } else {
            return compareLastAccessDate(thisPerson, otherPerson);
        }
    }
}

