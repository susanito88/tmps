package lab2.utilities;

import lab2.models.Student;

public interface FaceRecognitionService {
    Student recognize(byte[] image, String idCard);
}
