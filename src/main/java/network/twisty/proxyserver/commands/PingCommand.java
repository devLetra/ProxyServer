package network.twisty.proxyserver.commands;

import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class PingCommand  {
    @Command(
            name = "ping",
            aliases = {"pong"}
    )
    public void handlePing(Context<CommandSender> context) {
        ProxiedPlayer player = (ProxiedPlayer) context.getSender();
        StringBuilder builder = new StringBuilder();
        builder.append(" §8➟ §fSeu ping atual é: §7" + player.getPing());
        context.sendMessage(builder.toString());
    }
}
