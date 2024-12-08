package org.example;

public class KitchenWorker extends Employee implements Worker {
    private String specialtyDish;

    public KitchenWorker(String name, String surname, String gender, boolean active,
                         String position, double payment, int experience, String department,
                         String specialtyDish) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.specialtyDish = specialtyDish;
    }

    public String getSpecialtyDish() {
        return specialtyDish;
    }

    public void setSpecialtyDish(String specialtyDish) {
        this.specialtyDish = specialtyDish;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is preparing " + specialtyDish + ".");
    }

    @Override
    public void uniqueTask() {
        System.out.println(getName() + " is organizing the kitchen supplies.");
    }
}
