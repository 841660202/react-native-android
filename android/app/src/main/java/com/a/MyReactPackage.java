package com.a;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// 这个package需要在MainApplication.java文件的getPackages方法中提供。
// 这个文件位于你的react-native应用文件夹的android目录中。具体路径是: android/app/src/main/java/com/your-app-name/MainApplication.java.
public class MyReactPackage implements ReactPackage {
    
    //把我们要导出的模块放在modules中
    //注册这个模块。我们需要在应用的Package类的createNativeModules方法中添加这个模块。如果模块没有被注册，它也无法在JavaScript中被访问到。
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new MyNativeModules(reactContext));
        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}
