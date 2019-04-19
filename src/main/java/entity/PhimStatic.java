package entity;

public class PhimStatic {
    private String id;
    private String name;
    private int view;

    public PhimStatic(String id, String name, int view) {
        this.id = id;
        this.name = name;
        this.view = view;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
