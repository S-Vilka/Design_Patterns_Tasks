package bridge.devices;

public class Projector implements Device {
    private boolean on = false;
    private int brightness = 50;
    private int slide = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return brightness;
    }

    @Override
    public void setVolume(int brightness) {
        if (brightness > 100) {
            this.brightness = 100;
        } else if (brightness < 0) {
            this.brightness = 0;
        } else {
            this.brightness = brightness;
        }
    }

    @Override
    public int getChannel() {
        return slide;
    }

    @Override
    public void setChannel(int slide) {
        if (slide > 0) {
            this.slide = slide;
        }
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm a projector.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current brightness is " + brightness + "%");
        System.out.println("| Current slide is " + slide);
        System.out.println("------------------------------------\n");
    }
}