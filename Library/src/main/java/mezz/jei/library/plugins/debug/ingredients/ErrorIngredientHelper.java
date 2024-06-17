package mezz.jei.library.plugins.debug.ingredients;

import mezz.jei.api.constants.ModIds;
import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class ErrorIngredientHelper implements IIngredientHelper<ErrorIngredient> {
	@Override
	public IIngredientType<ErrorIngredient> getIngredientType() {
		return ErrorIngredient.TYPE;
	}

	@Override
	public String getDisplayName(ErrorIngredient ingredient) {
		return "JEI Error Item #" + ingredient.getCrashType();
	}

	@Override
	public String getUniqueId(ErrorIngredient ingredient, UidContext context) {
		return "JEI_error_" + ingredient.getCrashType();
	}

	@Override
	public ResourceLocation getResourceLocation(ErrorIngredient ingredient) {
		return ResourceLocation.fromNamespaceAndPath(ModIds.JEI_ID, "error_" + ingredient.getCrashType().toString().toLowerCase(Locale.ROOT));
	}

	@Override
	public ErrorIngredient copyIngredient(ErrorIngredient ingredient) {
		return ingredient;
	}

	@Override
	public String getErrorInfo(@Nullable ErrorIngredient ingredient) {
		if (ingredient == null) {
			return "error ingredient: null";
		}
		return getDisplayName(ingredient);
	}
}
