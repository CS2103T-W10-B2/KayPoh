package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FAV;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SOCIAL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.AddCommand;
import seedu.address.model.person.ReadOnlyPerson;

/**
 * A utility class for Person.
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code person}.
     */
    public static String getAddCommand(ReadOnlyPerson person) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(person);
    }

    /**
     *
     *
     * Returns an add command string using the command alias for adding the {@code person}.
     */
    public static String getAddCommandAlias(ReadOnlyPerson person) {
        return AddCommand.COMMAND_ALIAS + " " + getPersonDetails(person);
    }

    /**
     * Returns the part of command string for the given {@code person}'s details.
     */
    public static String getPersonDetails(ReadOnlyPerson person) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + person.getName().fullName + " ");
        sb.append(PREFIX_PHONE + person.getPhone().value + " ");
        sb.append(PREFIX_EMAIL + person.getEmail().value + " ");
        sb.append(PREFIX_ADDRESS + person.getAddress().value + " ");
        if (person.getFavorite().isFavorite()) {
            sb.append(PREFIX_FAV + " ");
        }
        person.getTags().stream().forEach(
            s -> sb.append(PREFIX_TAG + s.tagName + " ")
        );
        person.getSocialInfos().stream().forEach(
            s -> sb.append(PREFIX_SOCIAL + s.getSocialType() + " " + s.getUsername())
        );
        return sb.toString();
    }
}
