package lab2.adapter;

import lab2.domain.Camera;
import java.nio.charset.StandardCharsets;

public class LaptopCameraAdapter implements Camera {
    private final LaptopCamera adaptee;

    public LaptopCameraAdapter(LaptopCamera adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public byte[] captureImage() {
        String snapResult = adaptee.snap();
        return snapResult.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String getSourceName() {
        return adaptee.deviceName();
    }
}
