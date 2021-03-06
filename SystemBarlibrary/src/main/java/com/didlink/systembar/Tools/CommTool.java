package com.didlink.systembar.Tools;

import android.app.Activity;
import android.graphics.Color;


public class CommTool {
    public static int getResultColor(Activity activity, Object object) {
        if (object instanceof String) {// "#666666"
            return Color.parseColor((String) object);
        } else if (object instanceof Integer) {
            if ((Integer) object > 0)// R.string.app_color
                return activity.getResources().getColor((Integer) object);
            else return (Integer) object;// Color.BLUE
        } else throw new IllegalStateException("The current color is not found");
    }

    public static String getResultString(Activity activity, Object object) {
        if (object instanceof String)
            return (String) object;
        else if (object instanceof Integer && (Integer) object > 0) //R.string.app_name
            return activity.getResources().getString((Integer) object);
        else throw new IllegalStateException("The current string is not found");
    }

    public static int calculateColorWithAlpha(int color, int alpha) {
        float a = 1 - alpha / 255f;
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color & 0xff;
        red = (int) (red * a + 0.5);
        green = (int) (green * a + 0.5);
        blue = (int) (blue * a + 0.5);
        return 0xff << 24 | red << 16 | green << 8 | blue;
    }

    public static int getStatusBarHeight(Activity activity) {
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return activity.getResources().getDimensionPixelSize(resourceId);
    }
}
