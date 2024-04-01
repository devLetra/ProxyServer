package network.twisty.proxyserver.registry;

import network.twisty.proxyserver.ProxyPlugin;
import network.twisty.proxyserver.manager.Motd;
import network.twisty.proxyserver.manager.PostLogin;
import lombok.Data;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.PluginManager;

@Data(staticConstructor = "of")
public class ListenerRegistry {

    public ProxyPlugin plugin;

    public void register() {
            PluginManager pluginManager = ProxyServer.getInstance().getPluginManager();
            pluginManager.registerListener(
                    plugin,
                    new Motd()
            );
            pluginManager.registerListener(
                    plugin,
                    new PostLogin()
            );
    }

}
