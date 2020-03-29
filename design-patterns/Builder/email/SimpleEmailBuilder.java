package Builder.email;

import Builder.recipients.IRecipient;
import Builder.recipients.RecipientNotAddedException;

public class SimpleEmailBuilder implements IEmailBuilder {
    SimpleEmail emailMessage;

    public SimpleEmailBuilder() {
        this.emailMessage = new SimpleEmail();
    }

    @Override
    public IEmailMessage create() {
        return emailMessage;
    }

    @Override
    public IEmailBuilder addSender(IRecipient sender) {
        emailMessage.addSender(sender);
        return this;
    }

    @Override
    public IEmailBuilder addRecipients(IRecipient... recipients) throws RecipientNotAddedException {
        if (emailMessage.addRecipients(recipients)){
            return this;
        } else {
            throw new RecipientNotAddedException("recipient could not be added");
        }
    }

    @Override
    public IEmailBuilder addBody(String body) {
        emailMessage.addBody(body);
        return this;
    }

    @Override
    public IEmailBuilder addSubject(String subject) {
        emailMessage.addSubject(subject);
        return this;
    }
}
