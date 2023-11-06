package ch.mse.app.types;

public class CompoundTypes {
    class Component{}
    class Point{}

    interface Container { // controls graphical objects (components)
        void add(Component c, Point pos);
        void foo(Container c);
    }

    interface TextEditor { // interface for a text editor
        void insert(char ch, int pos);
        Point coordinates(int pos);
        void foo(TextEditor c);
    }

    public <T extends TextEditor & Container> void insertComponent(
                                            T obj, Component c, int pos) {
        var point = obj.coordinates(pos);
        obj.add(c, point);

        obj.foo((Container)obj);
    }

}
