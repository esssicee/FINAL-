import config.AppConfig;
import view.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = AppConfig.initMainMenu();
        mainMenu.tampilkan();
    }
}
