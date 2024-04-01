package network.twisty.proxyserver.commands;

import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.net.Socket;

public class LobbyCommand {
    @Command(
            name = "lobby",
            aliases = "hub"
    )
    public void handleLobbyCommand(Context<ProxiedPlayer> context) {

        ServerInfo lobby = ProxyServer.getInstance().getServerInfo("lobby");

        if (context.getSender().getServer().getInfo().equals(lobby)) {
            context.sendMessage("§cVocê já está conectado no lobby.");
            return;
        }

        context.getSender().connect(ProxyServer.getInstance().getServerInfo("lobby"));

        context.sendMessage("§aConectando ao lobby...");
    }
}