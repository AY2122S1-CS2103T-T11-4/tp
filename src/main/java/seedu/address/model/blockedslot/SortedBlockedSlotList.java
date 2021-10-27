package seedu.address.model.blockedslot;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import seedu.address.model.Overlappable;
import seedu.address.model.SortedOverlappableList;
import seedu.address.model.blockedslot.exceptions.BlockedSlotNotFoundException;

/**
 * A list of blocked slots is sorted chronologically and does not allow nulls.
 */
public class SortedBlockedSlotList implements SortedOverlappableList<BlockedSlot> {
    private class BlockedSlotSorter implements Comparator<BlockedSlot> {
        @Override
        public int compare(BlockedSlot o1, BlockedSlot o2) {
            return o1.compareTo(o2);
        }
    }

    private final ObservableList<BlockedSlot> internalList = FXCollections.observableArrayList();
    private final ObservableList<BlockedSlot> internalUnmodifiableList =
            new SortedList<>(FXCollections.unmodifiableObservableList(internalList),
                    new BlockedSlotSorter());

    @Override
    public void add(BlockedSlot toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    @Override
    public void remove(BlockedSlot toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new BlockedSlotNotFoundException();
        }
    }

    /**
     * Replaces the contents of this list with {@code blockSlots}.
     */
    public void setBlockedSlot(List<BlockedSlot> blockSlots) {
        requireAllNonNull(blockSlots);
        internalList.setAll(blockSlots);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortedBlockedSlotList // instanceof handles nulls
                && internalUnmodifiableList.equals(((SortedBlockedSlotList) other).internalUnmodifiableList));
    }

    @Override
    public ObservableList<BlockedSlot> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    /**
     * Checks if any Overlappable in the list overlaps with another Overlappable instance.
     * @param overlappable Overlappable to check.
     * @return True if overlaps, false otherwise.
     */
    @Override
    public boolean isOverlappingWith(Overlappable overlappable) {
        boolean hasNoOverlaps = true;
        for (Overlappable o : internalList) {
            if (o.isOverlappingWith(overlappable)) {
                hasNoOverlaps = false;
            }
        }

        return !hasNoOverlaps;
    }

    @Override
    public Iterator<BlockedSlot> iterator() {
        return internalUnmodifiableList.iterator();
    }
}