package ChristmasGifts;

import java.io.Serializable;

public class Gift implements Serializable {
    private String description;
    private String recipient;

    public Gift(String description, String recipient) {
        this.description = description;
        this.recipient = recipient;
    }
    public String getDescription() {
        return description;
    }
    public String getRecipient() {
        return recipient;
    }
}
