package seedu.address.testutil;

import seedu.address.model.Schedule;
import seedu.address.model.person.Person;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code Schedule ab = new ScheduleBuilder().withPerson("John", "Doe").build();}
 */
public class ScheduleBuilder {

    private Schedule schedule;

    public ScheduleBuilder() {
        schedule = new Schedule();
    }

    public ScheduleBuilder(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * Adds a new {@code Person} to the {@code Schedule} that we are building.
     */
    public ScheduleBuilder withPerson(Person person) {
        schedule.addPerson(person);
        return this;
    }

    public Schedule build() {
        return schedule;
    }
}