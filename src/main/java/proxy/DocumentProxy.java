package proxy;

import java.util.Date;

public class DocumentProxy implements DocumentInterface {
    private final RealDocument realDocument;
    private final AccessControlService accessControlService;

    public DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance(); // singleton
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public Date getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(user.getUsername(), realDocument.getId())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}
