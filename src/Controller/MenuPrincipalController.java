package Controller;

import View.Agenda;
import View.MenuPrincipal;
import java.sql.SQLException;
import java.text.ParseException;

public class MenuPrincipalController {
    
    private final MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
    
    
    public void navegarParaAgenda() throws SQLException, ParseException{
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
    }
    
}