package network.twisty.proxyserver.commands;

import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class FindCommand {
    @Command(
            name = "find",
            permission = "world.staff.admin",
            usage = "find [jogador]"
    )
    public void handleFind(Context<CommandSender> context, String[] args) {
        val sender = (CommandSender) context.getSender();
        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage("§cJogador offline.");
        } else {
            StringBuilder find = new StringBuilder();
            find.append("\n")
                    .append("§e Este jogador encontra-se:")
                    .append("\n")
                    .append("\n")
                    .append(" §8➟ §fJogador: §7" + player.getName())
                    .append("\n")
                    .append(" §8➟ §fServidor localizado: §7" + player.getServer().getInfo().getName().replace("-", ""))
                    .append("\n");

            sender.sendMessage(find.toString());
        }
    }
}
