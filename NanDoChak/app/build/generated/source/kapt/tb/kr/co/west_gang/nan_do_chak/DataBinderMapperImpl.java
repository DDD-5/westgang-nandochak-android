package kr.co.west_gang.nan_do_chak;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kr.co.west_gang.nan_do_chak.databinding.ActivityAverageReadyTimeBindingImpl;
import kr.co.west_gang.nan_do_chak.databinding.ActivityEarlyArrivedTimeBindingImpl;
import kr.co.west_gang.nan_do_chak.databinding.ActivityMainBindingImpl;
import kr.co.west_gang.nan_do_chak.databinding.ActivityPlanTimeBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYAVERAGEREADYTIME = 1;

  private static final int LAYOUT_ACTIVITYEARLYARRIVEDTIME = 2;

  private static final int LAYOUT_ACTIVITYMAIN = 3;

  private static final int LAYOUT_ACTIVITYPLANTIME = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.co.west_gang.nan_do_chak.R.layout.activity_average_ready_time, LAYOUT_ACTIVITYAVERAGEREADYTIME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.co.west_gang.nan_do_chak.R.layout.activity_early_arrived_time, LAYOUT_ACTIVITYEARLYARRIVEDTIME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.co.west_gang.nan_do_chak.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.co.west_gang.nan_do_chak.R.layout.activity_plan_time, LAYOUT_ACTIVITYPLANTIME);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYAVERAGEREADYTIME: {
          if ("layout/activity_average_ready_time_0".equals(tag)) {
            return new ActivityAverageReadyTimeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_average_ready_time is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYEARLYARRIVEDTIME: {
          if ("layout/activity_early_arrived_time_0".equals(tag)) {
            return new ActivityEarlyArrivedTimeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_early_arrived_time is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPLANTIME: {
          if ("layout/activity_plan_time_0".equals(tag)) {
            return new ActivityPlanTimeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_plan_time is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_average_ready_time_0", kr.co.west_gang.nan_do_chak.R.layout.activity_average_ready_time);
      sKeys.put("layout/activity_early_arrived_time_0", kr.co.west_gang.nan_do_chak.R.layout.activity_early_arrived_time);
      sKeys.put("layout/activity_main_0", kr.co.west_gang.nan_do_chak.R.layout.activity_main);
      sKeys.put("layout/activity_plan_time_0", kr.co.west_gang.nan_do_chak.R.layout.activity_plan_time);
    }
  }
}
