package com.a;

import android.content.Context;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;
import java.util.HashMap;

public class MyNativeModules extends ReactContextBaseJavaModule {

    private Context context;
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public MyNativeModules(ReactApplicationContext reactContext) {
        super(reactContext);
        context = reactContext;
    }
//ReactContextBaseJavaModule要求派生类实现getName（）方法， 返回的是字符串名字，
// 这个名字在JavaScript端标记这个模块。注意：RN中已经内置了ToastAndroid的模块，所以练习时不要使用
    //这个名字否则会出错。

    @Override
    public String getName() {
        return "ToastExample";
    }
//Toast的show方法
     //要导出一个方法给JavaScript用，Java方法需要使用注解：@ReactMethod，返回类型必须为void
    // @ReactMethod
    // public void rnCallNative(String msg) {
    //     Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    // }

    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }
}
