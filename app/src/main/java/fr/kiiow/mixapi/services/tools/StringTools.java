package fr.kiiow.mixapi.services.tools;

public class StringTools {

    public static String substring(String value, int from, int to) {
        if(value == null) return null;
        if(from > value.length() || to < from) return "";
        return value.substring(from, Math.min(to, value.length()));
    }
}
