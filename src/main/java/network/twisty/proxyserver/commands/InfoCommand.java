package network.twisty.proxyserver.commands;

import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class InfoCommand {
    @Command(
            name = "info",
            permission = "world.staff.hight",
            usage = "info [jogador]"
    )
    public void handleInfo(Context<CommandSender> context, ProxiedPlayer player) {
        StringBuilder infoPlayer = new StringBuilder();
        infoPlayer.append("\n")
                .append(" §eInformações do jogador citado:")
                .append("\n")
                .append("\n")
                .append(" §8➟ §fJogador: §7" + player.getName())
                .append("\n")
                .append(" §8➟ §fServidor conectado: §7" + player.getServer().getInfo().getName().replace("-", " "))
                .append("\n")
                .append(" §8➟ §fPing no servidor: §7" + player.getPing())
                .append("\n")
                .append(" §8➟ §fEndereço de IP: §7" + player.getAddress().getAddress().getHostAddress())
                .append("\n");

        context.getSender().sendMessage(infoPlayer.toString());
    }
}
