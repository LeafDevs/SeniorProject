package me.leaf.devs.entities.traits;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import net.citizensnpcs.Settings.Setting;
import net.citizensnpcs.api.persistence.Persist;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.trait.TraitName;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.api.util.Messaging;
import net.citizensnpcs.api.util.Placeholders;
import net.citizensnpcs.npc.skin.Skin;
import net.citizensnpcs.npc.skin.SkinnableEntity;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@TraitName("skintrait")
public class SkinTrait extends Trait {
   @Persist
   private boolean fetchDefaultSkin;
   private String filledPlaceholder;
   @Persist
   private String signature;
   @Persist
   private String skinName;
   @Persist
   private String textureRaw;
   private int timer;
   @Persist
   private boolean updateSkins;

   public SkinTrait() {
      super("skintrait");
      this.fetchDefaultSkin = Setting.NPC_SKIN_FETCH_DEFAULT.asBoolean();
      this.updateSkins = Setting.NPC_SKIN_USE_LATEST.asBoolean();
   }

   private void checkPlaceholder(boolean update) {
      if (this.skinName != null) {
         String filled = ChatColor.stripColor(Placeholders.replace(this.skinName, (CommandSender)null, this.npc).toLowerCase());
         if (!filled.equalsIgnoreCase(this.skinName) && !filled.equalsIgnoreCase(this.filledPlaceholder)) {
            this.filledPlaceholder = filled;
            Messaging.debug(new Object[]{"Filled skin placeholder", filled, "from", this.skinName});
            if (update) {
               this.onSkinChange(true);
            }
         }

      }
   }

   public void clearTexture() {
      this.textureRaw = null;
      this.signature = null;
      this.skinName = null;
   }

   public boolean fetchDefaultSkin() {
      return this.fetchDefaultSkin;
   }

   public String getSignature() {
      return this.signature;
   }

   public String getSkinName() {
      return this.filledPlaceholder != null && this.skinName != null ? this.filledPlaceholder : (this.skinName == null ? this.skinName : this.skinName.toLowerCase());
   }

   public String getTexture() {
      return this.textureRaw;
   }

   public void load(DataKey key) {
      this.checkPlaceholder(false);
   }

   private void onSkinChange(boolean forceUpdate) {
      if (this.npc.isSpawned() && this.npc.getEntity() instanceof SkinnableEntity) {
         ((SkinnableEntity)this.npc.getEntity()).getSkinTracker().notifySkinChange(forceUpdate);
      }

   }

   public void run() {
      if (this.timer-- <= 0) {
         this.timer = Setting.PLACEHOLDER_SKIN_UPDATE_FREQUENCY.asTicks();
         this.checkPlaceholder(true);
      }
   }

   public void setFetchDefaultSkin(boolean fetch) {
      this.fetchDefaultSkin = fetch;
   }

   public void setShouldUpdateSkins(boolean update) {
      this.updateSkins = update;
   }

   public void setSkinName(String name) {
      this.setSkinName(name, false);
   }

   public void setSkinName(String name, boolean forceUpdate) {
      Preconditions.checkNotNull(name);
      this.setSkinNameInternal(name);
      this.onSkinChange(forceUpdate);
   }

   private void setSkinNameInternal(String name) {
      this.skinName = ChatColor.stripColor(name);
      this.checkPlaceholder(false);
   }

   public void setSkinPersistent(String skinName, String signature, String data) {
      Preconditions.checkNotNull(skinName);
      Preconditions.checkNotNull(signature);
      Preconditions.checkNotNull(data);
      this.setSkinNameInternal(skinName);
      String json = new String(BaseEncoding.base64().decode(data), Charsets.UTF_8);
      if (!json.contains("textures")) {
         throw new IllegalArgumentException("Invalid texture data");
      } else {
         this.signature = signature;
         this.textureRaw = data;
         this.updateSkins = false;
         this.npc.data().setPersistent(Skin.CACHED_SKIN_UUID_NAME_METADATA, skinName.toLowerCase());
         this.onSkinChange(false);
      }
   }

   public void setSkinPersistent(me.leaf.devs.entities.Skin skin) {
    setSkinPersistent(skin.getName(), skin.getSigniture(), skin.getTexture());
 }

   public void setTexture(String value, String signature) {
      this.textureRaw = value;
      this.signature = signature;
   }

   public boolean shouldUpdateSkins() {
      return this.updateSkins;
   }
}
