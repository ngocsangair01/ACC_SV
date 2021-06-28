package truongkaiyvo.pat.com.ecec.config;

import android.app.Application;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class ChatApplication extends Application {
    private Socket mSocket;
    {
        try
        {
            mSocket = IO.socket(Constants.URL_SOCKET_SEVER );
            mSocket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public  Socket getSocket(){
        return mSocket;
    }
}
