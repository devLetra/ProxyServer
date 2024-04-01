package network.twisty.proxyserver.configuration.manager;

import network.twisty.proxyserver.ProxyPlugin;
import network.twisty.proxyserver.configuration.YamlConfig;
import net.md_5.bungee.config.*;

import java.io.*;

public class ConfigurationManager
{
    protected static YamlConfig config;
    public static Configuration configuration;

    public ConfigurationManager() {
        ConfigurationManager.config = null;
        try {
            (ConfigurationManager.config = new YamlConfig("config.yml", ProxyPlugin.getInstance())).saveDefaultConfig();
            ConfigurationManager.config.loadConfig();
            ConfigurationManager.configuration = ConfigurationManager.config.getConfig();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void saveConfig() {
        try {
            ConfigurationManager.config.saveConfig();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
