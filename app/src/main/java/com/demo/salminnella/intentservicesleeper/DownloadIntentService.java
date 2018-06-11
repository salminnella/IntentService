package com.demo.salminnella.intentservicesleeper;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.ResultReceiver;
import android.util.Log;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class DownloadIntentService extends IntentService {
    // Actions this intent service will perform
    private static final String ACTION_DOWNLOAD_STRING = "com.demo.salminnella.intentservicesleeper.action.DOWNLOAD";
    private static final String ACTION_UPLOAD_STRING = "com.demo.salminnella.intentservicesleeper.action.UPLOAD";

    // Parameters for Actions
    private static final String EXTRA_PARAM1 = "PARAM1";
    private static final String EXTRA_PARAM2 = "PARAM2";

    // Status constants to be updated to calling Activity
    public static final int STATUS_RUNNING = 0;
    public static final int STATUS_FINISHED = 1;
    public static final int STATUS_ERROR = 2;

    private static final String TAG = "DownloadService";

    public DownloadIntentService() {
        super(DownloadIntentService.class.getName());
    }

    /**
     * Starts this service to perform either Actions, with the given parameters. If
     * the service is already performing a task, this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionDownload(Context context, String param1, String param2) {
        Intent intent = new Intent(context, DownloadIntentService.class);
        intent.setAction(ACTION_DOWNLOAD_STRING);
        intent.putExtra(EXTRA_PARAM1, param1);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionUpload(Context context, String param1, String param2) {
        Intent intent = new Intent(context, DownloadIntentService.class);
        intent.setAction(ACTION_UPLOAD_STRING);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        final ResultReceiver resultReceiver = intent.getParcelableExtra("receiver");

        FirebaseDatabase fbDatabase = FirebaseDatabase.getInstance();
        DatabaseReference fbRef = fbDatabase.getReference();

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_DOWNLOAD_STRING.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionDownload(param1, param2);
            } else if (ACTION_UPLOAD_STRING.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionUpload(param1, param2);
            }
        }

        Log.d(TAG, "Intent Service Stopping!");
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionDownload(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionUpload(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }




    public class DownloadException extends Exception {

        public DownloadException(String message) {
            super(message);
        }

        public DownloadException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
