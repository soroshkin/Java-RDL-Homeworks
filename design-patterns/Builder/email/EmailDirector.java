package Builder.email;

import Builder.recipients.IRecipient;
import Builder.recipients.Recipient;
import Builder.recipients.RecipientNotAddedException;

public class EmailDirector {
    public IEmailMessage buildSimpleEmail() throws RecipientNotAddedException {
        IEmailBuilder emailBuilder = new SimpleEmailBuilder();
        IRecipient recipient = new Recipient();
        recipient.create("Bach", "Holy Roman Empire");

        IRecipient sender = new Recipient();
        sender.create("Me", "Russia");

        return emailBuilder.addSender(sender)
                .addBody("Hello")
                .addSubject("test")
                .addRecipients(recipient)
                .create();
    }
}
