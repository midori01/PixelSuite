package io.github.pixelsuite;

import android.widget.TextView;

final class LauncherLabelSizing {
    static void apply(TextView view) {
        try {
            if (Boolean.TRUE.equals(Xp.getAdditionalInstanceField(view,"pixelsuite_drawer_folder_label"))) return;
            if (Boolean.TRUE.equals(Xp.getAdditionalInstanceField(view,"pixelsuite_two_line_cell"))) return;
            int display=((Number)LauncherFeatures.get(view,"mDisplay")).intValue();
            Object profile=LauncherFeatures.get(view,"mDeviceProfile");
            Object area=display==0?LauncherFeatures.part(profile,"mWorkspaceProfile"):(display==1||display==8||display==9)?LauncherFeatures.part(profile,"mAllAppsProfile"):null;
            if(area==null)return;
            float nativeSize=((Number)LauncherFeatures.get(area,"iconTextSizePx")).floatValue();
            boolean enabled=LauncherFeatures.on(LauncherFeatures.LABEL_SIZE);
            float size=nativeSize*(enabled?IconLabelScale.factor(LauncherFeatures.labelLevel):1f);
            if(Math.abs(view.getTextSize()-size)>.1f)view.setTextSize(0,size);
            Object saved=Xp.getAdditionalInstanceField(view,"pixelsuite_native_label_padding");
            if(!(saved instanceof int[])){saved=new int[]{view.getPaddingLeft(),view.getPaddingRight()};Xp.setAdditionalInstanceField(view,"pixelsuite_native_label_padding",saved);}
            int[] padding=(int[])saved;
            int side=LauncherFeatures.dp(view.getContext(),2);
            int left=enabled?Math.min(padding[0],side):padding[0],right=enabled?Math.min(padding[1],side):padding[1];
            if(left!=view.getPaddingLeft()||right!=view.getPaddingRight())view.setPadding(left,view.getPaddingTop(),right,view.getPaddingBottom());
        }catch(Throwable error){}
    }
}
