package com.buuz135.api;


import com.buuz135.extrachat.ExtraChat;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

import java.util.Random;

public class Format {
    private static Random rn = new Random();

    public static String getRawMessage(String mess) {
        return mess.substring(mess.indexOf(" ") + 1);
    }

    public static String formatMessageToString(String format, String player, String message) {
        return format.replaceAll("%PLAYER%", player).replaceAll("%MES%", message);
    }

    public static Text colorString(String mess) {
        return Texts.fromLegacy(mess, '&');
    }


    public static String createBlacklistedString(int size, String customStyle) {
        String dot = "";
        for (int i = 0; i < size; ++i) {
            dot = dot + getRandomChar(customStyle);
        }
        return dot;
    }

    private static char getRandomChar(String s) {
        char c = s.charAt(rn.nextInt(s.length()));
        ExtraChat.logger.info(c+"");
        return c;
    }

    public static Text formatPrivateMessage(String format, String message, String sender, String reciever) {
        return colorString(format.replaceAll("%SENDER%", sender).replaceAll("%RECI%", reciever).replaceAll("%MES%", message));
    }

    public static Text formatChannelTag(String format, String channelTag) {
        return colorString(format.replaceAll("%TAG%", channelTag));
    }
}
