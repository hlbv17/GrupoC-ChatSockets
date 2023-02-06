package chatSocketsGrupoC;

public interface MessageSocketServer {
    void onJoin(String name);
    void onLeave(String name);
    void log(String message);

}
