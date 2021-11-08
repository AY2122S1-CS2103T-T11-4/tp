package seedu.address.model.util;

import org.junit.jupiter.api.Test;
import seedu.address.model.ReadOnlySchedule;
import seedu.address.model.Schedule;
import seedu.address.model.event.Date;
import seedu.address.model.event.Event;
import seedu.address.model.event.Location;
import seedu.address.model.event.Name;
import seedu.address.model.event.Remark;
import seedu.address.model.event.TimeSlot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.model.util.SampleDataUtil.getTagSet;

public class SampleDataUtilTest {

    Event[] expectedEventArr = new Event[] {
            new Event(new Name("Jacob NG"), new Date("2022-10-13"), new TimeSlot("1300", "1400"),
                    new Location("The Deck"),
                    getTagSet("CS1231S", "URGENT"), new Remark("Cool student")),
            new Event(new Name("Ruth Poh"), new Date("2022-10-15"), new TimeSlot("1600", "1700"),
                    new Location("Central Library"),
                    getTagSet("supplementary"), new Remark("Coool student")),
            new Event(new Name("Teng Foong"), new Date("2022-10-18"), new TimeSlot("1000", "1100"),
                    new Location("COM1 Basement"),
                    getTagSet("CS1231S"), new Remark("Cooool student")),
            new Event(new Name("Galvin C"), new Date("2022-10-19"), new TimeSlot("1400", "1500"),
                    new Location("Office"),
                    getTagSet("CS2100"), new Remark("Student. Very cool.")),
            new Event(new Name("Lulu"), new Date("2022-10-20"), new TimeSlot("1400", "1500"),
                    new Location("Office"),
                    getTagSet("supplementary"), new Remark(""))
    };

    @Test
    public void getSampleEvents() {
        Event[] actualEventArr = SampleDataUtil.getSampleEvents();

        for(int i = 0; i < expectedEventArr.length; i++) {
            assertEquals(expectedEventArr[i], actualEventArr[i]);
        }
    }

    @Test
    public void getSampleSchedule() {
        Schedule expectedSc = new Schedule();
        for (Event expectedSampleEvent : expectedEventArr) {
            expectedSc.addEvent(expectedSampleEvent);
        }
        Schedule actualSc = (Schedule) SampleDataUtil.getSampleSchedule();
        assertEquals(expectedSc, actualSc);
    }
}