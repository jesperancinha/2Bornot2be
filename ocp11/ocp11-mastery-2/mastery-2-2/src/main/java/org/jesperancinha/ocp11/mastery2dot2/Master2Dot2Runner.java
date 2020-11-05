package org.jesperancinha.ocp11.mastery2dot2;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGeneric;

public class Master2Dot2Runner {
    public static void main(String[] args) {

        Consolerizer.typingWaitGlobal = 0;

        printBlueGenericLn("================== Master Module mastery-2-2 ==================");

        printRainbowTitleLn("1. Serializing `FileOutputStream` and `FileInputStream`");
        printRainbowLn("==");
        printYellowGeneric("### Creating Apollo 13 Mission but missing a few details\n");
        String fileName = "/tmp/destination";
        try (var fileOutputStream = new FileOutputStream(fileName);
             var objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            var missionData = new MissionData();
            missionData.destination = "The Moon";
            missionData.origin = "Earth";
            missionData.mission = "Apollo 13";
            objectOutputStream.writeObject(missionData);
            printGreenGenericLn("File has been created on this location -> %s",fileName);
            printGreenGenericLn("Data -> %s",missionData);
            printGreenGenericLn("Please run module %s to realize that default field are read with Java default values and no the assigned ones,\nif they are not part of the serialized data", "mastery-2-2-deserializer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
