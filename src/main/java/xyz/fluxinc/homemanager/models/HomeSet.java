package xyz.fluxinc.homemanager.models;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HomeSet {

    private List<Home> homes;

    public HomeSet() {
        homes = new ArrayList<>();
    }

    public HomeSet addHome(Home home) {
        homes.add(home);
        return this;
    }

    public HomeSet addHome(Player player) {
        homes.add(new Home(player, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getWorld().getName()));
        return this;
    }

    public HomeSet addHome(Player player, Location location) {
        homes.add(new Home(player, location.getX(), location.getY(), location.getZ(), location.getWorld().getName()));
        return this;
    }

    public List<Home> getHomes() {
        return this.homes;
    }
}
