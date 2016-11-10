package meterial_design;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Monkey
 * on 2016/11/1.
 */

public class DownServer extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 0;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
