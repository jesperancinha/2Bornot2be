package org.jesperancinha.ocp11.crums.crum31;

import java.io.File;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.function.Function;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum31 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 31 - File permissions");

        final Function<File, String> fun = (file) -> file.getAbsolutePath();
        File f = new File("/tmp/txt.txt");
        Permission perm = new java.io.FilePermission(f.getPath(), "read");
        PermissionCollection perms = perm.newPermissionCollection();
        perms.add(perm);
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                printOrangeGenericLn(fun.apply(f));
                return null;
            }
        }, new AccessControlContext(new ProtectionDomain[] { new ProtectionDomain(null, perms) }));

        printGreenGenericLn("Make sure to study this code. This is how you make sure to reduce privileges from a high privileged user on demand");
    }
}
