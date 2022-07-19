package lts.exampleapp.xcoverkey;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.samsung.android.knox.*;
import com.samsung.android.knox.custom.CustomDeviceManager;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final int KEYCODE_PTT = 1015;

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if ("com.samsung.android.knox.intent.action.HARD_KEY_REPORT".equals(intentAction)) {
            int keyCode = intent.getIntExtra(CustomDeviceManager.EXTRA_KEY_CODE, -1);
            int keyReportType = intent.getIntExtra(CustomDeviceManager.EXTRA_REPORT_TYPE, -1);
            if (keyCode == KEYCODE_PTT && keyReportType == 1) {
                Toast.makeText(context, "XCover Key pressed!", Toast.LENGTH_SHORT).show();
                Log.println(Log.ERROR,"Xcover Key:","XCover Key Pressed!");
            }
            else if (keyCode == KEYCODE_PTT && keyReportType == 2) {
                Toast.makeText(context, "XCover Key released!", Toast.LENGTH_SHORT).show();
                Log.println(Log.ERROR,"Xcover Key:","XCover Key Released!");
            }
        }
    }
}
