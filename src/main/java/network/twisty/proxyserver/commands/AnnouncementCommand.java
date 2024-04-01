package network.twisty.proxyserver.commands;

import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.query.QueryOptions;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class AnnouncementCommand {
    @Command(
            name = "alert",
            usage = "alerta [aviso]",
            aliases = {"alerta", "aviso"},
            permission = " "
    )
    public void handleAlert(Context<CommandSender> context, String[] messageArray) {
        String messageSplit = String.join(" ", messageArray);
        ComponentBuilder builder = new ComponentBuilder("");

        String message = messageSplit.replace("&", "§");
        builder.append("\n")
                .append("§8§l 4WORLD §8➟ ");

        if(messageSplit.length() > 1) {
            String executable = messageSplit;
            ClickEvent.Action action = ClickEvent.Action.OPEN_URL;

            if(executable.startsWith("/")) {
                action = ClickEvent.Action.RUN_COMMAND;
            } else if(!executable.startsWith("https://")) {
                executable = "https://" + executable;
            }
            ClickEvent event = new ClickEvent(action, executable);

            builder.event(event)
                    .append("§f" + message)
                    .event(event);
        } else builder.append("§f" + message);
        builder.append("\n");
        ProxyServer.getInstance().broadcast(builder.create());
    }
    @Command(
            name = "say"
    )
    public void handleSay(Context<CommandSender> context, String[] messageArray) {
        String name = context.getSender().getName();
        User user = LuckPermsProvider.get().getUserManager().getUser(name);

        if(user == null) return;

        CachedMetaData metaData = user
                .getCachedData()
                .getMetaData(QueryOptions.defaultContextualOptions());

        String[] messageSplit = String.join(" ", messageArray).split("\\|");
        ComponentBuilder builder = new ComponentBuilder("");

        String message = messageSplit[0].replace("&", "§");
        builder.append("\n")
                .append("§f" + metaData.getPrefix().replace("&", "§") + name);

        if(messageSplit.length > 1) {
            String executable = messageSplit[1];
            ClickEvent.Action action = ClickEvent.Action.OPEN_URL;

            if (executable.startsWith("/")) {
                action = ClickEvent.Action.RUN_COMMAND;
            } else if (!executable.startsWith("https://")) {
                executable = "https://" + executable;

            }
            ClickEvent event = new ClickEvent(action, executable);

            builder.event(event)
                    .append(": ")
                    .event(event)
                    .append("§f" + message)
                    .event(event);
        } else builder.append(": ").append("§f" + message);

        builder.append("\n");

        ProxyServer.getInstance().broadcast(builder.create());
    }
    @Command(
            name = "video",
            aliases = {"divulgar"},
            usage = "video [link]",
            permission = "tag.yt"
    )
    public void handleVideo(Context<CommandSender> context, String link) {
        String name = context.getSender().getName();
        User user = LuckPermsProvider.get().getUserManager().getUser(name);

        if(user == null) return;

        CachedMetaData metaData = user
                .getCachedData()
                .getMetaData(QueryOptions.defaultContextualOptions());

        ComponentBuilder builder = new ComponentBuilder("");

        if(!link.startsWith("https://")) link = "https://" + link;

        ClickEvent event = new ClickEvent(ClickEvent.Action.OPEN_URL, link);

        builder.append("\n")
                .append("§6§lVÍDEO! ")
                .append("§fO " + metaData.getPrefix() + name)
                .event(event)
                .append(" acaba de postar um vídeo, clique aqui para acessar!")
                .event(event)
                .append("\n");

        ProxyServer.getInstance().broadcast(builder.create());
    }
    @Command(
            name = "live",
            usage = "live [link]",
            permission = "world.yt"
    )
    public void handleLive(Context<CommandSender> context, String link) {
        String name = context.getSender().getName();
        User user = LuckPermsProvider.get().getUserManager().getUser(name);

        if(user == null) return;

        CachedMetaData metaData = user
                .getCachedData()
                .getMetaData(QueryOptions.defaultContextualOptions());

        ComponentBuilder builder = new ComponentBuilder("");

        if(!link.startsWith("https://")) link = "https://" + link;

        ClickEvent event = new ClickEvent(ClickEvent.Action.OPEN_URL, link);

        builder.append("\n")
                .append("§6§lLIVE! ")
                .append("§fO " + metaData.getPrefix() + name)
                .event(event)
                .append(" está em live. clique aqui para visualizar!")
                .event(event)
                .append("\n");

        ProxyServer.getInstance().broadcast(builder.create());
    }

}
