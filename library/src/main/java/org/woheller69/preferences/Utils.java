package org.woheller69.preferences;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Base64;

public class Utils {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String apiKey(String key){
        Base64.Decoder dec = Base64.getDecoder();
        return new String(dec.decode(key));
    }
}
