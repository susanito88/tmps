package lab2.facade;

import lab2.domain.Camera;
import lab2.models.Student;
import lab2.utilities.FaceRecognitionService;
import lab2.decorator.Notifier;

public class EntryFacade {
    private final Camera camera;
    private final FaceRecognitionService recognizer;
    private final Notifier notifier;

    public EntryFacade(Camera camera, FaceRecognitionService recognizer, Notifier notifier) {
        this.camera = camera;
        this.recognizer = recognizer;
        this.notifier = notifier;
    }

    public void processEntry(String idCardIfAvailable) {
        byte[] picture = camera.captureImage();
        Student matched = recognizer.recognize(picture, idCardIfAvailable);

        if (matched != null) {
            String msg = "Student " + matched.getName() + " entered at " + java.time.LocalTime.now();
            System.out.println("[Facade] Recognized: " + matched);
            notifier.notify(matched.getParentPhone(), msg);
            notifier.notify(matched.getParentEmail(), msg);
        } else {
            System.out.println("[Facade] No student recognized — please check manually.");
        }
    }
}
