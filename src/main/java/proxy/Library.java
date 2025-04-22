package proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, DocumentInterface> documents;

    public Library() {
        documents = new HashMap<>();
    }

    // Unprotected
    public void addUnprotectedDocument(String id, String content) {
        DocumentInterface doc = new RealDocument(id, new Date(), content);
        documents.put(id, doc);
    }

    // Protected
    public void addProtectedDocument(String id, String content, String[] allowedUsers) {
        RealDocument realDoc = new RealDocument(id, new Date(), content);
        DocumentInterface proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);

        AccessControlService acs = AccessControlService.getInstance();
        for (String username : allowedUsers) {
            acs.allowAccess(username, id);
        }
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }
}
