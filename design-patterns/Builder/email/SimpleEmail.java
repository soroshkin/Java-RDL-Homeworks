package Builder.email;

import Builder.recipients.IRecipient;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleEmail extends AEmailMessage {
    public SimpleEmail() {
        recipients = new ArrayList<>();
    }

    @Override
    public void send() {
        System.out.println("message sent");
    }

    @Override
    public IEmailMessage receive() {
        return this;
    }

    public void addSender(IRecipient sender) {
        this.sender = sender;
    }

    public boolean addRecipients(IRecipient... allRecipients) {
        return recipients.addAll(Arrays.asList(allRecipients));
    }

    public void addBody(String body){
        this.body = body;
    }

    public void addSubject(String subject){
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "SimpleEmail{" +
                "recipients=" + recipients +
                ", sender=" + sender +
                ", body='" + body + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
