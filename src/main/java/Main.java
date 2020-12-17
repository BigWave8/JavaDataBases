import com.oryshchak.manager.SessionManager;
import com.oryshchak.view.View;

public class Main {
  public static void main(final String[] args) {
    SessionManager.openSessionFactory();
    new View().show();
    SessionManager.closeSessionFactory();
  }
}