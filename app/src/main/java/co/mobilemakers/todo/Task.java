package co.mobilemakers.todo;

/**
 * Created by gonzalo.lodi on 04/02/2015.
 */
public class Task {

    String name;
    Boolean done;

    public Task(String name, Boolean done) {
        this.name = name;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
