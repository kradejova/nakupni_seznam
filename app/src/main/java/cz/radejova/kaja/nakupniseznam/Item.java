package cz.radejova.kaja.nakupniseznam;

public class Item {
    private String title;
    private String count;

    public Item(String title, String count) {
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public String getCount() {
        return count;
    }
}
