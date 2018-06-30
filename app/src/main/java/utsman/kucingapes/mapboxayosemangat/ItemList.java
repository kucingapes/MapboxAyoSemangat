package utsman.kucingapes.mapboxayosemangat;

public class ItemList {
    public String title, subtitle;

    public ItemList(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public ItemList() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
