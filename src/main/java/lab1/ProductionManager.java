package lab1;

public class ProductionManager {
    private static ProductionManager instance;

    private ProductionManager() {
    }

    // synchronized
    public static synchronized ProductionManager getInstance() {
        if (instance == null) {
            instance = new ProductionManager();
        }
        return instance;
    }

    public void manageProduction() {
        System.out.println("Production Manager: managing factories and production lines...");
    }

    public void log(String message) {
        System.out.println("[Production Log] " + message);
    }
}

