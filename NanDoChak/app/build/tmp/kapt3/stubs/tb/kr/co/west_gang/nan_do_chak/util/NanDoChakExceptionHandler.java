package kr.co.west_gang.nan_do_chak.util;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import kr.co.west_gang.nan_do_chak.view.main.MainActivity;
import java.io.PrintWriter;
import java.io.StringWriter;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lkr/co/west_gang/nan_do_chak/util/NanDoChakExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "application", "Landroid/app/Application;", "defaultExceptionHandler", "(Landroid/app/Application;Ljava/lang/Thread$UncaughtExceptionHandler;)V", "activityCount", "", "bundle", "Landroid/os/Bundle;", "lastActivity", "Landroid/app/Activity;", "restartActivity", "", "activity", "uncaughtException", "thread", "Ljava/lang/Thread;", "throwable", "", "app_tb"})
public final class NanDoChakExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler {
    private android.app.Activity lastActivity;
    private android.os.Bundle bundle;
    private int activityCount = 0;
    private final java.lang.Thread.UncaughtExceptionHandler defaultExceptionHandler = null;
    
    @java.lang.Override()
    public void uncaughtException(@org.jetbrains.annotations.NotNull()
    java.lang.Thread thread, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
    }
    
    private final void restartActivity(android.app.Activity activity) {
    }
    
    public NanDoChakExceptionHandler(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.Nullable()
    java.lang.Thread.UncaughtExceptionHandler defaultExceptionHandler) {
        super();
    }
}