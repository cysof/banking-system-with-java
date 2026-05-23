public class WhatsAppNotificationService implements  NotificationService{
    @Override
    public  void  sendNotification(String message){
        System.out.println("Whatsapp Message sent: " + message);
    }
}
