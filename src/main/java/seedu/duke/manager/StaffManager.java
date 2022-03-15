package seedu.duke.manager;


import seedu.duke.entities.Staff;
import seedu.duke.controllers.MainLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * StaffManager is a class which stores/handles/manages many Staffs.
 */
public class StaffManager {
    private final List<Staff> staffs;

    /**
     * Create StaffManager with an empty arraylist of Staffs.
     */
    public StaffManager() {
        staffs = new ArrayList<>();
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    /**
     * Print all the Staffs.
     */
    public void printStaffs() {
        for (int i = 0; i < staffs.size(); i++) {
            System.out.println((i + 1) + ". " + staffs.get(i));
        }
    }

    /**
     * Add a Staff to staffs.
     *
     * @param staffId   ID of the Staff.
     * @param staffName Name of the Staff.
     * @param position  Job position of the Staff.
     * @param salary    Salary of the Staff.
     */
    public void addStaff(int staffId, String staffName, String position, double salary) {
        if (findByStaffId(staffId, false) != null) {
            MainLogger.logInfo("Failed to add staff: Staff with same ID already exists.");
            System.out.println("Staff with the same ID already exists, use another ID...");
        }
        MainLogger.logInfo("Successful addition of staff");
        staffs.add(new Staff(staffId, staffName, position, salary));
    }

    /**
     * Find Staff from Staffs by ID.
     *
     * @param staffId  ID of the Staff.
     * @param printMsg Boolean to determine if found message should be printed.
     */
    public Staff findByStaffId(int staffId, boolean printMsg) {
        if (staffId <= 0) {
            MainLogger.logInfo("Invalid input for ID.");
            System.out.println("Staff ID cannot be zero or negative.");
            return null;
        }
        for (Staff staff : staffs) {
            if (staffId == staff.getStaffId()) {
                if (printMsg) {
                    MainLogger.logInfo("Successful search for staff.");
                    System.out.println(staff + " found!");
                }
                return staff;
            }
        }
        MainLogger.logInfo("Unsuccessful search for staff.");
        if (printMsg) {
            System.out.println("Staff with ID " + staffId + " not found!");
        }
        return null;
    }

    /**
     * Delete Staff from Staffs by ID.
     *
     * @param staffId ID of the Staff
     */
    public void deleteByStaffId(int staffId) {
        Staff staff = findByStaffId(staffId, false);
        if (staff != null) {
            staffs.remove(staff);
            MainLogger.logInfo("Successful deletion of staff.");
            System.out.println(staff + " had been deleted from our staff records.");
        } else {
            MainLogger.logInfo("Failed to delete staff: No staff with matching ID.");
            System.out.println("No staff from our staff records has a matching ID.");
        }
    }

    /**
     * Return the number of staffs in Staffs.
     *
     * @return the number of current staff.
     */
    public int getNumOfStaffs() {
        return staffs.size();
    }
}
