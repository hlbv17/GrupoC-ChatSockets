package chatSocketsGrupoC;

public interface MessageSocketClient {
    void onMessage(String response);

    void onServerClosed();
    void onLogout();
}
