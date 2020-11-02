package org.jesperancinha.ocp11.autocloseable;


import java.io.Closeable;
import java.io.IOException;
import java.util.UUID;

/**
 * A Fake closeable never works
 * A Try with resources statement always needs a Closeable interface in order for it to work.
 * <p>
 * Not implementing {@link Closeable} or {@link AutoCloseable} will result in incompatible types compilation error.
 * incompatible types: try-with-resources not applicable to variable type
 */
public class DiamondBox
        implements Closeable {

    private UUID uuid = UUID.randomUUID();
    private int pills;
    private boolean open = true;

    public void open() {
        System.out.printf("Diamond Box %s Opened\n", uuid);
    }

    public void read() throws IOException {
        if (this.pills == 0) {
            throw new IOException("No doll  found");
        } else {
            System.out.printf("%d dolls found!\n", this.pills);
        }
    }


    public void close() {
        if (this.open) {
            System.out.printf("Diamond Box %s closed\n", uuid);
        } else {
            System.out.println("Box is already closed!");
        }
        this.open = false;
    }

    public static void testDiamondBox() {
        try (DiamondBox d = new DiamondBox()) {
            d.open();
            d.read();
            d.write(4);
            // Close becomes redundant when closeable is implemented.
            d.close();
        } catch (IOException e) {
            System.out.println("Got Exception");
        }

        try (DiamondBox d = new DiamondBox()) {
            d.open();
            d.write(4);
            d.read();
            // Close becomes redundant when closeable is implemented.
            d.close();
        } catch (IOException e) {
            System.out.println("Got Exception");
        }
    }

    private void write(int pills) {
        this.pills = pills;
    }

    public static void main(String[] args) {
        DiamondBox.testDiamondBox();
    }

}
