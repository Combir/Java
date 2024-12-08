package org.example;

public class GuardWorker extends Employee implements Worker {
    private String shiftTime;

    public GuardWorker(String name, String surname, String gender, boolean active,
                       String position, double payment, int experience, String department,
                       String shiftTime) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.shiftTime = shiftTime;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is patrolling during the " + shiftTime + " shift.");
    }

    @Override
    public void uniqueTask() {
        System.out.println(getName() + " is inspecting security cameras.");
    }
}
