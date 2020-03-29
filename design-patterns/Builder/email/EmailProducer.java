package Builder.email;

import Builder.recipients.RecipientNotAddedException;

public class EmailProducer {
    public static void main(String[] args) {
        EmailDirector director = new EmailDirector();
        try {
            System.out.println(director.buildSimpleEmail());
        } catch (RecipientNotAddedException e) {
            e.printStackTrace();
        }
    }
}
