package me.deecaad.weaponmechanics.mechanics;

import me.deecaad.core.file.SerializeData;
import me.deecaad.core.file.SerializerException;
import me.deecaad.core.mechanics.CastData;
import me.deecaad.core.mechanics.conditions.Condition;
import me.deecaad.weaponmechanics.WeaponMechanics;
import me.deecaad.weaponmechanics.wrappers.EntityWrapper;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SwimmingCondition extends Condition {

    /**
     * Default constructor for serializer.
     */
    public SwimmingCondition() {
    }

    @Override
    protected boolean isAllowed0(CastData cast) {
        if (cast.getTarget() == null)
            return false;
        EntityWrapper wrapper = WeaponMechanics.getInstance().getEntityWrapper(cast.getTarget(), true);

        return wrapper != null && wrapper.isSwimming();
    }

    @Override
    public @NotNull NamespacedKey getKey() {
        return new NamespacedKey(WeaponMechanics.getInstance(), "swimming");
    }

    @Override
    public @Nullable String getWikiLink() {
        return "https://cjcrafter.gitbook.io/mechanics/integrations/weaponmechanics#swimming";
    }

    @NotNull @Override
    public Condition serialize(@NotNull SerializeData data) throws SerializerException {
        return applyParentArgs(data, new SwimmingCondition());
    }
}
