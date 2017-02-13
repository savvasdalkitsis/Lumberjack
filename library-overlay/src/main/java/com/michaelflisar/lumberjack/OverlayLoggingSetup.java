package com.michaelflisar.lumberjack;

import android.graphics.Color;
import android.util.Log;

/**
 * Created by flisar on 13.02.2017.
 */

public class OverlayLoggingSetup
{
    private int mBackgroundColor = Color.parseColor("#64000000");
    private int mColorVerbose = Color.WHITE;
    private int mColorDebug = Color.WHITE;
    private int mColorInfo = Color.WHITE;
    private int mColorWarn = Color.WHITE;
    private int mColorError = Color.RED;
    private int mColorAssert = Color.RED;
    private int mTextSizeInDp = 12;
    private int mOverlayHeightInDp = 150;

    private int mPermissionRequestCode = 200;

    public OverlayLoggingSetup()
    {

    }

    /**
     * define a custom background for the overlay
     * DEFAULT: #64000000 (light transparent grey)
     *
     * @param backgroundColor The background color
     */
    public OverlayLoggingSetup withBackgroundColor(int backgroundColor)
    {
        mBackgroundColor = backgroundColor;
        return this;
    }

    /**
     * define a custom message color for verbose logs
     * DEFAULT: white
     *
     * @param color The color
     */
    public OverlayLoggingSetup withColorVerbose(int color)
    {
        mColorVerbose = color;
        return this;
    }

    /**
     * define a custom message color for debug logs
     * DEFAULT: white
     *
     * @param color The color
     */
    public OverlayLoggingSetup withColorDebug(int color)
    {
        mColorDebug = color;
        return this;
    }

    /**
     * define a custom message color for info logs
     * DEFAULT: white
     *
     * @param color The color
     */
    public OverlayLoggingSetup withColorInfo(int color)
    {
        mColorInfo = color;
        return this;
    }

    /**
     * define a custom message color for warn logs
     * DEFAULT: white
     *
     * @param color The color
     */
    public OverlayLoggingSetup withColorWarn(int color)
    {
        mColorWarn = color;
        return this;
    }

    /**
     * define a custom message color for error logs
     * DEFAULT: red
     *
     * @param color The color
     */
    public OverlayLoggingSetup withColorError(int color)
    {
        mColorError = color;
        return this;
    }

    /**
     * define a custom message color for assert logs
     * DEFAULT: red
     *
     * @param color The color
     */
    public OverlayLoggingSetup withColorAssert(int color)
    {
        mColorAssert = color;
        return this;
    }

    /**
     * define a custom request code for the permission request dialog
     * DEFAULT: 200
     *
     * @param requestCode The request code
     */
    public OverlayLoggingSetup withPermissionRequestCode(int requestCode)
    {
        mPermissionRequestCode = requestCode;
        return this;
    }

    /**
     * define a custom text size for log messages
     * DEFAULT: 12dp
     *
     * @param dp The text size in dp
     */
    public OverlayLoggingSetup withTextSizeInDp(int dp)
    {
        mTextSizeInDp = dp;
        return this;
    }

    /**
     * define a custom height for the overlay
     * DEFAULT: 150dp
     *
     * @param dp The ovverlay height in dp
     */
    public OverlayLoggingSetup withOverlayHeightInDp(int dp)
    {
        mOverlayHeightInDp = dp;
        return this;
    }

    public int getBackgroundColor()
    {
        return mBackgroundColor;
    }

    public int getPermissionRequestCode()
    {
        return mPermissionRequestCode;
    }

    public int getTextSize()
    {
        return mTextSizeInDp;
    }

    public int getOverlayHeight()
    {
        return mOverlayHeightInDp;
    }

    public int getColor(int priority)
    {
        switch (priority)
        {
            case Log.VERBOSE:
                return mColorVerbose;
            case Log.DEBUG:
                return mColorDebug;
            case Log.INFO:
                return mColorInfo;
            case Log.WARN:
                return mColorWarn;
            case Log.ERROR:
                return mColorError;
            case Log.ASSERT:
                return mColorAssert;
        }
        return mColorDebug;
    }
}
