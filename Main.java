/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ABN PC
 */

public class Main
{
    public static void main(String args[])
    {
    SecuritySystem mysecurity= new SecuritySystem();
    mysecurity.work();
    }
}
class SecuritySystem
{
    SecuritySystem(){}
     public void work(){
     boolean state;
     ControlPanel controlpanel = new ControlPanel();
     
     Scanner input = new Scanner(System.in);
     System.out.println("Enter true to continue the security system, false to Stop");   
     state = input.nextBoolean();
     while(state == true)
     {
     controlpanel.work();
     System.out.println("Enter true to continue the security system, false to Stop");   
     state = input.nextBoolean();
     }
     }
    
}
class ControlPanel
{
    ControlPanel()
    {}
    private boolean intrusion=false,set_state;
    public void work()
    {
    ArrayList<Sensor> sensors = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    sensors.add(new Alarm(1,true,"15 April 2017","In the Room"));
    sensors.add(new Light(2,true,"16 April 2017","Main Gate"));
    sensors.add(new SoundSensor(3,true,"17 April 2017","Bed Room"));
    sensors.add(new SmokeSensor(4,true,"18 April 2017","Study Room"));
    sensors.add(new MotionSensor(5,true,"19 April 2017","Jewelery Box"));
    sensors.add(new DoorSensor(6,true,"20 April 2017","Prayer Room"));
    sensors.add(new Camera(7,true,"21 April 2017","Tv Lounge"));
    
    for (int i = 0; i < sensors.size(); i++)
    { 
        System.out.println("_________________________________________________");
        System.out.println("Do you want the sensor on? Details are *** "+sensors.get(i).toString()+" *** (Enter true/false)");
        set_state=input.nextBoolean();
        if (set_state){
        System.out.println("Is Intrusion Detected Enter? true/false");
        intrusion=input.nextBoolean();
        }
        else intrusion=false;
        sensors.get(i).work(set_state, intrusion, sensors.get(i).getClass().getSimpleName());
    }
        System.out.println("_________________________________________________");
}
}
class Sensor implements sensorwork
{
private final int sensor_number;
private boolean sensor_state=false, intrusion_detected=false;
private final String date_of_install, location_of_install;
Sensor()
{
    sensor_number=get_sensor_number();
    date_of_install=get_date_of_install();
    location_of_install = get_location_of_install();
}
Sensor(int sensor_number, boolean sensor_state,
        String date_of_install, String location_of_install)
{
    this.sensor_number= sensor_number; setstate(sensor_state);
    this.location_of_install=location_of_install;
    this.date_of_install=date_of_install;
    
}
@Override
public String toString()
{
    return String.format(" \nThe Sensor Number = %d ,Date of Install : %s , Location of Install : %s ,Is It Working? %s", get_sensor_number(), get_date_of_install(), get_location_of_install(), getstate());
}
public int get_sensor_number()
{
    return sensor_number;
}
public String get_location_of_install()
{
    return location_of_install;
}
public String get_date_of_install()
{
    return date_of_install;
}
public void setstate(boolean sensor_state)
{
    this.sensor_state=sensor_state;
}
public boolean getstate()
{
    return sensor_state;
}
public void reset()
{
    setstate(false);
    setstate(true);
}
public boolean working_correctly()
{
    if (sensor_state == false)
    {
        return false;
    }
    else
        return true;
}

@Override
public void work(boolean state, boolean intrusion, String Sensorname){
    setstate(state); setintrusion(intrusion);
    System.out.println("*** The " + Sensorname + " has Detected Intrusion ? " + intrusion + "  -  Is it Working Correctly ? "+ working_correctly()+" ***");
}

public void setintrusion(boolean intrusion_detected)
{
    this.intrusion_detected= intrusion_detected;
}
public boolean getintrusion()
{
    return intrusion_detected;
}
}



 







