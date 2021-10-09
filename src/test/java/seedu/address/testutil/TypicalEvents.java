package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Event;

/**
 * A utility class containing a list of {@code Event} objects to be used in tests.
 */
public class TypicalEvents {

    public static final Event ALICE = new EventBuilder().withName("Alice Pauline")
            .withLocation("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withTags("friends").build();
    public static final Event BENSON = new EventBuilder().withName("Benson Meier")
            .withLocation("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends").build();
    public static final Event CARL = new EventBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withLocation("wall street").build();
    public static final Event DANIEL = new EventBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withLocation("10th street").withTags("friends").build();
    public static final Event ELLE = new EventBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withLocation("michegan ave").build();
    public static final Event FIONA = new EventBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withLocation("little tokyo").build();
    public static final Event GEORGE = new EventBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withLocation("4th street").build();

    // Manually added
    public static final Event HOON = new EventBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withLocation("little india").build();
    public static final Event IDA = new EventBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withLocation("chicago ave").build();

    // Manually added - Event's details found in {@code CommandTestUtil}
    public static final Event AMY = new EventBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withLocation(VALID_LOCATION_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Event BOB = new EventBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withLocation(VALID_LOCATION_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalEvents() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical events.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Event event : getTypicalEvents()) {
            ab.addEvent(event);
        }
        return ab;
    }

    public static List<Event> getTypicalEvents() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
