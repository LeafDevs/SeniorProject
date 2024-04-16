package me.leaf.devs.entities;

public enum Skins {
    KING("ewogICJ0aW1lc3RhbXAiIDogMTcwNDQ2Mzk2NjQyOSwKICAicHJvZmlsZUlkIiA6ICJkZDNjZGJiOTE2M2Q0NzgyOGQ0YmZkODZmYWE4NGY5ZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJFTFdhbEtlUkpBSkEiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWZiZmU5OGY4ZjU1MDNlYTg2YjM3ZjI4NmIyYWI5ZmUyY2I4MmY2MjQxOGZlZGVmMWExMGFhNTVmYzUwZjc0IgogICAgfQogIH0KfQ==", "OMASTX6FXPtRVLcFRHu7abURNl7n+R+Ls4Eb8cZazLfKqxszeXGobHkvT6gJS7M6IxLy831pm3lzhHBs5r11v9g9jvyZrpPWwAyxtBllYW+97TurjPmlvsLrF3LX6SPBgIpWPdOHL7IqOOQJ7WAGfx0mWwgrKQziD58tzZuqvbvU/JzvIy3QfX+p34fTMe5KnhoWV3Z54Oejjd4bK0ov8o3QgP2LF+zITT9TQTt9k2pnmAdAoGu/JsLeilEbtJ7974292lg/noJUWkGPwgwRYqfxxiYFz9hd6FX9wVzu5JkeKTF3YW7CeJ+eKfccV6XJ9KbsnpVToUtZOHMEnh1prYiJ9pngCSbFN7RGNTL/020YVX1getCasmZ4tp5nP3t58KmdGgRVqSrTY5p3VL7wRi0pMH2dk8jW3ZFB5RAEwYKCHMI1wwMJL+sQjIjMCE85KySn7MI9l/nEOgeTM+s7MI24fx65bhTM1SFSkORyzYTTiXrMdotGJodmtyAt/knuDJ31srf2rE7DtLUJm03zh0khiuCzx6SIJIdwyo0bMvIqS1OoD/6lUmyWPgJwFlX1VHn7zdhsma/0TsyB3u9ecy6qqVqEndCcCJRnLwx5E51FQwMwz1z4yrmRkGqrHOdw3XRYTtT9nz4Y3p/5sOlgNoCE1TzZYaB+oElon5G/624=")


    ;

    private String texture, signature;

    Skins(String texture, String signature) {
        this.texture = texture;
        this.signature = signature;
    }

    public String getTexture() {
        return texture;
    }

    public String getSignature() {
        return signature;
    }

    public Skin asSkin() {
        return new Skin("Steve", this.texture, this.signature);
    }
}
