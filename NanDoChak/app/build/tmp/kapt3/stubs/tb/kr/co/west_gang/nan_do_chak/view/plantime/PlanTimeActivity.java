package kr.co.west_gang.nan_do_chak.view.plantime;

import android.content.Intent;
import android.os.Bundle;
import android.widget.NumberPicker;
import androidx.lifecycle.Observer;
import kr.co.west_gang.nan_do_chak.R;
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity;
import kr.co.west_gang.nan_do_chak.databinding.ActivityPlanTimeBinding;
import kr.co.west_gang.nan_do_chak.util.AppConfig;
import kr.co.west_gang.nan_do_chak.view.main.MainActivity;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\f\u0010\u001e\u001a\u00020\u0017*\u00020\u001fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lkr/co/west_gang/nan_do_chak/view/plantime/PlanTimeActivity;", "Lkr/co/west_gang/nan_do_chak/architecture/BaseActivity;", "()V", "binding", "Lkr/co/west_gang/nan_do_chak/databinding/ActivityPlanTimeBinding;", "getBinding", "()Lkr/co/west_gang/nan_do_chak/databinding/ActivityPlanTimeBinding;", "binding$delegate", "Lkotlin/Lazy;", "hours", "", "minutes", "time", "", "valueOfPlanTimePicker", "", "[Ljava/lang/String;", "viewModel", "Lkr/co/west_gang/nan_do_chak/view/plantime/PlanTimeViewModel;", "getViewModel", "()Lkr/co/west_gang/nan_do_chak/view/plantime/PlanTimeViewModel;", "viewModel$delegate", "getTimeFromPicker", "", "gotoMain", "initNumberPicker", "observeLiveData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "formatter", "Landroid/widget/NumberPicker;", "app_tb"})
public final class PlanTimeActivity extends kr.co.west_gang.nan_do_chak.architecture.BaseActivity {
    private final kotlin.Lazy binding$delegate = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private int hours = 0;
    private int minutes = 0;
    private java.lang.String time;
    private final java.lang.String[] valueOfPlanTimePicker = {"\uc624\uc804", "\uc624\ud6c4"};
    
    private final kr.co.west_gang.nan_do_chak.databinding.ActivityPlanTimeBinding getBinding() {
        return null;
    }
    
    private final kr.co.west_gang.nan_do_chak.view.plantime.PlanTimeViewModel getViewModel() {
        return null;
    }
    
    private final void formatter(android.widget.NumberPicker $this$formatter) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initNumberPicker() {
    }
    
    private final void observeLiveData() {
    }
    
    private final void getTimeFromPicker() {
    }
    
    private final void gotoMain() {
    }
    
    public PlanTimeActivity() {
        super();
    }
}