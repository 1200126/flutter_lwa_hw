package com.github.ayvazj.flutter_lwa;

import android.content.Context;

import androidx.annotation.NonNull;

import com.amazon.identity.auth.device.api.workflow.RequestContext;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;

/**
 * LwaPlugin - Flutter plugin for Login with Amazon
 * Compatible with Flutter 3.7.2+
 */
public class LwaPlugin implements FlutterPlugin, ActivityAware {

    private MethodChannel methodChannel;
    private LwaMethodHandler methodHandler;
    private RequestContext requestContext;
    private Context applicationContext;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        applicationContext = binding.getApplicationContext();
        requestContext = RequestContext.create(applicationContext);

        methodChannel = new MethodChannel(
                binding.getBinaryMessenger(),
                "com.github.ayvazj/flutter_lwa"
        );
        methodHandler = new LwaMethodHandler(requestContext, applicationContext);
        methodChannel.setMethodCallHandler(methodHandler);
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
            methodChannel = null;
        }
        if (methodHandler != null) {
            methodHandler = null;
        }
        requestContext = null;
        applicationContext = null;
    }

    @Override
    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        // Update request context with Activity context for better lifecycle management
        requestContext = RequestContext.create(binding.getActivity().getApplicationContext());
        if (methodHandler != null && requestContext != null) {
            methodHandler.updateRequestContext(requestContext);
        }
    }

    @Override
    public void onDetachedFromActivityForConfigChanges() {
        // Called when Activity is destroyed for config changes
        // Request context will be updated in onReattachedToActivityForConfigChanges
    }

    @Override
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
        // Recreate request context after config changes
        requestContext = RequestContext.create(binding.getActivity().getApplicationContext());
        if (requestContext != null) {
            requestContext.onResume();
        }
        if (methodHandler != null && requestContext != null) {
            methodHandler.updateRequestContext(requestContext);
        }
    }

    @Override
    public void onDetachedFromActivity() {
        // Activity is detached, clean up Activity-specific resources
        requestContext = null;
    }
}
