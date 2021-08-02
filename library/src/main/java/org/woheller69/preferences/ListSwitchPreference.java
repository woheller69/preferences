package org.woheller69.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;

public class ListSwitchPreference extends ListPreference {
    private String SwitchKey;
    private boolean SwitchKeyDefaultValue;
    private boolean switchAttached=false;

    public ListSwitchPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs,defStyleAttr,defStyleRes);
        initAttrs(context,attrs);
    }

    public ListSwitchPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs,defStyleAttr);
        initAttrs(context,attrs);
    }

    public ListSwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context,attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs){
        SwitchKey=null;
        SwitchKeyDefaultValue=false;
        TypedArray valueArray;
        if(attrs != null)
        {
            valueArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SwitchPreferences, 0, 0);
            SwitchKey = valueArray.getString(R.styleable.SwitchPreferences_SwitchKey);
            SwitchKeyDefaultValue = valueArray.getBoolean(R.styleable.SwitchPreferences_SwitchKeyDefaultValue,false);
            valueArray.recycle();
        }
    }
    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        final ViewGroup rootView;
        final SwitchCompat onOffSwitch;
        final CompoundButton.OnCheckedChangeListener checkedChangeListener;
        super.onBindViewHolder(holder);
        rootView = (ViewGroup)holder.itemView;
        if (!switchAttached&&(SwitchKey!=null)){
            onOffSwitch=new SwitchCompat(getContext());
            rootView.addView(onOffSwitch);
            switchAttached=true;
            onOffSwitch.setChecked(sp.getBoolean(SwitchKey,SwitchKeyDefaultValue));
            checkedChangeListener = (buttonView, isChecked) -> {
                if(SwitchKey != null)
                {
                    sp.edit().putBoolean(SwitchKey, isChecked).apply();
                }
            };
            onOffSwitch.setOnCheckedChangeListener(checkedChangeListener);
            checkedChangeListener.onCheckedChanged(onOffSwitch, onOffSwitch.isChecked());
        }
    }
}
