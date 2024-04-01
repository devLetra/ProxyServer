package network.twisty.proxyserver.manager;

import network.twisty.proxyserver.configuration.manager.ConfigurationManager;
import network.twisty.proxyserver.utils.MaintenanceUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Motd implements Listener {

    @EventHandler(priority = 64)
    public void onPing(ProxyPingEvent event) {
        if(MaintenanceUtils.Motd==false) {
            ServerPing ping = event.getResponse();
            String motd = ChatColor.translateAlternateColorCodes('&', ConfigurationManager.configuration.getString("motd"));
            ping.setDescription(motd);
            event.setResponse(ping);
        }
        if(MaintenanceUtils.Motd==true) {
            ServerPing ping = event.getResponse();
            ServerPing.Protocol protocol = ping.getVersion();
            protocol.setName("§4MANUTENÇÃO");
            protocol.setProtocol(29000);
            ping.setVersion(protocol);
            String motd = ChatColor.translateAlternateColorCodes('&', ConfigurationManager.configuration.getString("motd-manu"));
            ping.setDescription(motd);
        }
    }
}
