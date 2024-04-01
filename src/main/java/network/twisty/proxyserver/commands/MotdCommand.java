package network.twisty.proxyserver.commands;

import network.twisty.proxyserver.configuration.manager.ConfigurationManager;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.md_5.bungee.api.CommandSender;

public class MotdCommand {
    @Command(
            name = "motd.list",
            permission = "world.staff.hight"
    )
    public void handleMotd(Context<CommandSender> context) {
        CommandSender sender = context.getSender();

        sender.sendMessage(
                String.format(
                        "§eMOTD disponível atualmente:" +
                                "\n" +
                                "\n" +
                                "" + ConfigurationManager.configuration.get("motd")
                )
        );
    }
    @Command(
            name = "motd",
            permission = "world.staff.hight",
            usage = "motd [mensagem]"
    )
    public void handleMotd(Context<CommandSender> context, String[] args) {
        CommandSender sender = context.getSender();
        if(args.length > 0) {
            String header = "§8§l4WORLD §7[1.8.X] §floja.44world.com\n";
            String message = "";
            for(int i = 0; i < args.length; ++i) {
                message = message + args[i] + " ";
            }
            String motd = header + message;
            ConfigurationManager.configuration.set("motd", motd);
            ConfigurationManager.saveConfig();
            sender.sendMessage("§aMensagem da motd alterada para: " + message);
        }
    }
}
