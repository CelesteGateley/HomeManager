package xyz.fluxinc.homemanager.models;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Home implements ConfigurationSerializable {

    private OfflinePlayer player;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;
    private String worldName;

    public Home(Player player, double xCoordinate, double yCoordinate, double zCoordinate, String worldName) {
        this.player = player;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
        this.worldName = worldName;
    }

    public Home(Map<String, Object> map) {
        OfflinePlayer temp = Bukkit.getServer().getOfflinePlayer(UUID.fromString((String) map.get("player")));
        player = temp.getPlayer() != null ? temp.getPlayer() : temp;
        xCoordinate = (double) map.get("x");
        yCoordinate = (double) map.get("y");
        zCoordinate = (double) map.get("z");
        worldName = (String) map.get("world");
    }

    public double getX() { return xCoordinate; }

    public double getY() {
        return yCoordinate;
    }

    public double getZ() {
        return zCoordinate;
    }

    public String getWorldName() {
        return worldName;
    }

    public World getWorld() {
        return Bukkit.getServer().getWorld(worldName);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("player", player.getUniqueId().toString());
        map.put("x", xCoordinate);
        map.put("y", yCoordinate);
        map.put("z", zCoordinate);
        map.put("world", worldName);
        return map;
    }
}
