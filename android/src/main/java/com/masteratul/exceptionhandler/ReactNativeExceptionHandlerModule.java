
package com.masteratul.exceptionhandler;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class ReactNativeExceptionHandlerModule extends ReactContextBaseJavaModule {

  private ReactApplicationContext reactContext;
    private Activity activity;
    private Callback callbackHolder;

    public ReactNativeExceptionHandlerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "ReactNativeExceptionHandler";
  }


  @ReactMethod
  public void setHandlerforNativeException(Callback customHandler){
      callbackHolder = customHandler;
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
          @Override
          public void uncaughtException(Thread thread, Throwable throwable) {
              activity = getCurrentActivity();
              String stackTraceString = Log.getStackTraceString(throwable);
              callbackHolder.invoke(stackTraceString);
              Log.d("ERROR",stackTraceString);
              System.exit(0);
          }
      });
  }

   public static void replaceErrorScreenActivityClass(Class errorScreenActivityClass){
       errorIntentTargetClass = errorScreenActivityClass;
   }
}
