package network.twisty.proxyserver.commands;

import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.md_5.bungee.api.CommandSender;

public class WebCommand {

    @Command(
            name = "site",
            aliases = {"dc", "twitter", "web", "website"}
    )
    public void handleDiscord(Context<CommandSender> context) {
        val sender = (CommandSender) context.getSender();
        StringBuilder find = new StringBuilder();
        find.append("\n")
                .append("§e Rede sociais do servidor:")
                .append("\n")
                .append("\n")
                .append(" §fWebsite: §7loja.44world.com")
                .append("\n")
                .append(" §fDiscord: §ediscord.gg/44world")
                .append("\n");

        sender.sendMessage(find.toString());

    }
}
