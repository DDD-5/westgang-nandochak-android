package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new kr.co.west_gang.nan_do_chak.DataBinderMapperImpl());
  }
}
