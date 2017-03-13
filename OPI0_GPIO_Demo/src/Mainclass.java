import com.pi4j.io.gpio.*;
import com.pi4j.platform.Platform;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.platform.PlatformManager;

public class Mainclass {

    public static void main(String[] args) throws InterruptedException, PlatformAlreadyAssignedException {

    	System.out.println("Starting Demo");
        PlatformManager.setPlatform(Platform.ORANGEPI); // Support for Orange Pi

        final GpioController gpio = GpioFactory.getInstance();

        GpioPinDigitalInput inputPin = gpio.provisionDigitalInputPin(OrangePiPin.GPIO_00,PinPullResistance.PULL_UP);// Pulled UP
        GpioPinDigitalOutput outputPin = gpio.provisionDigitalOutputPin(OrangePiPin.GPIO_07);
        while(true){
        if(inputPin.isLow()){// Checks if switch is pressed.

        	System.out.println("Switch is pressed.");
        	outputPin.low();
        }
        else{
        	outputPin.high();
        }
        }
       // gpio.shutdown();
    }
}
