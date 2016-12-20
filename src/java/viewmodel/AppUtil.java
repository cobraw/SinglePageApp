package viewmodel;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class AppUtil {

    public static Desktop getController() {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        Application application = FacesContext.getCurrentInstance().getApplication();
        ExpressionFactory expressionFactory = application.getExpressionFactory();
        ValueExpression ve = expressionFactory.createValueExpression(elContext, "#{desktop}", Desktop.class);
        Desktop desktop = (Desktop) ve.getValue(elContext);
        return desktop;
    }

    public static HttpSession getSession() {
        ExternalContext extCon = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) extCon.getSession(true);
        return session;
    }
}
