package com.app.sport;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.app.sport.databinding.ActivityCompetitionBindingImpl;
import com.app.sport.databinding.ActivityMatchDetailBindingImpl;
import com.app.sport.databinding.ActivityTeamDetailBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCOMPETITION = 1;

  private static final int LAYOUT_ACTIVITYMATCHDETAIL = 2;

  private static final int LAYOUT_ACTIVITYTEAMDETAIL = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.sport.R.layout.activity_competition, LAYOUT_ACTIVITYCOMPETITION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.sport.R.layout.activity_match_detail, LAYOUT_ACTIVITYMATCHDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.sport.R.layout.activity_team_detail, LAYOUT_ACTIVITYTEAMDETAIL);
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
        case  LAYOUT_ACTIVITYCOMPETITION: {
          if ("layout/activity_competition_0".equals(tag)) {
            return new ActivityCompetitionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_competition is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMATCHDETAIL: {
          if ("layout/activity_match_detail_0".equals(tag)) {
            return new ActivityMatchDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_match_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTEAMDETAIL: {
          if ("layout/activity_team_detail_0".equals(tag)) {
            return new ActivityTeamDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_team_detail is invalid. Received: " + tag);
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
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/activity_competition_0", com.app.sport.R.layout.activity_competition);
      sKeys.put("layout/activity_match_detail_0", com.app.sport.R.layout.activity_match_detail);
      sKeys.put("layout/activity_team_detail_0", com.app.sport.R.layout.activity_team_detail);
    }
  }
}
