package com.kong.app.news.ui;

import android.os.Bundle;

import com.baselib.utlis.ResourceUtil;
import com.kong.R;
import com.kong.app.news.base.ToolBarActivity;
import com.kong.app.news.fragment.SettingFragment;

/**
 * Created by CaoPengfei on 17/6/17.
 */

public class SettingActivity extends ToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(ResourceUtil.getString(R.string.settings));
        replace();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }

//    public static int getThemeColor(Context context, int attrRes) {
//        TypedArray typedArray = context.obtainStyledAttributes(new int[]{attrRes});
//        int color = typedArray.getColor(0, 0xffffff);
//        typedArray.recycle();
//        return color;
//    }

//    @Override
//    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int selectedColor) {
//        if (selectedColor == getThemeColor(this, R.attr.colorPrimary))
//            return;
//        getToolbar().setBackgroundColor(selectedColor);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(selectedColor);
//        }
//        if (selectedColor == ResourceUtil.getColor(R.color.lapis_blue)) {
//            setTheme(R.style.LapisBlueTheme);
//            SettingsUtil.setThemeIndex(0);
//        } else if (selectedColor == ResourceUtil.getColor(R.color.pale_dogwood)) {
//            setTheme(R.style.PaleDogwoodTheme);
//            SettingsUtil.setThemeIndex(1);
//        } else if (selectedColor == ResourceUtil.getColor(R.color.greenery)) {
//            setTheme(R.style.GreeneryTheme);
//            SettingsUtil.setThemeIndex(2);
//        } else if (selectedColor == ResourceUtil.getColor(R.color.primrose_yellow)) {
//            setTheme(R.style.PrimroseYellowTheme);
//            SettingsUtil.setThemeIndex(3);
//        } else if (selectedColor == ResourceUtil.getColor(R.color.flame)) {
//            setTheme(R.style.FlameTheme);
//            SettingsUtil.setThemeIndex(4);
//        } else if (selectedColor == ResourceUtil.getColor(R.color.island_paradise)) {
//            setTheme(R.style.IslandParadiseTheme);
//            SettingsUtil.setThemeIndex(5);
//        } else if (selectedColor == ResourceUtil.getColor(R.color.kale)) {
//            setTheme(R.style.KaleTheme);
//            SettingsUtil.setThemeIndex(6);
//        } else if (selectedColor == ResourceUtil.getColor(R.color.pink_yarrow)) {
//            setTheme(R.style.PinkYarrowTheme);
//            SettingsUtil.setThemeIndex(7);
//        } else if (selectedColor == ResourceUtil.getColor(R.color.niagara)) {
//            setTheme(R.style.NiagaraTheme);
//            SettingsUtil.setThemeIndex(8);
//        } else if (selectedColor == ResourceUtil.getColor(R.color.white)) {
//            setTheme(R.style.WhiteTheme);
//            SettingsUtil.setThemeIndex(9);
//        }
//        EventBus.getDefault().post(new ThemeChangedEvent(selectedColor));
//        replace();
//    }

    private void replace(){
        getFragmentManager().beginTransaction().replace(R.id.settings_content, SettingFragment.newInstance()).commit();
    }
}
