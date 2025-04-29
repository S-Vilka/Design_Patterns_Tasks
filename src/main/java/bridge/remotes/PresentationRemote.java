package bridge.remotes;

import bridge.devices.Device;

public class PresentationRemote extends BasicRemote {

    public PresentationRemote(Device device) {
        super.device = device;
    }

    public void nextSlide() {
        System.out.println("Presentation Remote: next slide");
        device.setChannel(device.getChannel() + 1);
    }

    public void previousSlide() {
        System.out.println("Presentation Remote: previous slide");
        device.setChannel(device.getChannel() - 1);
    }

    public void adjustBrightnessUp() {
        System.out.println("Presentation Remote: brightness up");
        device.setVolume(device.getVolume() + 10);
    }

    public void adjustBrightnessDown() {
        System.out.println("Presentation Remote: brightness down");
        device.setVolume(device.getVolume() - 10);
    }
}