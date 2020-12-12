package org.jesperancinha.ocp11.mastery3dot1;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery3dot1.items.Record;
import org.jesperancinha.ocp11.mastery3dot1.items.ShopItem;
import org.jesperancinha.ocp11.mastery3dot1.items.VinylRecord;

public class Shop {
    public static void checkItem(ShopItem shopItem) {
        Consolerizer.printOrangeGenericLn("Object %s is cleared to be sold as a ShopItem!", shopItem);
    }

    public static void checkItem(Record record) {
        Consolerizer.printOrangeGenericLn("Object %s is cleared to be sold as a Record!", record);
    }

    public static void checkItem(VinylRecord vinylRecord) {
        Consolerizer.printOrangeGenericLn("Object %s is cleared to be sold as a VinylRecord!", vinylRecord);
    }
}
