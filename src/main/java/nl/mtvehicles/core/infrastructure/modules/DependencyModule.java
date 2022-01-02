package nl.mtvehicles.core.infrastructure.modules;

import lombok.Getter;
import lombok.Setter;
import nl.mtvehicles.core.Main;
import nl.mtvehicles.core.infrastructure.dependencies.VaultUtils;
import nl.mtvehicles.core.infrastructure.dependencies.WorldGuardUtils;

import java.util.ArrayList;
import java.util.List;

public class DependencyModule {
    private static @Getter
    @Setter
    DependencyModule instance;

    public static List<String> loadedDependencies = new ArrayList<>();
    public static WorldGuardUtils worldGuard;
    public static VaultUtils vault;

    public DependencyModule() {
        if (Main.instance.getServer().getPluginManager().getPlugin("WorldGuard") != null) {
            loadedDependencies.add("WorldGuard");
            worldGuard = new WorldGuardUtils();
        }
        if (Main.instance.getServer().getPluginManager().getPlugin("Vault") != null) {
            loadedDependencies.add("Vault");
            vault = new VaultUtils();
        }
    }

    public boolean isDependencyEnabled(String name){
        return loadedDependencies.contains(name);
    }
}
