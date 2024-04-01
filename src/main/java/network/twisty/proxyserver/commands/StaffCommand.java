package network.twisty.proxyserver.commands;

import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedDataManager;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.cacheddata.CachedPermissionData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.query.QueryOptions;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;

public class StaffCommand {

    @Command(
            name = "staff",
            aliases = {"staffs"}
    )
    public void handleStaff(Context<CommandSender> context) {
        QueryOptions queryOptions = QueryOptions.defaultContextualOptions();
        ProxyServer instance = ProxyServer.getInstance();

        StringBuilder message = new StringBuilder();

        int count = 0;

        for(User user : LuckPermsProvider.get().getUserManager().getLoadedUsers()) {
            CachedDataManager cachedData = user.getCachedData();
            CachedPermissionData permissionData = cachedData.getPermissionData(queryOptions);

            if(!permissionData.checkPermission("").asBoolean()) continue;

            ProxiedPlayer player = instance.getPlayer(user.getUniqueId());
            String serverName = player.getServer().getInfo().getName();

            Server server;

            CachedMetaData metaData = cachedData.getMetaData(queryOptions);

            count++;

            if(count == 1) {
                 message.append("\n")
                        .append(" §eMembro da equipe conectados:")
                        .append("\n");

            }
            message.append("")
                    .append("\n")
                    .append("§7(" + player.getServer().getInfo().getName().replace("-", " ") +"§7) " + metaData.getPrefix().replace("¨&" ,"§"))
                    .append(user.getFriendlyName())
                    .append("");

        }
        if(count == 0) {
            message.append("\n")
                    .append("§c Nenhum membro da equipe disponível :(");

        }
        message.append("\n");
        context.sendMessage(message.toString());

    }
}
