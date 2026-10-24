package io.github.pixelsuite;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

final class CommunityLinks {
    static final String[] NAMES = {"Telegram", "Coffee", "Patreon"};
    static final String[] CAPTIONS = {L10n.t("Join the community"), L10n.t("Buy me a coffee"), L10n.t("Become a patron")};
    static final String[] ICONS = {"brand_telegram", "brand_coffee", "brand_patreon"};
    static final String[] URLS = {"https://t.me/RovianDev", "https://buymeacoffee.com/roviandev", "https://www.patreon.com/c/RovianDev"};
    static final int[] BADGES = {0xFFEAF7FF, 0xFFFFDD00, 0xFFFFFFFF};
    private CommunityLinks() {}
    static void open(Context context, int index) {
        if (index < 0 || index >= URLS.length) return;
        if(index==0){
            try{context.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("tg://resolve?domain=RovianDev")));return;}
            catch(ActivityNotFoundException unavailable){}catch(SecurityException denied){}
        }
        try { context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(URLS[index]))); }
        catch (ActivityNotFoundException unavailable) { AppToast.makeText(context,L10n.t("No app is available to open this link"),Toast.LENGTH_SHORT).show(); }
        catch (SecurityException denied) { AppToast.makeText(context,L10n.t("This link could not be opened"),Toast.LENGTH_SHORT).show(); }
    }
}
