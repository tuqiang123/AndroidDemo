package com.tu_qi.androiddemo.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

public class IntentServiceTestService extends IntentService {
    private static final String ACTION_ADD = "com.tu_qi.androiddemo.service.action.ADD";
    private static final String ACTION_MINUS = "com.tu_qi.androiddemo.service.action.MINUS";

    private static final String EXTRA_OP1 = "com.tu_qi.androiddemo.service.extra.OP1";
    private static final String EXTRA_OP2 = "com.tu_qi.androiddemo.service.extra.OP2";

    private static final String TAG = "IntentService";

    public IntentServiceTestService() {
        super("IntentServiceTestService");
    }

    public static void startActionAdd(Context context, int op1, int op2) {
        Intent intent = new Intent(context, IntentServiceTestService.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_OP1, op1);
        intent.putExtra(EXTRA_OP2, op2);
        context.startService(intent);
    }

    public static void startActionMinus(Context context, int op1, int op2) {
        Intent intent = new Intent(context, IntentServiceTestService.class);
        intent.setAction(ACTION_MINUS);
        intent.putExtra(EXTRA_OP1, op1);
        intent.putExtra(EXTRA_OP2, op2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final int op1 = intent.getIntExtra(EXTRA_OP1, 0);
                final int op2 = intent.getIntExtra(EXTRA_OP2, 0);
                handleActionAdd(op1, op2);
            } else if (ACTION_MINUS.equals(action)) {
                final int op1 = intent.getIntExtra(EXTRA_OP1, 0);
                final int op2 = intent.getIntExtra(EXTRA_OP2, 0);
                handleActionMinus(op1, op2);
            }
        }
    }

    private void handleActionAdd(int op1, int op2) {
        Log.d(TAG, "Add start and sleep 2s");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, op1 + " + " + op2 + " = " + (op1 + op2));
    }

    private void handleActionMinus(int op1, int op2) {
        Log.d(TAG, "Minus start and sleep 2s");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, op1 + " - " + op2 + " = " + (op1 - op2));
    }
}
