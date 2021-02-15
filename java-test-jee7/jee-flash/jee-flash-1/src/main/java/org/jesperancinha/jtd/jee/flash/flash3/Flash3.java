package org.jesperancinha.jtd.jee.flash.flash3;

import java.util.Arrays;
import java.util.Collections;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash3 {
    public static void main(String[] args) {

        BLUE.printGenericTitleLn("Flash 3 - How to best use websockets ?");
        setupFastDefaultWideTitleSpread();
        final String question = "With which annotation(s) can you specify that a socket can receive a TEXT and a BINARY and describe different handling for each of them?";

        int maxFails = 1;
        final var correctAnswers = Collections.singletonList("@OnMessage");

        if (!Arrays.asList(args).contains("-d3")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");

        YELLOW.printGenericLn("from:\nhttps://www.byteslounge.com/tutorials/java-ee-html5-websockets-encoder-and-decoder-example");
        MAGENTA.printGenericLn("As described in Mastery 2, the most efficient way is to use these types directly");
        MAGENTA.printGenericLn("@OnMessage of the websockets library has support for three types of messages: BINARY, TEXT and PONG");
        MAGENTA.printGenericLn("BINARY and TEXT is what we are looking in this exercise");
        MAGENTA.printGenericLn("Pong is a message response theoretically received from the browser.");
        BLUE.printGenericLn("Example:");
        BLUE.printGenericLn("@ServerEndpoint(value = \"/ariaschorus/noencoding/lyrics\")\n" +
                "public class ListenerNoCodingReceiver {\n" +
                "\n" +
                "    @OnMessage\n" +
                "    public void receiveLyrics(String text, Session session) {\n" +
                "        BLUE.printGenericTitleLn(\"Without encoding this is the TEXT\");\n" +
                "        BLUE.printGenericTitleLn(text);\n" +
                "        JsonObject jsonObject = Json\n" +
                "                .createReader(new StringReader(text)).readObject();\n" +
                "        Lyric lyric = new Lyric();\n" +
                "        lyric.setSong(jsonObject.getString(\"song\"));\n" +
                "        lyric.setArtist(jsonObject.getString(\"artist\"));\n" +
                "        lyric.setLyricExtract(jsonObject.getString(\"lyricExtract\"));\n" +
                "        final RemoteEndpoint.Async asyncRemote = session.getAsyncRemote();\n" +
                "        asyncRemote.sendObject(text);\n" +
                "    }\n" +
                "\n" +
                "    @OnMessage\n" +
                "    public void receiveLyrics2(ByteBuffer bytes, Session session) {\n" +
                "        BLUE.printGenericTitleLn(\"Without encoding this is the BINARY\");\n" +
                "        byte[] array = new byte[bytes.limit()];\n" +
                "        bytes.get(array);\n" +
                "        final String receivedString = new String(array).replace(\"\" + (char) 0, \"\");\n" +
                "        JsonObject jsonObject = Json\n" +
                "                .createReader(new StringReader(receivedString)).readObject();\n" +
                "        Lyric2 lyric2 = new Lyric2();\n" +
                "        lyric2.setSong(jsonObject.getString(\"song\"));\n" +
                "        lyric2.setArtist(jsonObject.getString(\"artist\"));\n" +
                "        lyric2.setLyricExtract(jsonObject.getString(\"lyricExtract\"));\n" +
                "        BLUE.printGenericTitleLn(lyric2);\n" +
                "        final RemoteEndpoint.Async asyncRemote = session.getAsyncRemote();\n" +
                "        asyncRemote.sendObject(receivedString);\n" +
                "    }\n" +
                "}\n");
    }
}
