package org.jesperancinha.java11.crums.crum1;

import javax.management.AttributeList;
import javax.management.relation.RoleList;
import javax.management.relation.RoleUnresolvedList;
import java.util.List;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum1 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 1 - The subclasses of ArrayList");

        var arrayList = List.of("Madonna", "Mariah Carey", "Jennifer Lopez", "Shakira", "Beyonce", "Kelly Rowland");
        printMagentaGenericLn(
            "There are indeed three extra sub-types of ArrayList: AttributeList, RoleList, RoleUnresolvedList");

        printMagentaGenericLn("We can present a super music singer list this way:");

        printOrangeGenericLn(arrayList);

        var attributeList = new AttributeList();
        attributeList.add(0, "Madonna");
        attributeList.add(0, "Mariah Carey");
        attributeList.add(0, "Jennifer Lopez");
        attributeList.add(0, "Shakira");
        attributeList.add(0, "Beyonce");
        attributeList.add(0, "Kelly Rowland");

        printMagentaGenericLn("We then can use an Attribute List:");
        printOrangeGenericLn(attributeList);

        var roleList = new RoleList();
        roleList.add(0, "Madonna");
        roleList.add(0, "Mariah Carey");
        roleList.add(0, "Jennifer Lopez");
        roleList.add(0, "Shakira");
        roleList.add(0, "Beyonce");
        roleList.add(0, "Kelly Rowland");

        printMagentaGenericLn("We then can use an RoleList List:");
        printOrangeGenericLn(roleList);

        var roleUnresolvedList = new RoleUnresolvedList();
        roleUnresolvedList.add(0, "Madonna");
        roleUnresolvedList.add(0, "Mariah Carey");
        roleUnresolvedList.add(0, "Jennifer Lopez");
        roleUnresolvedList.add(0, "Shakira");
        roleUnresolvedList.add(0, "Beyonce");
        roleUnresolvedList.add(0, "Kelly Rowland");

        printMagentaGenericLn("Finally we can use an RoleUnresolvedList List:");
        printOrangeGenericLn(roleUnresolvedList);

        printGreenGenericLn("We can think of the three sub ArrayList types as just roles and attributes");
        printGreenGenericLn("We only have one subtype for AttributeList");
        printGreenGenericLn("We have two subtypes for roles and they are RoleList and RoleUnresolvedList");
        printGreenGenericLn("So Attributes => AttributeList");
        printGreenGenericLn("So Roles => RoleList");
        printGreenGenericLn("So Roles Unresolved => RoleUnresolvedList");
        printGreenGenericLn("We have created three instance examples of the three different listw");

    }
}
