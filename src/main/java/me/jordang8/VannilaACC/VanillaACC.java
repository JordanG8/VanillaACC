package me.jordang8.VannilaACC;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

public class VanillaACC extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
        }

        int bStatsId = -1;
        new Metrics(this, bStatsId);

        ItemStack categoryItem = new CustomItem(Material.DIAMOND, "&4Addon Category", "", "&a> Click to open");

        NamespacedKey categoryId = new NamespacedKey(this, "addon_category");
        Category category = new Category(categoryId, categoryItem);

        SlimefunItemStack slimefunItem = new SlimefunItemStack("COOL_DIAMOND", Material.DIAMOND, "&4Cool Diamond", "&c+20% Coolness");

      
        ItemStack[] recipe = { new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD), null, new ItemStack(Material.DIAMOND), null, new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD) };

     
        SlimefunItem item = new SlimefunItem(category, slimefunItem, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(this);
    }

    @Override
    public void onDisable() {
        
    }

    @Override
    public String getBugTrackerURL() {

        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}
