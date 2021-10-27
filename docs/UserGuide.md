---
layout: page
title: User Guide
---

## Table of Contents
***

* TOC
{:toc}

## 1. Introduction
***

DukePro(f) is an application that assists **professors in the University** in planning for their weekly engagements.
Amidst long hours of lectures and tutorials in the week, professors may still need to cater timeslots for **student
consultations**, which can be hard to come by and difficult to keep track of.

It is named `DukePro(f)` (Duke-Professor) because our project's target audience is professors in a University, and it is also a nod
to our CS2103T iP (individual Project), which was named `Duke`.

## 2. Purpose
***

This document is the User Guide for DukePro(f). It is intended to provide all the necessary information to use this software.
The manual assumes that the user has the ability to type fast and prefers typing over other means of input.
This User Guide contains the following sections:
1. Command Summary (TODO HYPERLINKS)
2. Quick Start
3. Features
4. FAQ

## 3. Command Summary
***

Action | Format | Examples
--------|-------|-------
**[Add](#51-adding-a-consultation-event--add)** | `add n/NAME d/DATE t/TIMESLOT l/LOCATION [tag/TAG]... [r/REMARK]` | `add n/Lulu Yousef d/2020-01-01 t/0800-0900 l/NUS tag/Important tag/Supplementary`
**[Clear](#52-clearing-all-consultation-events--clear)** | `clear`  | -
**[Delete](#53-deleting-a-consultation-event--delete)** | `delete INDEX` | `delete 3`
**[Edit](#54-editing-a-consultation-event--edit)** | `edit INDEX [n/NAME] [d/DATE] [t/TIMESLOT] [l/LOCATION] [tag/TAG]... [r/REMARK]`  | `edit 2 n/Quan Teng Foong` <br> `edit 6 tag/Zoom Meeting`
**[Find](#55-finding-a-consultation-event--find)** | `find KEYWORD`  | `find Teng Foong`
**[List Free Slots](#55-listing-all-free-slots--free_slots)** | `free_slots` | -
**[Help](#56-viewing-help--help)** | `help` | -
**[List](#57-listing-all-consultation-events--list)** | `list` | -
**[Display Next Event](#58-displaying-the-next-consultation-event--next_event)** | `next_event` | -
**[List Upcoming Events](#59-listing-all-upcoming-events--upcoming_events)** | `upcoming_events` | -
**[View Command Summary Page](#510-viweing-the-command-summary-page--command_summary)** | `command_summary` | -
**[Exit](#511-exiting-the-app--exit)** | `exit` | -


## 4. Quick Start
***
1. Ensure you have Java `11` or above installed in your Computer. 
<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
   Not sure how? Click [here](https://www.oracle.com/java/technologies/downloads/)!
</div>

2. Download the latest `dukeprof.jar` from [here](https://github.com/AY2122S1-CS2103T-T11-4/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your DukePro(f).

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. 
   Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)
   <!-- will need to change Ui.png once GUI is updated.-->

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing 
   Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all consultation events.

   * **`add`**`add n/Galvin Chan d/2020-07-07 t/1000-1100 l/NUS tag/Tutorial 4` : Adds a consultation event for `Galvin Chan` to DukePro(f).

   * **`delete`**`3` : Deletes the 3rd event shown in DukePro(f)'s current event list.
    

6. Refer to the [Features](#3-features) below for details of each command.


## 5. Features
***
<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  * e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/Lulu Yousef`.

* Items in square brackets are optional. (Items not in square brackets are necessary!)
  * e.g. `[tag/TAG]` is an optional parameter.

* Parameters that can have more than one entry will be anteceded by a `...`
  * e.g. `[tag/TAG]...` can have more than one entry, so `tag/supplmentary tag/important` is accepted.

* Parameters can be in any order.<br>
  * e.g. if the command specifies `n/NAME d/DATE`, `d/DATE n/NAME` is also acceptable.

* If a parameter is expected only once in the command, but you have specified it multiple times, only the 
  last occurrence of the parameter will be taken.<br>
  * e.g. if you specify `t/0100 t/2359`, only `t/2359` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `list` and `exit`) will be 
  ignored.<br>
  * e.g. if the command specifies `list 123`, it will be interpreted as `list`.

</div>

### 5.1 Adding a Consultation Event : `add`

Adds a consultation event to Dukepro(f).

Format: `add n/NAME d/DATE t/TIMESLOT l/LOCATION [tag/TAG]... [r/REMARK]`
* tags with the text "URGENT" and "supplementary" will automatically be changed to red and yellow respectively to 
enable the user to indicate the consultation's severity

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
An event can have any number of tags (including 0).
</div>

Example(s):
* `add n/Lulu Yousef d/2020-01-01 t/0800-0900 l/NUS tag/Important tag/supplementary`
* `add n/Ruth Poh d/2020-02-02 t/1000-1100 l/The Deck r/May have to switch to zoom`
* `tag/URGENT` will be shown as ![urgent tag](images/URGENT tag.png) 
* `tag/supplementary` will be shown as ![supplementary tag](images/supplementary tag.png)

### 5.2 Clearing all Consultation Events : `clear`

Clears all consultation events stored in DukePro(f).

<div markdown="span" class="alert alert-danger">:warning: **WARNING**: This command cannot be reversed. Be 
careful when using this command!
</div>

Format: `clear`


### 5.3 Deleting a Consultation Event : `delete`

Deletes a consultation event from DukePro(f) at the specified `INDEX`.

Format: `delete INDEX`

Example(s): 
* `delete 1`

### 5.4 Editing a Consultation Event : `edit`

Edits the details of a consultation event from DukePro(f) at the specified `INDEX`.

Format: `edit INDEX [n/NAME] [d/DATE] [t/TIMESLOT] [l/LOCATION] [tag/TAG]... [r/REMARK]`

<div markdown="span" class="alert alert-danger">:bulb: **Tip**: Editing the tags will automatically 
erase all previous tags!
</div>

Example(s): 
* `edit 2 n/Ruth t/0730-0830`
* `edit 3 r/May have to switch to zoom`

### 5.5 Finding a Consultation Event : `find`
Finds all events whose names contain any of the specified keywords and displays them as a list with index numbers.

Format: `find KEYWORD [MORE_KEYWORDS]...`

<div markdown="span" class="alert alert-primary">:bulb: **Tip**: The keywords are case-insensitive!
</div>

Example(s): 
* `find Jacob`

### 5.5 Listing all Free Slots : `free_slots`
Lists down all free slots in the schedule from today until the last event or blocked slot.

Format: `free_slots`

### 5.6 Viewing help : `help`

Opens a pop-up window with a link to DukePro(f)'s user guide.

Format: `help`

### 5.7 Listing all Consultation Events : `list`
Lists down all consultation events scheduled in DukePro(f).

Format: `list`

### 5.8 Displaying the next Consultation Event : `next_event`
Displays the next consultation event scheduled for the day in DukePro(f).

Format: `next_event`

### 5.9 Listing all Upcoming Events : `upcoming_events`
Lists down all the upcoming consultation events for the current day.

Format: `upcoming_events`

### 5.10 Viewing the Command Summary Page: `command_summary`
Opens a pop-up window with a Command Summary of all of DukePro(f)'s possible commands.

Format: `command_summary`

### 5.11 Exiting the app : `exit`
Exits DukePro(f).

Format: `exit`

### 5.12 Saving all edits
Event data is automatically saved into the hard disk after any command that changes the data. There is no
need to save manually.


## 6. FAQ
***
**Q**: Where are the releases?<br>
**A**: The release for v1.3 is a work in progress, please be patient!

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer, and overwrite the empty data file it creates with the file 
that contains the data of your previous DukePro(f) home folder.

<!-- **Q**: The dukeprof.jar isn’t opening when I double-click it.<br>
**A**: Try manually opening the dukeprof.jar on the command terminal using the command -java dukeprof.jar.
-->
