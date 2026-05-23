public class SMSNotificationService implements NotificationService{

    @Override
    public void  sendNotification(String message){
        System.out.println("SMS Sent: " + message);

    }
}
