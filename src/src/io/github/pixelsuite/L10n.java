package io.github.pixelsuite;

import java.util.Locale;

/**
 * Translated UI text. Most of Pixel Suite's text is shown inside other apps (Pixel Launcher, System UI, Photos...),
 * where its own resources are not at hand, so the English text is the key and JapaneseText holds the Japanese for it.
 * The language is the one the hosting app runs in; text without a translation stays English. Only text people read
 * goes through here: strings matched against other apps' UI, keys and log messages stay as they are.
 */
final class L10n {
    private L10n() {}

    static boolean japanese() { return "ja".equals(Locale.getDefault().getLanguage()); }

    /** {@code english}, or its Japanese when the app runs in Japanese and a translation exists. */
    static String t(String english) {
        if (english == null || !japanese()) return english;
        String ja = JapaneseText.get(english);
        return ja == null ? english : ja;
    }

    /** t() of a format string (%s, %d, %1$s...), then formatted. */
    static String f(String english, Object... args) { return String.format(Locale.getDefault(), t(english), args); }
}
