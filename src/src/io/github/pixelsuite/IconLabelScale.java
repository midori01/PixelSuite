package io.github.pixelsuite;

final class IconLabelScale {
    static int level(int value){return Math.max(0,Math.min(4,value));}
    static int percent(int value){return 65+10*level(value);}
    static float factor(int value){return percent(value)/100f;}
    static String name(int value){return new String[]{L10n.t("Smallest"),L10n.t("Small"),L10n.t("Medium"),L10n.t("Large"),L10n.t("Largest")}[level(value)];}
}
