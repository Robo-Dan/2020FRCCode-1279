/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.links.Link;

/**
 * Add your docs here.
 */
public class PixyCamera extends SubsystemBase
{

    private final Pixy2 pixy;
    
    public PixyCamera(Link link) 
    {
        pixy = Pixy2.createInstance(link);
        pixy.init();
    }
    
    public PixyCamera(Link link, int arg)
    {
        pixy = Pixy2.createInstance(link);
        pixy.init(arg);
    }
    
    public Pixy2 getPixy()
    {
        return pixy;
    }
    
}