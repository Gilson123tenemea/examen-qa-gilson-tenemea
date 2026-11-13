package com.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target PRODUCTO =
            Target.the("producto {0}").locatedBy("//a[@class='hrefch' and text()='{0}']");

    public static final Target MENU_HOME =
            Target.the("menú Home").locatedBy("//a[contains(@class,'nav-link') and contains(.,'Home')]");

    public static final Target MENU_CARRITO =
            Target.the("menú Cart").locatedBy("#cartur");

    private HomePage() {
    }
}