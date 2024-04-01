package network.twisty.proxyserver.commands;

import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedDataManager;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.query.QueryOptions;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;

public class StaffChatCommand {

    @Command(
            name = "staffchat",
            permission = "world.staff",
            usage = "staffchat [mensagem]",
            aliases = {"staffchat", "sc", "s"}
    )
    public void handleStaffChat(Context<CommandSender> sender, String[] args) {
        String name = sender.getSender().getName();
        ProxiedPlayer proxiedPlayer = ProxyServer.getInstance().getPlayer(name);

        Server server = proxiedPlayer.getServer();

        StringBuilder stringBuilder = new StringBuilder();

        for(String arg : args) {
            stringBuilder.append(arg).append("");
        }
        String message = "";
        String serverName = server.getInfo().getName();
        for (int i = 0; i < args.length; ++i) {
            message = message + args[i] + " ";
        }
        for(User user : LuckPermsProvider.get().getUserManager().getLoadedUsers()) {
            CachedDataManager userData = user.getCachedData();
 
            QueryOptions contexts = QueryOptions.defaultContextualOptions();
            CachedMetaData metaData = userData.getMetaData(contexts);

            ProxiedPlayer proxiesUser = ProxyServer.getInstance().getPlayer(user.getUniqueId());
            proxiesUser.sendMessage("§d§l[S] §7(" + serverName + ") " + metaData.getPrefix().replace("&", "§") + name + "§7: §f" + message);
        }
    }
}
