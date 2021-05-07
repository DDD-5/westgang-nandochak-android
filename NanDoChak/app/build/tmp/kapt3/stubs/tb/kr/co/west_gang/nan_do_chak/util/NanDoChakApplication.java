package kr.co.west_gang.nan_do_chak.util;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import dagger.hilt.android.HiltAndroidApp;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lkr/co/west_gang/nan_do_chak/util/NanDoChakApplication;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_tb"})
@dagger.hilt.android.HiltAndroidApp()
public final class NanDoChakApplication extends android.app.Application {
    private static android.content.Context context;
    @org.jetbrains.annotations.NotNull()
    public static final kr.co.west_gang.nan_do_chak.util.NanDoChakApplication.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public NanDoChakApplication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tJ\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lkr/co/west_gang/nan_do_chak/util/NanDoChakApplication$Companion;", "", "()V", "context", "Landroid/content/Context;", "getAppContext", "getBoolean", "", "resId", "", "getColor", "getFont", "Landroid/graphics/Typeface;", "getInt", "getString", "", "getStringArray", "", "(I)[Ljava/lang/String;", "app_tb"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getAppContext() {
            return null;
        }
        
        public final int getColor(int resId) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getString(int resId) {
            return null;
        }
        
        public final boolean getBoolean(int resId) {
            return false;
        }
        
        public final int getInt(int resId) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Typeface getFont(int resId) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String[] getStringArray(int resId) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}