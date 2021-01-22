package org.jesperancinha.console.consolerizer;

import java.io.PrintWriter;

public class HtmlPWriter implements ConsolerizerWriter {

    private final PrintWriter writer;

    private ConsolerizerColor color;

    public HtmlPWriter(final PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void printPrivateText(String text) {
        writer.print(this.color.getPText(text));
    }

    @Override
    public void printNewLine() {
    }

    @Override
    public void printColor(ConsolerizerColor color) {
        this.color = color;
    }
}
