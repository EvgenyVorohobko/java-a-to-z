package by.vorokhobko.Templates;

import by.vorokhobko.AbstractClasses.Input;
import by.vorokhobko.Encapsulation.start.Tracker;
import by.vorokhobko.AbstractClasses.UserAction;

public abstract class BaseAction implements UserAction {
    // так создается конструктор в абсрактном классе.
    public String name;

    public BaseAction(String name) {
        this.name = name;
    }

    public abstract int key();

    public abstract void execute(Input input, Tracker tracker);

    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}