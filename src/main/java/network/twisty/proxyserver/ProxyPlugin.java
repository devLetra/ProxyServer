package network.twisty.proxyserver;

import network.twisty.proxyserver.configuration.manager.ConfigurationManager;
import network.twisty.proxyserver.registry.CommandRegistry;
import network.twisty.proxyserver.registry.ListenerRegistry;
import network.twisty.proxyserver.utils.MaintenanceUtils;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;

public class ProxyPlugin extends Plugin {

    public static ProxyPlugin instance;
    public static ConfigurationManager configurationManager;

    public void onEnable() {
        System.out.println("[Proxy] Habilitado com sucesso.");
        ServerInfo server = ProxyServer.getInstance().getServerInfo("lobby");
        registerAll();
        MaintenanceUtils.Motd=false;
        ProxyPlugin.instance = this;
        ProxyPlugin.configurationManager = new ConfigurationManager();
        super.onEnable();
    }

    public void onDisable() {
        System.out.println("[Proxy] Desabilitado com sucesso.");
        instance = null;
    }

    public static ProxyPlugin getInstance() {
        return ProxyPlugin.instance;
    }

    public void registerAll() {
        CommandRegistry.of().register();
        ListenerRegistry.of().register();
    }
}
