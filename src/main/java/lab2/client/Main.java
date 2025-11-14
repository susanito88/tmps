package lab2.client;

import lab2.facade.EntryFacade;
import lab2.factories.SystemFactory;

public class Main {
    public static void main(String[] args) {
        EntryFacade facade = SystemFactory.createFacade();

        System.out.println("--- School Gate Simulation (Structural Patterns) ---");

        System.out.println("Simulating recognized entry (with ID S002):");
        facade.processEntry("S002");

        System.out.println();
        System.out.println("Simulating recognized entry (no ID provided):");
        facade.processEntry(null);
    }
}
