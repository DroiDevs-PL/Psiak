package com.example.android.psiak.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

import com.example.android.psiak.R;

/**
 * Created by Maciej Bialorucki on 01.02.18.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener{
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.prefs);

        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        PreferenceScreen preferenceScreen = getPreferenceScreen();

        for(int i = 0 ; i < preferenceScreen.getPreferenceCount() ; i++){
            Preference preference = preferenceScreen.getPreference(i);
            //if you add other type of preference this method should be change
            String value = sharedPreferences.getString(preference.getKey(),"");
            setPreferenceSummary(preference,value);
        }

        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    private void setPreferenceSummary(Preference preference, String value){
        if(preference instanceof ListPreference){
            ListPreference listPreference = (ListPreference)preference;
            int prefIndex = listPreference.findIndexOfValue(value);
            if(prefIndex >= 0){
                listPreference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        if(preference != null){
            //if you add other type of preferences this method must be changed
            String value = sharedPreferences.getString(preference.getKey(),"");
            setPreferenceSummary(preference,value);
        }
    }
}
