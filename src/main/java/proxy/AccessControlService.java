package proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {

    // Singleton instance
    private static AccessControlService instance;

    // Set is used because it does not allow duplications + it is faster than List. Map would be ok as well.
    private final Set<String> allowedAccessSet;

    private AccessControlService() {
        allowedAccessSet = new HashSet<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowAccess(String username, String documentId) {
        allowedAccessSet.add(username + ":" + documentId);
    }

    public boolean isAllowed(String username, String documentId) {
        return allowedAccessSet.contains(username + ":" + documentId);
    }
}
