package org.example;

public class OfficeWorker extends Employee implements Worker {
    private String officeNumber;

    public OfficeWorker(String name, String surname, String gender, boolean active,
                        String position, double payment, int experience, String department,
                        String officeNumber) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.officeNumber = officeNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is working on documents in office " + officeNumber + ".");
    }

    @Override
    public void uniqueTask() {
        System.out.println(getName() + " is scheduling meetings.");
    }
}
