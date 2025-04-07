package al.polis.appserver.communication;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ErrorContext {

    private final static ThreadLocal<List<ServerStatus>> listaStatus;

    static {
        listaStatus = new ThreadLocal<>();
    }

    public static void addStatusMessage(ServerErrorEnum error) {
        var status = new ServerStatus(error);
        var ls = listaStatus.get();
        if (ls == null) {
            ls = new ArrayList<>();
            listaStatus.set(ls);
        }

        ls.add(status);
        logTrace(status);
    }

    public static List<ServerStatus> readAndClean() {
        var lista = listaStatus.get();
        listaStatus.remove();
        if (lista == null) {
            lista = new ArrayList<>();
        }

        return lista;
    }

    private static void logTrace(ServerStatus ms) {
        log.info("Trace ID = " + ms);
    }

}
