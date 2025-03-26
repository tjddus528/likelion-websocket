package com.inspire12.likelionwebsocket.holder;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class WebsocketSessionHolder {
  // handler -> session에 대한 관리를 위임하겠다...!
  // holder -> static 구조
  public static final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

  public static void addSession(WebSocketSession session) {
    sessions.add(session);
  }
  public static void removeSession(WebSocketSession session) {
    sessions.remove(session);
  }
  public static Set<WebSocketSession> getSession() {
    return sessions;
  }
}
