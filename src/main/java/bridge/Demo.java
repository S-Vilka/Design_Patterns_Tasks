package bridge;

import bridge.devices.Device;
import bridge.devices.Projector;
import bridge.devices.Radio;
import bridge.devices.Tv;
import bridge.remotes.AdvancedRemote;
import bridge.remotes.BasicRemote;
import bridge.remotes.PresentationRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
        testProjector(new Projector());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

    public static void testProjector(Device device) {
        System.out.println("Tests with presentation remote.");
        PresentationRemote presentationRemote = new PresentationRemote(device);
        presentationRemote.power();
        presentationRemote.nextSlide();
        presentationRemote.adjustBrightnessUp();
        device.printStatus();
    }
}
