/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author ABN PC
 */
public class SmokeSensor extends Sensor
{
    SmokeSensor(){}
    SmokeSensor(int sensor_number, boolean sensor_state,
    String date_of_install, String location_of_install)
    {
        super(sensor_number,sensor_state,date_of_install,location_of_install);
    } 
    @Override
   public void work(boolean state, boolean intrusion, String Sensorname){
    super.work(state,intrusion,Sensorname);
   }
     @Override
    public String toString()
{
    return "Smoke Sensor"+super.toString();
}
}
