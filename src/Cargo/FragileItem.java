package Cargo;

public class FragileItem extends BaseCargo {
    private boolean requiresSpecialHandling;

    public FragileItem(String id, String name, double weight, boolean requiresSpecialHandling) {
        super(id, name, weight);
        this.requiresSpecialHandling = requiresSpecialHandling;
    }

    public boolean isRequiresSpecialHandling() {
        return requiresSpecialHandling;
    }

    @Override
    public String getType() {
        return super.getType() + (requiresSpecialHandling ? " (Хрупкое, спец. обработка)" : " (Хрупкое)");
    }
}