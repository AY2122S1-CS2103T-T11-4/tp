package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.exceptions.SlotBlockedException;
import seedu.address.model.event.BlockedSlot;
import seedu.address.model.event.Date;
import seedu.address.model.event.Event;
import seedu.address.model.event.Overlappable;
import seedu.address.model.event.SortedBlockedSlotList;
import seedu.address.model.event.SortedEventList;
import seedu.address.model.event.TimeSlot;
import seedu.address.model.util.SampleDataUtil;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameEvent comparison)
 */
public class Schedule implements ReadOnlySchedule {

    private final Logger logger = LogsCenter.getLogger(Schedule.class);

    private final SortedEventList events;
    private final SortedBlockedSlotList blockedSlotList;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        events = new SortedEventList();
        blockedSlotList = new SortedBlockedSlotList();
    }

    public Schedule() {
        //TODO delete later. this is just to populate blockedSLotList with some data
        blockedSlotList.add(new BlockedSlot(new Date("2020-10-13"), new TimeSlot("0000", "0700")));
        blockedSlotList.add(new BlockedSlot(new Date("2020-10-13"), new TimeSlot("1900", "2359")));
        blockedSlotList.add(new BlockedSlot(new Date("2020-10-15"), new TimeSlot("0000", "0700")));
        blockedSlotList.add(new BlockedSlot(new Date("2020-10-15"), new TimeSlot("1900", "2359")));
        blockedSlotList.add(new BlockedSlot(new Date("2020-10-18"), new TimeSlot("0000", "0700")));
        blockedSlotList.add(new BlockedSlot(new Date("2020-10-18"), new TimeSlot("1900", "2359")));
        blockedSlotList.add(new BlockedSlot(new Date("2020-10-19"), new TimeSlot("0000", "0700")));
        blockedSlotList.add(new BlockedSlot(new Date("2020-10-19"), new TimeSlot("1900", "2359")));
    }

    /**
     * Creates a Schedule using the Events in the {@code toBeCopied}
     */
    public Schedule(ReadOnlySchedule toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the event list with {@code events}.
     * {@code events} must not contain duplicate events.
     */
    public void setEvents(List<Event> events) {
        this.events.setEvent(events);
    }

    /**
     * Resets the existing data of this {@code Schedule} with {@code newData}.
     */
    public void resetData(ReadOnlySchedule newData) {
        requireNonNull(newData);

        setEvents(newData.getEventList());
    }

    //// event-level operations

    /**
     * Adds an event to the address book.
     * The event must not already exist in the address book.
     */
    public void addEvent(Event e) {
        if (isBlocked(e)) {
            logger.info(BlockedSlot.TIMESLOT_BLOCKED);
            //throw new SlotBlockedException(BlockedSlot.TIMESLOT_BLOCKED);
        }
        events.add(e);
    }

    /**
     * Replaces the given event {@code target} in the list with {@code editedEvent}.
     * {@code target} must exist in the address book.
     * The event identity of {@code editedEvent} must not be the same as another existing event in the address book.
     */
    public void setEvent(Event target, Event editedEvent) {
        requireNonNull(editedEvent);

        events.setEvent(target, editedEvent);
    }

    /**
     * Removes {@code key} from this {@code Schedule}.
     * {@code key} must exist in the address book.
     */
    public void removeEvent(Event key) {
        events.remove(key);
    }

    /**
     * Adds a block with the given BlockedSlot.
     * @param blockedSlot BlockedSlot to be added.
     */
    public void addBlock(BlockedSlot blockedSlot) throws SlotBlockedException {
        //TODO: instead of throwing error, merge with other blocked periods
        if (isBlocked(blockedSlot)) {
            throw new SlotBlockedException(BlockedSlot.TIMESLOT_BLOCKED);
        }
        blockedSlotList.add(blockedSlot);
    }

    /**
     * Checks if the given Overlappable is blocked.
     * @param overlappable the Overlappable to be checked.
     * @return true if the Overlappable is blocked, false otherwise.
     */
    public boolean isBlocked(Overlappable overlappable) {
        return blockedSlotList.isOverlappingWith(overlappable);
    }

    //// util methods

    @Override
    public String toString() {
        return events.asUnmodifiableObservableList().size() + " events";
        // TODO: refine later
    }

    @Override
    public ObservableList<Event> getEventList() {
        return events.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Schedule // instanceof handles nulls
                && events.equals(((Schedule) other).events));
    }

    @Override
    public int hashCode() {
        return events.hashCode();
    }

    private class OverlappableComparator implements Comparator<Overlappable> {

        @Override
        public int compare(Overlappable o1, Overlappable o2) {
            int compareDate = o1.getDate().compareTo(o2.getDate());
            if (compareDate != 0) {
                return compareDate;
            } else {
                return o1.getTimeSlot().compareTo(o2.getTimeSlot());
            }
        }
    }

    private ArrayList<Overlappable> merge() {
        Iterator<Event> eventsIterator = events.iterator();
        Iterator<BlockedSlot> blockedIterator = blockedSlotList.iterator();
        ArrayList<Overlappable> allOverlappables = new ArrayList<>();
        eventsIterator.forEachRemaining(e -> allOverlappables.add(e));
        blockedIterator.forEachRemaining(b -> allOverlappables.add(b));
        allOverlappables.sort(new OverlappableComparator());
        return allOverlappables;
    }

    public ArrayList<FreeSlot> getFreeSlots() {
        ArrayList<Overlappable> allOverlappables = merge();
        ArrayList<FreeSlot> freeSlots = new ArrayList<>();
        for (int i = 1; i < allOverlappables.size(); i++) {
            Overlappable prev = allOverlappables.get(i - 1);
            Overlappable curr = allOverlappables.get(i);
            String prevEndTime = prev.getTimeSlot().endTimeToString();
            String currStartTime = curr.getTimeSlot().startTimeToString();

            if (prev.getDate().equals(curr.getDate())) {
                if (!prevEndTime.equals(currStartTime)) {
                    freeSlots.add(new FreeSlot(prev.getDate(), new TimeSlot(prevEndTime, currStartTime)));
                }
            } else {
                if (!prevEndTime.equals("2359")) {
                    freeSlots.add(new FreeSlot(prev.getDate(), new TimeSlot(prevEndTime, "2359")));
                }
                if (!currStartTime.equals("0000")) {
                    freeSlots.add(new FreeSlot(curr.getDate(), new TimeSlot("0000", currStartTime)));
                }

            }
        }
        return freeSlots;
    }

}
