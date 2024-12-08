package org.example;

public class Main {
    public static void main(String[] args) {
        KitchenWorker chef = new KitchenWorker("Aleksey", "Alekseev", "Female", true,
                "Chef", 5000, 5, "Kitchen", "Pasta");
        OfficeWorker manager = new OfficeWorker("Maria", "Alexandrova", "Male", true,
                "Manager", 7000, 10, "HR", "101");
        GuardWorker guard = new GuardWorker("Mikhail", "Fotiev", "Male", true,
                "Guard", 3000, 2, "Security", "Night");

        chef.sleep();
        chef.work();
        chef.uniqueTask();

        manager.sleep();
        manager.work();
        manager.uniqueTask();

        guard.sleep();
        guard.work();
        guard.uniqueTask();
    }
}
