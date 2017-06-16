package in.weargenius.main;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

public class Main {

    private static I2CDevice   dev = null;
    static boolean x =false;
	public static void main(String[] args) throws Exception{
		System.out.println("DHT12 Pi4j Example.");
        I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1); //

        dev = bus.getDevice(0x5c); //Address for MCp23017 change if A0,A1,A2 are connected to diff potenrial
        byte data[] = new byte[5];
        dev.read(0x00,data, 0,5);
        if(x){
	     	System.out.println(data[0]); //Humidity
	     	System.out.println(data[1]); //HUmidity decimal places
	     	System.out.println(data[2]); //Temperature
	     	System.out.println(data[3]); //Temperature decimal places
	     	System.out.println(data[4]); // Checksum = data[0]+data[1]+data[2]+data[3]
        }
     	
     	if(data[4]==(data[0]+data[1]+data[2]+data[3])){

         	double humidity=Double.parseDouble(data[0]+"."+data[1]);
         	double temperature=Double.parseDouble(data[2]+"."+data[3]);
         	System.out.println("humidity is : "+humidity+" %RH");
         	System.out.println("Temperature is : "+temperature+" °C");
     	}
     	else
     		System.out.println("Error in communication.");
	}
	
   
}