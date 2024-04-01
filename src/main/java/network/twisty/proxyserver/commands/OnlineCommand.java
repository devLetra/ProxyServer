package network.twisty.proxyserver.commands;

import lombok.AllArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;

import java.util.Map;

@AllArgsConstructor
public class OnlineCommand {
    @Command(
        name = "online"
    )
    public void handleOnline(Context<CommandSender> context) {
        StringBuilder servers = new StringBuilder();
        int allPlayers = ProxyServer.getInstance().getOnlineCount();
        servers.append("\n")
                .append(" §eServidores e seus respectivos jogadores:")
                .append("\n")
                .append("\n")
                .append(" §c❤ §fTotal: §7" + allPlayers)
                .append("\n");

        Map<String, ServerInfo> allservers = ProxyServer.getInstance().getServers();
        for(ServerInfo server : allservers.values()){
            servers.append("\n")
                    .append("§8 ➟§f " + server.getName().replace("-", " ") + ": §7" + server.getPlayers().size() + ".")
                    .append("\n");
        }
        servers.append(" ");
        context.sendMessage(servers.toString());
    }

}
