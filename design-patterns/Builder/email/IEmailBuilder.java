package Builder.email;

import Builder.recipients.IRecipient;
import Builder.recipients.RecipientNotAddedException;

public interface IEmailBuilder {
    IEmailMessage create(); // создать письмо
    IEmailBuilder addSender(IRecipient recipient);
    IEmailBuilder addRecipients(IRecipient... recipients) throws RecipientNotAddedException;
    IEmailBuilder addBody(String body);
    IEmailBuilder addSubject(String subject);
}
