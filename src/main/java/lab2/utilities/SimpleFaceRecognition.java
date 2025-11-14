package lab2.utilities;

import lab2.models.Student;
import java.util.HashMap;
import java.util.Map;

public class SimpleFaceRecognition implements FaceRecognitionService {
    private final Map<String, Student> registry = new HashMap<>();

    public SimpleFaceRecognition() {
        registry.put("S001", new Student("S001", "Ana Pop", "+37360000123", "ana.parent@example.com"));
        registry.put("S002", new Student("S002", "Ion Ionescu", "+37360000456", "ion.parent@example.com"));
    }

    @Override
    public Student recognize(byte[] image, String idCard) {
        if (idCard != null && registry.containsKey(idCard))
            return registry.get(idCard);
        return registry.values().stream().findFirst().orElse(null);
    }
}
