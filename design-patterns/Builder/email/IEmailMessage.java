package Builder.email;

public interface IEmailMessage {
    void send(); // отправить письмо
    IEmailMessage receive(); // получить письмо

}
