---
layout: page
title: ruthpohrp's Project Portfolio Page
---

### Project: DukePro(f)

DukePro(f) is a schedule-planning desktop application that assists university professors in managing their 
consultations. 
The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 42k Loc.

Given below are my contributions to the project.

* **New Feature**: Blocked Slot Feature - Storing Blocked Slots Data
    * PR(s): [#85](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/85)
    * What it does: Stores list of blocked slots in the same .json file as consultation events
    * Justification: This feature improves the product significantly as users are likely to want to save 
      the data of the slots they've blocked previously rather than have to input it every time they open 
      the application.
      
* **New Feature**: Blocked Slot Feature - Check for Overlapping Feature
    * PR(s): [#80](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/80)
    * What it does: Implements methods to check if any Overlappables (Event and BlockedSlot) have overlapping timing with each other
    * Justification: This feature improves the product significantly as users are likely to want to check if existing and to-be-added events 
      do not overlap to ensure they do not clash. This is also a key feature of the Blocked Slot Feature.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/?search=ruthpohrp&sort=groupTitle&sortWithin=title&since=2021-09-17&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false)

* **Project management**:

* **Enhancements to existing features**: Additional Remark field in Event model
    * PR(s): [#71](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/71)
    * What it does: Allow users to add and edit a new field called `remark` when adding and/or editing a
      consultation event
    * Justification: Users are likely to want to add details about their consultation events e.g. Contact
      details of their student.
    * Credit: Idea of the remark feature is taken from AB-3 (though implemented differently).

* **Enhancements to existing features**: Refactoring of code to suit DukePro(f)
    * PR(s): [#42](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/42)
    * What it does: Refactors names and fields of AB-3 classes and objects to suit DukePro(f)

* **Enhancements to existing features**: Addition of test cases for Remark and Overlapping Features
    *  PR(s): Added when implementing feature
    *  Adds tests for new features to increase test coverage
  
* **Documentation**:
    * User Guide:
      * PR(s): [#18](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/18), [#19](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/19), [#20](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/20), [#55](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/55), [#98](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/98), [#159](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/159), [#198](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/198)
      * Wrote format, structure, and documentation for the whole User Guide in early and later stages: 
        * Introduction and Table of Contents
        * 1. Purpose
        * 2. Meaning of Icons and Textboxes
        * 3. Quick Start
        * 4. Command Summary
        * 5. Commands and their Features
        * 6. FAQ 
    * Developer Guide:
        * PR(s): [#71](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/71), [#196](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/196), [#197](https://github.com/AY2122S1-CS2103T-T11-4/tp/pull/197)
        * Added implementation details of the addition of the `remark` field.
        * Added implementation details of the addition of the Blocked Feature regarding Storage.
        * Added user stories and updated test cases for Appendix: Instructions for manual testing
    
* **Team-Based Tasks**:
    * Set up Codecov for repo
    * Maintained issue tracker and assigned people when necessary
    * Contributed to releases `v1.2 - v1.4` (4 releases) on GitHub
    * Managed releases `v1.3(trial)` and `v1.3`
    * Morphing of original product (AB-3) to current product (DukePro(f))
    * In charge of documenting User Guide (along with luluyousef)

* **Community**:
    * Reported [bugs and suggestions](https://github.com/ruthpohrp/ped/issues) for team UNIon, another team in the module.
