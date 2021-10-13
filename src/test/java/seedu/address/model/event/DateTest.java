package seedu.address.model.event;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Date(null));
    }

    @Test
    public void constructor_invalidDate_throwsIllegalArgumentException() {
        String invalidDate = "";
        assertThrows(IllegalArgumentException.class, () -> new Date(invalidDate));
    }

    @Test
    public void isValidDate() {
        // null date number
        assertThrows(NullPointerException.class, () -> Date.isValidDate(null));

        // invalid date numbers
        assertFalse(Date.isValidDate("")); // empty string
        assertFalse(Date.isValidDate(" ")); // spaces only
        assertFalse(Date.isValidDate("2020-01")); // only yyyy-mm
        assertFalse(Date.isValidDate("date")); // non-numeric
        assertFalse(Date.isValidDate("2020a-01-01")); // alphabets within digits
        assertFalse(Date.isValidDate("2020 01 01")); // spaces instead of hyphens

        // valid date numbers
        assertTrue(Date.isValidDate("2020-01-01"));
        assertTrue(Date.isValidDate("2024-02-29")); // leap year
    }
}
