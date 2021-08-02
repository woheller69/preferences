# Preferences

<img src="EditTextSwitchPreference.png" width="300"/>

[![](https://jitpack.io/v/woheller69/preferences.svg)](https://jitpack.io/#woheller69/preferences)

## Usage

Add the JitPack repository to your root build.gradle at the end of repositories:

```xml
   	allprojects {
    	repositories {
    		...
    		maven { url 'https://jitpack.io' }
    	}
    }
````

Add the dependency at the app level:
```xml
	dependencies {
	        implementation 'com.github.woheller69:preferences:1.0'
	}
````

Reference namespace on top of your layout file:
```xml
    xmlns:app="http://schemas.android.com/apk/res-auto">
````

Now you can use this view in your preferences layout, just like any other normal preference
```xml
    <org.woheller69.preferences.EditTextSwitchPreference
            android:selectable="true"
            app:useSimpleSummaryProvider="true"
            android:key="yourPrefKey"
            app:SwitchKey="yourPrefKeyForSwitch"
            app:SwitchKeyDefaultValue="true"
            android:defaultValue="yourDefaultValue"
            android:icon="yourIcon"
            android:title="yourTitle"/>
````
```xml
    <org.woheller69.preferences.ListSwitchPreference
            android:selectable="true"
            app:useSimpleSummaryProvider="true"
            android:key="yourPrefKey"
            app:SwitchKey="yourPrefKeyForSwitch"
            app:SwitchKeyDefaultValue="true"
            android:defaultValue="yourDefaultValue"
            android:icon="yourIcon"
            android:title="yourTitle"/>
````
