package lab2.factories;

import lab2.adapter.LaptopCamera;
import lab2.adapter.LaptopCameraAdapter;
import lab2.domain.Camera;
import lab2.decorator.BaseNotifier;
import lab2.decorator.EmailDecorator;
import lab2.decorator.Notifier;
import lab2.decorator.SMSDecorator;
import lab2.facade.EntryFacade;
import lab2.utilities.FaceRecognitionService;
import lab2.utilities.SimpleFaceRecognition;

public class SystemFactory {
    public static EntryFacade createFacade() {
        LaptopCamera laptopCam = new LaptopCamera();
        Camera camera = new LaptopCameraAdapter(laptopCam);

        FaceRecognitionService recognizer = new SimpleFaceRecognition();

        Notifier base = new BaseNotifier();
        Notifier sms = new SMSDecorator(base);
        Notifier emailAndSms = new EmailDecorator(sms);

        return new EntryFacade(camera, recognizer, emailAndSms);
    }
}
