package xyz.fluxinc.homemanager.models;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class Home implements ConfigurationSerializable {

    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;
    private String worldName;

    public Home(double xCoordinate, double yCoordinate, double zCoordinate, String worldName) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
        this.worldName = worldName;
    }

    public Home(Map<String, Object> map) {
        xCoordinate = (double) map.get("x");
        yCoordinate = (double) map.get("y");
        zCoordinate = (double) map.get("z");
        worldName = (String) map.get("world");
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public double getzCoordinate() {
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
        map.put("x", xCoordinate);
        map.put("y", yCoordinate);
        map.put("z", zCoordinate);
        map.put("world", worldName);
        return map;
    }
}
